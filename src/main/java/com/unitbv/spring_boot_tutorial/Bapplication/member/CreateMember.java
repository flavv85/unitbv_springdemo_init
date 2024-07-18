package com.unitbv.spring_boot_tutorial.Bapplication.member;

import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import com.unitbv.spring_boot_tutorial.Ddomain.Members;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateMember {

    Members members;

    public void create(Member member) {
        //TODO add validation here for duration missing dates, missing ids and other properties
        members.createOrUpdate(member);
    }

}
