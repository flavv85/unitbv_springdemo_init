package com.unitbv.spring_boot_tutorial.Cinfrastructure.repository;

import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import org.springframework.data.jpa.repository.JpaRepository;

import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FitnessClassesRepository extends JpaRepository<FitnessClass, String> {
}
