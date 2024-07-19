package com.unitbv.spring_boot_tutorial.Aexposition.mapper;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.ConsultFitnessClassDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.CreateUpdateFitnessClassDto;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.flywaydb.core.internal.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Service

public class FitnessClassMapperService {
    public ConsultFitnessClassDto mapFromDomain(FitnessClass fitnessClass) {
        return ConsultFitnessClassDto
                .builder()
                .id(fitnessClass.getId())
                .startTime(fitnessClass.getStartTime())
                .endTime(fitnessClass.getEndTime())
                .build();
    }


    public FitnessClass mapToEntity(CreateUpdateFitnessClassDto dto, String id){
        FitnessClass fitnessClass = new FitnessClass();
        fitnessClass.setId(StringUtils.hasText(id) ? id : String.valueOf(UUID.randomUUID()));
        fitnessClass.setId(dto.getId());

        return fitnessClass;
    }
}
