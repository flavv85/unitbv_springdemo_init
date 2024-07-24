package com.unitbv.spring_boot_tutorial.Aexposition;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.Member.ConsultMembersDTO;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.Member.CreateUpdateMemberDTO;
import com.unitbv.spring_boot_tutorial.Aexposition.mapper.MemberMapperService;
import com.unitbv.spring_boot_tutorial.Bapplication.Member.ConsultAllMembers;
import com.unitbv.spring_boot_tutorial.Bapplication.Member.ConsultMembersById;
import com.unitbv.spring_boot_tutorial.Bapplication.Member.CreateUpdateMember;
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
    ConsultMembersById consultMembersById;
    CreateUpdateMember createMember;

    @GetMapping
    public ResponseEntity<List<ConsultMembersDTO>> consultAll() {
        List<Member> members = consultAllMembers.ConsultAll();
        List<ConsultMembersDTO> memberDtoList = members.stream().map(memberMapperService::mapFromDomain).toList();
        return new ResponseEntity<>(memberDtoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateUpdateMemberDTO dto) {
        Member toBePersistedMember = (Member) memberMapperService.mapToEntity(dto, null);
        createMember.CreateUpdateMember(toBePersistedMember);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultMembersDTO> getById(@PathVariable String id) {
        Optional<Member> member = consultMembersById.GetMembersByID(id);
        if (member.isPresent()) {
            ConsultMembersDTO memberDto = memberMapperService.mapFromDomain(member.get());
            return new ResponseEntity<>(memberDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
