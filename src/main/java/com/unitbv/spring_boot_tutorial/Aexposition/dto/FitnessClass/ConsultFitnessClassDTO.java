package com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Getter
public class ConsultFitnessClassDTO {
    private String id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String coachName;

}