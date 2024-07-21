package com.unitbv.spring_boot_tutorial.Ddomain;

import java.util.List;
import java.util.Optional;

public interface Members {
    List<Member> getAllMembers();
    Optional<Member> getMemberById(String id);
    void createOrUpdate(Member member);
    void delete(Member member);
}
