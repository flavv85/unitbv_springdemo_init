package com.unitbv.spring_boot_tutorial.Aexposition.dto.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class MemberDTO {
    String id;
    String nickname;
}