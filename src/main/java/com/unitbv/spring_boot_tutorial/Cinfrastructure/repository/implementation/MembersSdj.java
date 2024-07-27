package com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.implementation;
import com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.FitnessClassesRepository;
import com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.MemberRepository;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClasses;
import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import com.unitbv.spring_boot_tutorial.Ddomain.Members;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MembersSdj  implements Members {
    MemberRepository memberRepository;
    FitnessClasses fitnessClasses;

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public void CreateOrUpdate(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Optional<Member> getMemberById(String id) {
        return memberRepository.findById(id);
    }

    @Override
    public void DeleteMember(Member member) {
        memberRepository.delete(member);
    }

    @Override
    public Optional<Set<Member>> GetMembersByFitnessClass(FitnessClass fitnessClass) {
        return Optional.ofNullable(fitnessClass.getMembers());

    }

}