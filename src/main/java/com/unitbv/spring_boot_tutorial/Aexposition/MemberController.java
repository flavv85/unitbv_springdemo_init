package com.unitbv.spring_boot_tutorial.Aexposition;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.ConsultMemberDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.CrateUpdateMemberDto;
import com.unitbv.spring_boot_tutorial.Aexposition.mapper.MemberMapperService;
import com.unitbv.spring_boot_tutorial.Bapplication.ConsultAllMembers;
import com.unitbv.spring_boot_tutorial.Bapplication.ConsultByIdMember;
import com.unitbv.spring_boot_tutorial.Bapplication.CreateMember;
import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    ConsultAllMembers consultAllMembers;
    MemberMapperService memberMapperService;
    CreateMember createMember;
    ConsultByIdMember consultByIdMember;

    @GetMapping
    public ResponseEntity<List<ConsultMemberDto>> consultAll() {
        List<Member> members = consultAllMembers.consultAll();
        List<ConsultMemberDto> memberDtoList = members.stream().map(memberMapperService::mapFromDomain).toList();
        return new ResponseEntity<>(memberDtoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CrateUpdateMemberDto dto) {
        Member toBePersistedMember = memberMapperService.mapToEntity(dto, null);
        createMember.create(toBePersistedMember);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<ConsultMemberDto> ConsultByIdCoach(@PathVariable String id) {
        Member member = consultByIdMember.consultById(id);
        ConsultMemberDto memberDto = memberMapperService.mapFromDomain(member);
        return new ResponseEntity<>(memberDto, HttpStatus.OK);
    }


}
