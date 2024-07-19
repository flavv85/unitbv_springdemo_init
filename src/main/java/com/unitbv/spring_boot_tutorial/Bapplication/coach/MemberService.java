package com.unitbv.spring_boot_tutorial.Bapplication.coach;


import com.unitbv.spring_boot_tutorial.Aexposition.dto.*;
import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<ConsultMemberDto> getAll() {
        return memberRepository.findAll().stream().map(member ->
                ConsultMemberDto.builder()
                        .id(Long.valueOf(member.getId()))
                        .name(member.getName())
                        .build()
        ).collect(Collectors.toList());
    }

    public ConsultMemberDto getById(Long id) {
        Member member = memberRepository.findById(String.valueOf(id)).orElseThrow(() -> new RuntimeException("Member not found"));
        return ConsultMemberDto.builder()
                .id(Long.valueOf(member.getId()))
                .name(member.getName())
                .build();
    }

    public void create(CreateUpdateMemberDto createUpdateMemberDto) {
        Member member = Member.builder()
                .name(createUpdateMemberDto.getName())
                .build();
        memberRepository.save(member);
    }
}
