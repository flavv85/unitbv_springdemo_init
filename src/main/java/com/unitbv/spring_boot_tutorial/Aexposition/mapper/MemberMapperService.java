package com.unitbv.spring_boot_tutorial.Aexposition.mapper;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.ConsultMemberDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.CreateUpdateMemberDto;
import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import org.springframework.stereotype.Service;

@Service
public class MemberMapperService {

    public ConsultMemberDto mapFromDomain(Member member) {
        return ConsultMemberDto.builder()
                .id(member.getId())
                .name(member.getName())
                .nickname(member.getNickname())
                .build();
    }

    public Member mapToEntity(CreateUpdateMemberDto dto, Member existingMember) {
        if (existingMember == null) {
            existingMember = new Member();
        }
        existingMember.setId(dto.getId());
        existingMember.setName(dto.getName());
        existingMember.setNickname(dto.getNickname());
        return existingMember;
    }
}
