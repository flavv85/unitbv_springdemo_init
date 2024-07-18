package com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClasses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Getter
public class ConsultFitnessClassDTO {
    String id;
    String coachID;
    LocalDateTime startDate;
    LocalDateTime endDate;

}
