package com.unitbv.spring_boot_tutorial.Bapplication.member;

import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import com.unitbv.spring_boot_tutorial.Ddomain.Members;
import com.unitbv.spring_boot_tutorial.Ddomain.exceptions.UnknownObjectException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@Transactional
public class DeleteMember {

    @Autowired
    Members members;

    public void delete(String id) {
        Member member = members.getMemberById(id).orElseThrow(
                () -> new UnknownObjectException(String.format("Member with id %s was not found", id)));
        members.delete(member);
    }

    public void deleteById(String memberId) {
        members.getMemberById(memberId).orElseThrow(
                () -> new UnknownObjectException(String.format("Member with id %s was not found", memberId)));
        members.deleteMemberNativeQuery(memberId);
    }

}
