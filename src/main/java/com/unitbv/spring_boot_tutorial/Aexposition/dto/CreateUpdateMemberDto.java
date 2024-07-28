package com.unitbv.spring_boot_tutorial.Aexposition.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUpdateMemberDto {
    public String name;
    public String nickname;
}
