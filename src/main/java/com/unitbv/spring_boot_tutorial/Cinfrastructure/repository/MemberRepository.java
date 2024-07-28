package com.unitbv.spring_boot_tutorial.Cinfrastructure.repository;

import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, String> {
    List<Member> findAllByNameContaining(String name);

    @Modifying
    @Query(value = "DELETE FROM MEMBER WHERE MEMBER_ID = ?1", nativeQuery = true)
    void deleteMemberById(String memberId);
}
