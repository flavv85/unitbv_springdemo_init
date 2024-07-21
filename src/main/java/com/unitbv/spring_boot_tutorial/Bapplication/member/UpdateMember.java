package com.unitbv.spring_boot_tutorial.Bapplication.member;

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
public class UpdateMember {

    @Autowired
    Members members;

    public void update(Member member) {
        //TODO add validation here for non existing coach id
        members.createOrUpdate(member);
    }

}
