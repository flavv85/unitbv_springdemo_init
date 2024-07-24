package com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.implementation;

import com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.MemberRepository;
import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import com.unitbv.spring_boot_tutorial.Ddomain.Members;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class MembersSdj implements Members {

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
    public Optional<Member> getMemberById(String id){
        return memberRepository.findById(id);
    }
    public List<Member> getAllMembersByName(String name){
        return memberRepository.findAllByNameContaining(name);
    }
    public void deleteMemberNativeQuery(String memberId){
        memberRepository.deleteMemberById(memberId);
    }
    public void delete(Member member){
        memberRepository.delete(member);
    }
    public boolean existsById(String id){
        return memberRepository.existsById(id);
    }

}
