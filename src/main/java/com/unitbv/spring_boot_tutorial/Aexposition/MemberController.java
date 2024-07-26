package com.unitbv.spring_boot_tutorial.Aexposition;


import com.unitbv.spring_boot_tutorial.Aexposition.dto.Member.ConsultMemberDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.Member.CreateUpdateMemberDto;
import com.unitbv.spring_boot_tutorial.Aexposition.mapper.MemberMapperService;
import com.unitbv.spring_boot_tutorial.Bapplication.member.*;
import com.unitbv.spring_boot_tutorial.Bapplication.member.ConsultAllMembersByFitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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
    ConsultAllMembersByFitnessClass consultAllMembersByFitnessClass;
    UpdateNickname updateNickname;

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

    @GetMapping("/fitnessclass/{fitnessClassId}")
    public ResponseEntity<List<ConsultMemberDto>> getAllMembersFromFitnessClass(@PathVariable String fitnessClassId)
    {
        Set<Member> members = consultAllMembersByFitnessClass.consultAllByFitnessClass(fitnessClassId);
        List<ConsultMemberDto> memberDtos = members.stream().map(member -> memberMapperService.mapFromDomain(member)).toList();
        return new ResponseEntity<>(memberDtos, HttpStatus.OK);
    }

    @PutMapping("/nickname/{memberId}")
    public ResponseEntity<Void> updateNickname(@PathVariable String memberId, @RequestBody String nickname)
    {
        updateNickname.updateNickname(memberId, nickname);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
