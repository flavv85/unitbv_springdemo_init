package com.unitbv.spring_boot_tutorial.Aexposition.mapper;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.Coaches.ConsultCoachDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.Coaches.CreateUpdateCoachDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClasses.ConsultFitnessClassDTO;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClasses.CreateUpdateFitnessClassDTO;
import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Service
public class FitnessClassMapperService {
    public ConsultFitnessClassDTO mapFromDomain(FitnessClass fitnessClass) {
        return ConsultFitnessClassDTO.builder()
                .id(fitnessClass.getId())
                .coachID(fitnessClass.getCoach().getId())
                .startDate(fitnessClass.getStartTime())
                .endDate(fitnessClass.getEndTime())
                .build();
    }

    public FitnessClass mapToEntity(CreateUpdateFitnessClassDTO dto, String fitnessClassID) {
        FitnessClass fitnessClass = new FitnessClass();
        fitnessClass.setId(StringUtils.hasText(fitnessClassID) ? fitnessClassID : String.valueOf(UUID.randomUUID()));
        fitnessClass.setStartTime(dto.startTime);
        fitnessClass.setEndTime(dto.endTime);
        fitnessClass.setCoach(null);
        return fitnessClass;
    }
}
