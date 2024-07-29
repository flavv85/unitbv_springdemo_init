package com.unitbv.spring_boot_tutorial.Aexposition.mapper;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClass.ConsultFitnessClassDTO;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClass.CreateUpdateFitnessClassDto;
import com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.CoachRepository;
import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Service
public class FitnessClassMapperService {

    CoachRepository coachRepository;

    public ConsultFitnessClassDTO mapFromDomain(FitnessClass fitnessClass) {
        Set<String> members = new HashSet<>();
        for(var member:fitnessClass.getMembers()) {
            members.add(member.getNickname());
        }
        return ConsultFitnessClassDTO.builder()
                .coachName(fitnessClass.getCoach().getName())
                .members(members)
                .id(fitnessClass.getId())
                .startTime(fitnessClass.getStartTime())
                .endTime(fitnessClass.getEndTime())
                .build();
    }

    public FitnessClass mapToEntity(CreateUpdateFitnessClassDto dto, String fitnessClassId) {
        FitnessClass fitnessClass = new FitnessClass();
        fitnessClass.setId(StringUtils.hasText(fitnessClassId) ? fitnessClassId : String.valueOf(UUID.randomUUID()));
        fitnessClass.setStartTime(LocalDateTime.parse(dto.getStartTime()));
        fitnessClass.setEndTime(LocalDateTime.parse(dto.getEndTime()));

        if (StringUtils.hasText(dto.getCoachId())) {
            Coach coach = coachRepository.findById(dto.getCoachId()).orElse(null);
            fitnessClass.setCoach(coach);
        } else {
            fitnessClass.setCoach(null);
        }

        return fitnessClass;
    }
}