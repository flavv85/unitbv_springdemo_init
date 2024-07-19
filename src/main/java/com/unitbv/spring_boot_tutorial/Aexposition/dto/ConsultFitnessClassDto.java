package com.unitbv.spring_boot_tutorial.Aexposition.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class ConsultFitnessClassDto {
    String id;
    LocalDateTime startTime;
    LocalDateTime endTime;
}
