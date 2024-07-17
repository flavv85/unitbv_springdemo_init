package com.unitbv.spring_boot_tutorial.Cinfrastucture.repository;

import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<Coach, String> {

}
