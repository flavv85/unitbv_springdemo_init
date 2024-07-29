package com.unitbv.spring_boot_tutorial.Aexposition.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsultMemberDto {
    private String id;
    private String name;
    private String nickname;
}