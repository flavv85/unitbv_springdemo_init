package com.unitbv.spring_boot_tutorial.Aexposition.dto.Member;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateUpdateMemberDTO {
    public String name;
    public String nickname;
}