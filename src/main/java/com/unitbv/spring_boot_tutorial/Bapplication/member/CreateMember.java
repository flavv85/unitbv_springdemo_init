package com.unitbv.spring_boot_tutorial.Bapplication.member;

import com.unitbv.spring_boot_tutorial.Ddomain.Members;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.unitbv.spring_boot_tutorial.Ddomain.Member;

@Service
@AllArgsConstructor
public class CreateMember {

    private final Members members;

    public void create(Member member) {
        members.createOrUpdate(member);
    }
}