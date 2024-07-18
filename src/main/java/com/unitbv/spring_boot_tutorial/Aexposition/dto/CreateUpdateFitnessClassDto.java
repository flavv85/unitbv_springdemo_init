package com.unitbv.spring_boot_tutorial.Aexposition.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateUpdateFitnessClassDto {
    public String id;

    public String getId() {
        return id;
    }
}
