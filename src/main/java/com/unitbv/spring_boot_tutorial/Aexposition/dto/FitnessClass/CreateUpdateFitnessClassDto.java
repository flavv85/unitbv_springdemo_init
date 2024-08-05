package com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClass;


import com.unitbv.spring_boot_tutorial.Aexposition.dto.Member.MemberDTO;
import lombok.*;

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
    Set<MemberDTO> members;
}