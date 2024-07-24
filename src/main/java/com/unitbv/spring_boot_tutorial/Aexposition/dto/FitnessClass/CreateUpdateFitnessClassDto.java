package com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClass;


import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class CreateUpdateFitnessClassDto {
    public String startTime;
    public String endTime;
    public String coachId;
}