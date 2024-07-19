package com.unitbv.spring_boot_tutorial.Cinfrastructure.repository;

import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
}

