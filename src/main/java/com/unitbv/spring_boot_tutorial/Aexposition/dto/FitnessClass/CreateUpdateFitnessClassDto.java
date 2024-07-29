package com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClass;


import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class CreateUpdateFitnessClassDto {
    String name;
    String startTime;
    String endTime;
    String coachId;
    Set<Member> members;
}