package com.unitbv.spring_boot_tutorial.Ddomain;

import java.util.List;

public interface Members {
    List<Member> getMembers();
    void CreateOrUpdate(Member member);
}
