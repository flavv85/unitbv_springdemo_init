package com.unitbv.spring_boot_tutorial.Ddomain;
import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import java.util.List;
import java.util.Optional;

public interface Members {
    List<Member> getAllMembers();
    void createOrUpdate(Member member);
    Optional<Member> getMemberById(String id);
}
