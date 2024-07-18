package com.unitbv.spring_boot_tutorial.Bapplication.member;

import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import com.unitbv.spring_boot_tutorial.Ddomain.Members;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConsultAllMembers {

    private final Members members;

    public List<Member> consultAll() {
        return members.getAllMembers();
    }

    public Optional<Member> consultById(String id) {
        return members.getMemberById(id);
    }
}
