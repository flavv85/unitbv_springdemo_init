package com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.implementation;

import com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.MemberRepository;
import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import com.unitbv.spring_boot_tutorial.Ddomain.Members;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MembersSdj implements Members{

    MemberRepository memberRepository;

    @Override
    public List<Member> getAllMembers() {

        return memberRepository.findAll();
    }

    @Override
    public void createOrUpdate(Member member) {

        memberRepository.save(member);
    }

    @Override
    public Member getById(String Id) {
        return memberRepository.findById(Id).get();
    }
}