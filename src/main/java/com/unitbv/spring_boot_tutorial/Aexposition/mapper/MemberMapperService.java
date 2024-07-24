package com.unitbv.spring_boot_tutorial.Aexposition.mapper;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.Member.ConsultMembersDTO;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.Member.CreateUpdateMemberDTO;
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
    public ConsultMembersDTO mapFromDomain(Member member) {
        return  ConsultMembersDTO
                .builder()
                .id(member.getId())
                .name(member.getName())
                .nickname(member.getNickname())
                .build();
    }
    public Member mapToEntity(CreateUpdateMemberDTO dto, String memberID) {
        Member member = new Member();
        member.setId(StringUtils.hasText(memberID) ? memberID : String.valueOf(UUID.randomUUID()));
        member.setName(dto.getName());
        member.setNickname(dto.getNickName());
        return member;
    }
}