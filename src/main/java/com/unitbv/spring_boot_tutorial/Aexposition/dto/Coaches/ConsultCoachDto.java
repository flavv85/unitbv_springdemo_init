package com.unitbv.spring_boot_tutorial.Aexposition.dto.Coaches;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class ConsultCoachDto {
    String id;
    String name;
}
