package com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.implementation;
import com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.MemberRepository;
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
public class MembersSdj  implements Members {
    MemberRepository MemberRepository;
    private final MemberRepository memberRepository;

    @Override
    public List<Member> getAllMembers() {
        return MemberRepository.findAll();
    }

    @Override
    public void CreateOrUpdate(Member member) {
        MemberRepository.save(member);

    }

    @Override
    public Optional<Member> getMemberById(String id) {
        return MemberRepository.findById(id);
    }

    @Override
    public void DeleteMember(Member member) {
        memberRepository.delete(member);
    }
}