package com.unitbv.spring_boot_tutorial.Bapplication.Member;

import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import com.unitbv.spring_boot_tutorial.Ddomain.Members;
import com.unitbv.spring_boot_tutorial.Ddomain.exceptions.UnknownMemberException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class UpdateMember {
    Members members;
    public void Update(Member member) {
        CheckIfMemberExists(member);
        members.CreateOrUpdate(member);
    }
    public void CheckIfMemberExists(Member member) {
        members.getMemberById(member.getId())
                .orElseThrow(() -> new UnknownMemberException(String.format("Member with id %s was not found", member.getId())));
    }

}
