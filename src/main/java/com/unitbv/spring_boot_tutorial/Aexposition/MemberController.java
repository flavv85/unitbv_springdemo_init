package com.unitbv.spring_boot_tutorial.Aexposition;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.ConsultMemberDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.CreateUpdateMemberDto;
import com.unitbv.spring_boot_tutorial.Aexposition.mapper.MemberMapperService;
import com.unitbv.spring_boot_tutorial.Bapplication.coach.*;
import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    ConsultAllMembers consultAllMembers;
    MemberMapperService memberMapperService;
    CreateMember createMember;
    ConsultMemberById consultMemberById;
    ConsultAllMembersByName consultAllMembersByName;
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
    public ResponseEntity<Void> create(@RequestBody CreateUpdateMemberDto dto)
    {
        Member toBePersistedMember = memberMapperService.mapToEntity(dto, null);
        createMember.create(toBePersistedMember);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<ConsultMemberDto> consultById(@PathVariable String memberId)
    {
        return new ResponseEntity<>(memberMapperService.mapFromDomain(consultMemberById.consult(memberId)), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<ConsultMemberDto>> consultAllByName(@PathVariable String name)
    {
        List<Member> memberList = consultAllMembersByName.consultByName(name);
        List<ConsultMemberDto> consultMemberDtoList = memberList.stream().map(member -> memberMapperService.mapFromDomain(member)).toList();
        return ResponseEntity.ok(consultMemberDtoList);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ConsultMemberDto> updateMember(@PathVariable String id, @RequestBody CreateUpdateMemberDto dto)
    {
        Member toBePersistedMember = memberMapperService.mapToEntity(dto, id);
        updateMember.update(toBePersistedMember);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-by-id/{id}")
    public ResponseEntity<Void> deleteMemberById(@PathVariable(value = "id") String id)
    {
        deleteMember.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable(value = "id") String id)
    {
        deleteMember.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
