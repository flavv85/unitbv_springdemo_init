package com.unitbv.spring_boot_tutorial.Aexposition.mapper;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClass.ConsultFitnessClassDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClass.CreateUpdateFitnessClassDto;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FitnessClassMapper {
    public ConsultFitnessClassDto mapFromDomain(FitnessClass fitnessClass) {
        return ConsultFitnessClassDto
                .builder()
                .id(fitnessClass.getId())
                .coach(fitnessClass.getCoach())
                .endTime(fitnessClass.getEndTime())
                .members(fitnessClass.getMembers())
                .startTime(fitnessClass.getStartTime())
                .build();
    }

    public FitnessClass mapToEntity(CreateUpdateFitnessClassDto dto, String fitnessClassId) {
        FitnessClass fitnessClass = new FitnessClass();
        fitnessClass.setId(StringUtils.hasText(fitnessClassId) ? fitnessClassId : String.valueOf(UUID.randomUUID()));
        fitnessClass.setCoach(dto.getCoach());
        fitnessClass.setMembers(dto.getMembers());
        fitnessClass.setStartTime(dto.getStartTime());
        fitnessClass.setEndTime(dto.getEndTime());
        return fitnessClass;
    }
}
