package com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.implementation;

import com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.MemberRepository;
import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import com.unitbv.spring_boot_tutorial.Ddomain.Members;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MembersSdj implements Members{

    MemberRepository memberRepository;

    public List<Member> getAllMembers()
    {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(String id)
    {
        return memberRepository.findById(id);
    }

    public void createOrUpdate(Member member) {
        memberRepository.save(member);
    }

}