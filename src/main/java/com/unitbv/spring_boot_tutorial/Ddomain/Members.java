package com.unitbv.spring_boot_tutorial.Ddomain;
import java.util.List;
import java.util.Optional;

public interface Members {
    List<Member> getAllMembers();
    void CreateOrUpdate(Member member);
    Optional<Member> getMemberById(String id);
    void DeleteMember(Member member);
}