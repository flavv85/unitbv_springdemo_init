package com.unitbv.spring_boot_tutorial.Bapplication.Member;

import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import com.unitbv.spring_boot_tutorial.Ddomain.Members;
import com.unitbv.spring_boot_tutorial.Ddomain.exceptions.UnknownObjectException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class DeleteMember {

    Members members;

    public void Delete(String memberId)
    {
        Member member=members.getMemberById(memberId).orElseThrow(
                () -> new UnknownObjectException(String.format("Member with id %s was not found", memberId)));
        members.DeleteMember(member);
    }
}
