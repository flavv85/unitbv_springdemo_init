package com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.implementation;

import com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.MemberRepository;
import com.unitbv.spring_boot_tutorial.Ddomain.Members;
import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MembersSdj implements Members {

    MemberRepository memberRepository;

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public void createOrUpdate(Member coach) {
        memberRepository.save(coach);
    }

    @Override
    public Optional<Member> getMemberById(String memberId) {
        return ObjectUtils.isEmpty(memberId) ? Optional.empty() : memberRepository.findById(memberId);
    }

    @Override
    public List<Member> getAllMembersByName(String name) {
        return memberRepository.findAllByNameContaining(name);
    }

    @Override
    public void deleteMemberNativeQuery(String memberId) {
        memberRepository.deleteMemberById(memberId);
    }

    @Override
    public void delete(String memberId) {
        memberRepository.deleteById(memberId);
    }

}
