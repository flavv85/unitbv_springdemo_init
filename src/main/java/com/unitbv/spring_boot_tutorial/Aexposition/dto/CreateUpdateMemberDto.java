package com.unitbv.spring_boot_tutorial.Aexposition.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateUpdateMemberDto {
    public String id;
    public String name;
    public String nickname;

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getNickname(){
        return nickname;
    }
}
