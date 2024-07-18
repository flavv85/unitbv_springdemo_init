package com.unitbv.spring_boot_tutorial.Aexposition;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.ConsultMemberDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.CreateUpdateMemberDto;
import com.unitbv.spring_boot_tutorial.Aexposition.mapper.MemberMapperService;
import com.unitbv.spring_boot_tutorial.Bapplication.member.ConsultAllMembers;
import com.unitbv.spring_boot_tutorial.Bapplication.member.CreateMember;
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
}
