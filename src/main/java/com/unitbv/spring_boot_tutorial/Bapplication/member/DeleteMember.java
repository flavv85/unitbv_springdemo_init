package com.unitbv.spring_boot_tutorial.Bapplication.member;

import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import com.unitbv.spring_boot_tutorial.Ddomain.Coaches;
import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import com.unitbv.spring_boot_tutorial.Ddomain.Members;
import com.unitbv.spring_boot_tutorial.Ddomain.exceptions.UnknownObjectException;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DeleteMember {

    @Autowired
    Members members;

    public void delete(String id) {
        Member member = members.getMemberById(id).orElseThrow(
                () -> new UnknownObjectException(String.format("Coach with id %s was not found", id)));
        members.delete(member);
    }


}
