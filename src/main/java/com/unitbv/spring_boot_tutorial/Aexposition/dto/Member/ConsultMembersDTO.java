package com.unitbv.spring_boot_tutorial.Aexposition.dto.Member;

import com.unitbv.spring_boot_tutorial.Ddomain.MemberStatus;
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
    String status;
}