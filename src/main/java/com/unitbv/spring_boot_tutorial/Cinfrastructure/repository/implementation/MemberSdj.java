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
public class MemberSdj  implements Members {
    MemberRepository MemberRepository;
    @Override
    public List<Member> getAllMembers() {
        return MemberRepository.findAll();
    }

    @Override
    public void CreateOrUpdate(Member member) {
        MemberRepository.save(member);

    }
}
