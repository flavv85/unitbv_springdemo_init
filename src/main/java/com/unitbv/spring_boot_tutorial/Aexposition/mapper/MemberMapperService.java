package com.unitbv.spring_boot_tutorial.Aexposition.mapper;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.ConsultCoachDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.ConsultMemberDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.CreateUpdateMemberDto;
import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Service
public class MemberMapperService {

    public ConsultMemberDto mapFromDomain(Member member){
        return ConsultMemberDto
                .builder()
                .id(member.getId())
                .name(member.getName())
                .nickname(member.getNickname())
                .build();

    }
    public Member mapToEntity(CreateUpdateMemberDto dto, String id) {
        Member member = new Member();
        member.setId(StringUtils.hasText(id) ? id : String.valueOf(UUID.randomUUID()));
        member.setName(dto.getName());
        member.setNickname(dto.getNickname());
        return member;
    }
}