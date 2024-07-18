package com.unitbv.spring_boot_tutorial.Aexposition.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultFitnessClassDto {
    private String id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String coachName;
}