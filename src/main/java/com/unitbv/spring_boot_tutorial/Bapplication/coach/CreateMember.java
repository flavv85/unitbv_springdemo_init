package com.unitbv.spring_boot_tutorial.Bapplication.coach;

import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import com.unitbv.spring_boot_tutorial.Ddomain.Coaches;
import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import com.unitbv.spring_boot_tutorial.Ddomain.Members;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreateMember {

    @Autowired
    Members members;

    public void create(Member member) {
        if(member == null)
        {
            throw new IllegalArgumentException("Member cannot be null.");
        }
        if(member.getId() == null)
        {
            throw new IllegalArgumentException("Member id cannot be null.");
        }
        if(member.getName() == null)
        {
            throw new IllegalArgumentException("Member name cannot be null.");
        }
        if(member.getNickname() == null)
        {
            throw new IllegalArgumentException("Member nickname cannot be null.");
        }
        members.createOrUpdate(member);
    }
}
