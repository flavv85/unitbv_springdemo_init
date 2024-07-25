package com.unitbv.spring_boot_tutorial.Aexposition.mapper;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.Member.ConsultMemberDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.Member.CreateUpdateMemberDto;
import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class MemberMapperService {

    public ConsultMemberDto mapFromDomain(Member member)
    {
        return ConsultMemberDto.
                builder().
                id(member.getId())
                .name(member.getName())
                .nickname(member.getNickname())
                .build();
    }

    public Member mapToEntity(CreateUpdateMemberDto dto, String memberId)
    {
        Member member = new Member();
        member.setId(StringUtils.hasText(memberId) ? memberId : String.valueOf(UUID.randomUUID()));
        member.setName(dto.name);
        member.setNickname(dto.nickname);
        return member;
    }


}
