package com.unitbv.spring_boot_tutorial.Aexposition.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class FitnessClassDto {

    Long id;
    String name;
    String description;
}
