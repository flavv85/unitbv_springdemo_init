package com.unitbv.spring_boot_tutorial.Aexposition.mapper;


import com.unitbv.spring_boot_tutorial.Aexposition.dto.ConsultMemberDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.CreateUpdateMemberDto;
import com.unitbv.spring_boot_tutorial.Bapplication.coach.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public List<ConsultMemberDto> getAll() {
        return memberService.getAll();
    }

    @GetMapping("/{id}")
    public ConsultMemberDto getById(@PathVariable Long id) {
        return memberService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody CreateUpdateMemberDto createUpdateMemberDto) {
        memberService.create(createUpdateMemberDto);
    }
}
