package com.unitbv.spring_boot_tutorial.Aexposition.mapper;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.ConsultFitnessClassDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.CreateUpdateFitnessClassDto;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FitnessClassMapperService {

    public ConsultFitnessClassDto mapFromDomain(FitnessClass fitnessClass) {
        return ConsultFitnessClassDto
                .builder()
                .id(fitnessClass.getId())
                .startTime(fitnessClass.getStartTime())
                .endTime(fitnessClass.getEndTime())
                .build();
    }

    public FitnessClass mapToEntity(CreateUpdateFitnessClassDto dto, String fitnessClassId) {
        FitnessClass fitnessClass = new FitnessClass();
        fitnessClass.setId(StringUtils.hasLength(fitnessClassId) ? fitnessClassId : String.valueOf(UUID.randomUUID()));
        fitnessClass.setStartTime(dto.getStartTime());
        fitnessClass.setEndTime(dto.getEndTime());
        return fitnessClass;
    }
}
