package com.unitbv.spring_boot_tutorial.Cinfrastructure.repository;

import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FitnessClassRepository extends JpaRepository<FitnessClass, String> {
    List<FitnessClass> findAllByIdContaining(String fitnessClassId);

    @Modifying
    @Query(value = "DELETE FROM FITNESSCLASS WHERE FITNESS_CLASS_ID = ?1", nativeQuery = true)
    void deleteFitnessClassById(String fitnessClassId);
    boolean existsById(String id);
}
