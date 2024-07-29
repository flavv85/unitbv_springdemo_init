package com.unitbv.spring_boot_tutorial.Aexposition.dto.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class ConsultMembersDTO {
    String id;
    String name;
    String nickname;
}