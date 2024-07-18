package com.unitbv.spring_boot_tutorial.Aexposition;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.Members.ConsultMembersDTO;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.Members.CreateUpdateMemberDTO;
import com.unitbv.spring_boot_tutorial.Aexposition.mapper.MemberMapperService;
import com.unitbv.spring_boot_tutorial.Bapplication.Member.ConsultAllMembers;
import com.unitbv.spring_boot_tutorial.Bapplication.Member.ConsultMembersByID;
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
    MemberMapperService memberMapperService;
    ConsultAllMembers consultAllMembers;
    CreateUpdateMember createUpdateMember;
    ConsultMembersByID consultMembersByID;

    @GetMapping
    public ResponseEntity<List<ConsultMembersDTO>> getAllMembers() {
        List<Member> members=consultAllMembers.ConsultAll();
        List<ConsultMembersDTO> membersDTOList=members.stream().map(memberMapperService::mapFromDomain).toList();
        return new ResponseEntity<>(membersDTOList,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Void> createMember(@RequestBody CreateUpdateMemberDTO DTO, String memberID) {
        Member newMember=memberMapperService.mapToEntity(DTO,memberID);
        createUpdateMember.CreateUpdateMember(newMember);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ConsultMembersDTO> getMemberById(@PathVariable String id) {
        Optional<Member> member=consultMembersByID.GetMembersByID(id);
        if(member.isPresent()) {
            ConsultMembersDTO memberDTO= memberMapperService.mapFromDomain(member.get());
            return new ResponseEntity<>(memberDTO,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
