package com.unitbv.spring_boot_tutorial.Ddomain;

import java.util.List;
import java.util.Optional;

public interface FitnessClasses {
    Optional<FitnessClass> getFitnessClassById(String id);
    List<FitnessClass> getAllFitnessClasses();
    void createOrUpdate(FitnessClass fitnessClass);

}