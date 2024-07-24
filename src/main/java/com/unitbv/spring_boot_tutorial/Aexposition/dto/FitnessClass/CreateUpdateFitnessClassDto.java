package com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClass;


import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class CreateUpdateFitnessClassDto {
    String startTime;
    String endTime;
    String coachId;
}