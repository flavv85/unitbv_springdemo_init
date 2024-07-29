package com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClass;

import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@Builder
@Getter
public class ConsultFitnessClassDTO {
    private String id;
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String coachName;
    private Set<String> members;

}