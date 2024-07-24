package com.unitbv.spring_boot_tutorial.Aexposition.mapper;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.Coach.ConsultCoachDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.Coach.CreateUpdateCoachDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClass.FitnessClassCoachDetailsDto;
import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Service
public class CoachMapperService {

    public ConsultCoachDto mapFromDomain(Coach coach) {
        return ConsultCoachDto
                .builder()
                .id(coach.getId())
                .name(coach.getName())
                // note: we are using key word this because we call a private method in this class (same class)
                .fitnessClasses(coach.getFitnessClasses().stream().map(this::mapFitnessClassFromDomain).toList())
                .build();
    }

    private FitnessClassCoachDetailsDto mapFitnessClassFromDomain(FitnessClass fitnessClass) {
        FitnessClassCoachDetailsDto fitnessClassCoachDetailsDto = new FitnessClassCoachDetailsDto();
        fitnessClassCoachDetailsDto.setId(fitnessClass.getId());
        fitnessClassCoachDetailsDto.setDuration(fitnessClassCoachDetailsDto.appendHourToDuration(String.valueOf(fitnessClass.duration())));
        return fitnessClassCoachDetailsDto;
    }

    public Coach mapToEntity(CreateUpdateCoachDto dto, String coachId) {
        Coach coach = new Coach();
        coach.setId(StringUtils.hasText(coachId) ? coachId : String.valueOf(UUID.randomUUID()));
        coach.setName(dto.getName());
        List<FitnessClass> fitnessClasses = new ArrayList<>();

        // when creating or updating a coach entity we the user also sends data for fitness class/es
        // we need to transform those also from dto to entity in order to save them together with the coach entity
        if (!CollectionUtils.isEmpty(dto.getFitnessClasses())) {
            dto.getFitnessClasses().forEach(fitnessClass -> {
                FitnessClass newFitnessClass = FitnessClass
                        .builder()
                        .id(UUID.randomUUID().toString())
                        .coach(coach)
                        .startTime(ObjectUtils.isEmpty(fitnessClass.getStartTime()) ? null : LocalDateTime.parse(fitnessClass.getStartTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")))
                        .endTime(ObjectUtils.isEmpty(fitnessClass.getEndTime()) ? null : LocalDateTime.parse(fitnessClass.getEndTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")))
                        .build();
                fitnessClasses.add(newFitnessClass);
            });
        }
        coach.setFitnessClasses(fitnessClasses);
        return coach;
    }

}