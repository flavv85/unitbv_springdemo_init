package com.unitbv.spring_boot_tutorial.Aexposition.dto.Members;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateUpdateMemberDTO {
    public String name;
    public String nickName;
}
