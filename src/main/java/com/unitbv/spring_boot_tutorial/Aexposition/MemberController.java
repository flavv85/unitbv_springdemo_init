package com.unitbv.spring_boot_tutorial.Aexposition;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.Member.ConsultMembersDTO;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.Member.CreateUpdateMemberDTO;
import com.unitbv.spring_boot_tutorial.Aexposition.mapper.MemberMapperService;
import com.unitbv.spring_boot_tutorial.Bapplication.Member.*;
import com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.MemberRepository;
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

    private final MemberRepository memberRepository;
    ConsultAllMembers consultAllMembers;
    MemberMapperService memberMapperService;
    ConsultMembersById consultMembersById;
    CreateMember createMember;
    UpdateMember updateMember;
    DeleteMember deleteMember;


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

    @DeleteMapping(value = "/delete-by-id/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") String id) {
        deleteMember.Delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable(value = "id") String id, @RequestBody CreateUpdateMemberDTO dto) {
        Member toBePersistedMember = (Member) memberMapperService.mapToEntity(dto, id);
        updateMember.Update(toBePersistedMember);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
