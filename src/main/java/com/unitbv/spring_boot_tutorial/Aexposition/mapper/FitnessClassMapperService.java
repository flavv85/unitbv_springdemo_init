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
import java.util.UUID;
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Service
public class FitnessClassMapperService {
    CoachRepository coachRepository;
    public ConsultFitnessClassDTO mapFromDomain(FitnessClass fitnessClass) {
        return ConsultFitnessClassDTO.builder()
                .id(fitnessClass.getId())
                .coachID( fitnessClass.getCoach() != null ? fitnessClass.getCoach().getId() : null)
                .startDate(fitnessClass.getStartTime())
                .endDate(fitnessClass.getEndTime())
                .build();
    }

    public FitnessClass mapToEntity(CreateUpdateFitnessClassDto dto, String fitnessClassID) {
        FitnessClass fitnessClass = new FitnessClass();
        fitnessClass.setId(StringUtils.hasText(fitnessClassID) ? fitnessClassID : String.valueOf(UUID.randomUUID()));
        fitnessClass.setStartTime(LocalDateTime.parse(dto.startTime));
        fitnessClass.setEndTime(LocalDateTime.parse(dto.endTime));
        if (StringUtils.hasText(dto.coachId)) {
            Coach coach = coachRepository.findById(dto.coachId).orElse(null);
            fitnessClass.setCoach(coach);
        } else {
            fitnessClass.setCoach(null);
        }

        return fitnessClass;
    }
}