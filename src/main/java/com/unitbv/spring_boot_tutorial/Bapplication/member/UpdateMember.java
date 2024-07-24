package com.unitbv.spring_boot_tutorial.Bapplication.member;

import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import com.unitbv.spring_boot_tutorial.Ddomain.Members;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateMember {

    @Autowired
    Members members;

    public void update(Member member) {
        if (member.getId() == null || !members.existsById(member.getId())) {
            throw new IllegalArgumentException("Fitness class ID does not exist");
        }
        members.createOrUpdate(member);
    }

}
