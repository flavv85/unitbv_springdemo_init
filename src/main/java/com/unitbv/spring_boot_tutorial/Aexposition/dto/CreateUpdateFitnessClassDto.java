package com.unitbv.spring_boot_tutorial.Aexposition.dto;

import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateUpdateFitnessClassDto {
    String id;
    LocalDateTime startTime;
    LocalDateTime endTime;
    Coach coach;
}
