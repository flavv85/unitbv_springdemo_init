package com.unitbv.spring_boot_tutorial.Aexposition.mapper;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClassDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.CreateUpdateFitnessClassDto;
import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.CoachRepository;
import lombok.AllArgsConstructor;
import org.flywaydb.core.internal.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class FitnessClassMapperService {

    CoachRepository coachRepository;

    public FitnessClassDto mapFromDomain(FitnessClass fitnessClass) {
        return new FitnessClassDto(
                fitnessClass.getId(),
                fitnessClass.getStartTime(),
                fitnessClass.getEndTime(),
                fitnessClass.getCoach() != null ? fitnessClass.getCoach().getName() : null
        );
    }

    public FitnessClass mapToEntity(CreateUpdateFitnessClassDto dto, String fitnessClassId) {
        FitnessClass fitnessClass = new FitnessClass();
        fitnessClass.setId(StringUtils.hasText(fitnessClassId) ? fitnessClassId : String.valueOf(UUID.randomUUID()));
        fitnessClass.setStartTime(dto.getStartTime());
        fitnessClass.setEndTime(dto.getEndTime());

        if (StringUtils.hasText(dto.getCoachId())) {
            Coach coach = coachRepository.findById(dto.getCoachId()).orElse(null);
            fitnessClass.setCoach(coach);
        } else {
            fitnessClass.setCoach(null);
        }

        return fitnessClass;
    }
}
