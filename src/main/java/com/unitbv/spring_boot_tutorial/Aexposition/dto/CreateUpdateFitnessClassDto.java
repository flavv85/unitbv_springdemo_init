package com.unitbv.spring_boot_tutorial.Aexposition.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CreateUpdateFitnessClassDto {
    String startTime;
    String endTime;
    String coachId;
}
