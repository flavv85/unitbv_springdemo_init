package com.unitbv.spring_boot_tutorial.Aexposition.dto;

import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Getter
public class ConsultFitnessClassDto {
    String id;
    LocalDateTime startTime;
    LocalDateTime endTime;
}