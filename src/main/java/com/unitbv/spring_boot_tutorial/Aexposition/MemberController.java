package com.unitbv.spring_boot_tutorial.Aexposition;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.ConsultMemberDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.CreateUpdateMemberDto;
import com.unitbv.spring_boot_tutorial.Aexposition.mapper.MemberMapperService;
import com.unitbv.spring_boot_tutorial.Bapplication.member.*;
import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    ConsultAllMembers consultAllMembers;
    MemberMapperService memberMapperService;
    CreateMember createMember;
    UpdateMember updateMember;
    DeleteMember deleteMember;
    ConsultMemberById consultMemberById;
    ConsultAllMembersByName consultAllMembersByName;


    @GetMapping
    public ResponseEntity<List<ConsultMemberDto>> consultAll() {
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
    public ResponseEntity<ConsultMemberDto> getById(@PathVariable String id) {
        Optional<Member> member = consultAllMembers.consultById(id);
        if (member.isPresent()) {
            ConsultMemberDto memberDto = memberMapperService.mapFromDomain(member.get());
            return new ResponseEntity<>(memberDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<List<ConsultMemberDto>> consultAllByName(@PathVariable String name) {
        List<Member> memberList = consultAllMembersByName.consultByName(name);
        List<ConsultMemberDto> consultMemberDtoList = memberList.stream().map(member -> memberMapperService.mapFromDomain(member)).toList();
        return ResponseEntity.ok(consultMemberDtoList);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ConsultMemberDto> updateMember(
            @PathVariable String id,
            @RequestBody CreateUpdateMemberDto dto) {
        Member toBeUpdatedMember = memberMapperService.mapToEntity(dto, id);
        updateMember.update(toBeUpdatedMember);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-by-id/{id}")
    public ResponseEntity<Void> deleteMemberById(@PathVariable(value = "id") String id) {
        deleteMember.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable(value = "id") String id) {
        deleteMember.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}