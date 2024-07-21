package com.unitbv.spring_boot_tutorial.Aexposition.dto.Coach;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.CreateUpdateFitnessClassDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateUpdateCoachDto {
    public String name;
    public List<CreateUpdateFitnessClassDto> fitnessClasses;
}
