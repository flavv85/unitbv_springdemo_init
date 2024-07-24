package com.unitbv.spring_boot_tutorial.Bapplication.member;

import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import com.unitbv.spring_boot_tutorial.Ddomain.Members;
import com.unitbv.spring_boot_tutorial.Ddomain.exceptions.UnknownObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultMemberById {

    @Autowired
    Members members;

    public Member consult(String id) {
        return members.getMemberById(id).orElseThrow(() -> new UnknownObjectException(String.format("The member with id %s was not found", id)));
    }

}
