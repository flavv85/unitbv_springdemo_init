package com.unitbv.spring_boot_tutorial.Cinfrastructure.repository;

import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
    @Modifying
    @Query(value= "DELETE FROM member where member_status is null",nativeQuery = true)
    void deleteAllMembers();
    @Modifying
    @Query(value= "UPDATE member set member_status='INACTIVE' where member_status='ACTIVE'",nativeQuery = true)
    void updateMemberStatus();
}