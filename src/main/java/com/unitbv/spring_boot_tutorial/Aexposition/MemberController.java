package com.unitbv.spring_boot_tutorial.Aexposition;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.Coach.ConsultCoachDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.Coach.CreateUpdateCoachDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.Member.ConsultMemberDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.Member.CreateUpdateMemberDto;
import com.unitbv.spring_boot_tutorial.Aexposition.mapper.MemberMapperService;
import com.unitbv.spring_boot_tutorial.Bapplication.member.*;
import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/members")

public class MemberController {

    ConsultAllMembers consultAllMembers;

    MemberService memberService;

    CreateMember createMember;

    MemberMapperService memberMapperService;

    UpdateMember updateMember;

    DeleteMember deleteMember;

    @GetMapping
    public ResponseEntity<List<ConsultMemberDto>> consultAll()
    {
        List<Member> members = consultAllMembers.consultAll();
        List<ConsultMemberDto> memberDtoList = members.stream().map(memberMapperService::mapFromDomain).toList();
        return new ResponseEntity<>(memberDtoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateUpdateMemberDto dto) {
        Member toBePersistedMember = memberMapperService.mapToEntity(dto, null);
        createMember.create(toBePersistedMember);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultMemberDto> getMemberById(@PathVariable String id)
    {
        Optional<Member> member = memberService.getMemberById(id);
        ConsultMemberDto consultMemberDto = memberMapperService.mapFromDomain(member.get());
        return new ResponseEntity<>(consultMemberDto, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ConsultMemberDto> updateMember(
            @PathVariable String id,
            @RequestBody CreateUpdateMemberDto dto) {
        Member toBeUpdatedMember = memberMapperService.mapToEntity(dto, id);
        updateMember.update(toBeUpdatedMember);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCoach(@PathVariable(value = "id") String id) {
        deleteMember.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
