package com.unitbv.spring_boot_tutorial.Bapplication.coach;

import com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.MemberRepository;
import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import com.unitbv.spring_boot_tutorial.Ddomain.Members;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreateMember {

    @Autowired
    Members members;

    @Autowired
    MemberRepository MemberRepository;
    @Autowired
    private MemberRepository memberRepository;

    public void create(Member member)
    {
        if(member == null)
        {
            throw new IllegalArgumentException("Member object cannot be null");
        }
        if(member.getId() == null || member.getId().trim().isEmpty())
        {
            throw new IllegalArgumentException("Member id cannot be null or empty");
        }
        if(member.getName() == null || member.getName().trim().isEmpty())
        {
            throw new IllegalArgumentException("Member name cannot be null or empty");
        }
        if(member.getNickname() == null || member.getNickname().trim().isEmpty())
        {
            throw new IllegalArgumentException("Member nickname cannot be null or empty");
        }

        members.createOrUpdate(member);
    }

    public Member getById(String id)
    {
        return memberRepository.findById(id).orElseThrow(); new ResourceNotFoundException("Member with the id " + id + " not found");
    }
}
