package com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClass;

import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@Builder
@Getter
public class ConsultFitnessClassDto {
    String id;
    LocalDateTime startTime;

    LocalDateTime endTime;

}
