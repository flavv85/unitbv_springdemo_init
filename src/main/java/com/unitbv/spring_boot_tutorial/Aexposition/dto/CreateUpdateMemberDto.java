package com.unitbv.spring_boot_tutorial.Aexposition.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateUpdateMemberDto {

    public String name;
    public String getName() {
        return name;
    }

    public String nickname;
    public String getNickname() {
        return nickname;
    }
}
