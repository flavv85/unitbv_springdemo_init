package com.unitbv.spring_boot_tutorial.Bapplication.Member;

import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import com.unitbv.spring_boot_tutorial.Ddomain.Members;
import com.unitbv.spring_boot_tutorial.Ddomain.exceptions.UnknownMemberException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal=true)
public class CreateMember {
    @Autowired
    Members members;
    public void CreateUpdateMember(Member member) {
        checkIfIsValidMember(member);
        members.CreateOrUpdate(member);
    }

    public void checkIfIsValidMember(Member member) {
        if(member.getId().length()!=36||member.getName().isEmpty()||member.getNickname().isEmpty())
            throw new UnknownMemberException(String.format("Member %s is invalid",member));
    }
}