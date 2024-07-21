package com.unitbv.spring_boot_tutorial.Aexposition.dto.Coach;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClassCoachDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
public class ConsultCoachDto {
    String id;
    String name;
    // return also the details of fitness class of coach
    public List<FitnessClassCoachDetailsDto> fitnessClasses;

}
