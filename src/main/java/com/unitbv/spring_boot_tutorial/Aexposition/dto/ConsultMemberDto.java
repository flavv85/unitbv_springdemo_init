package com.unitbv.spring_boot_tutorial.Aexposition.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultMemberDto {
    private String id;
    private String name;
    private String nickname;
}