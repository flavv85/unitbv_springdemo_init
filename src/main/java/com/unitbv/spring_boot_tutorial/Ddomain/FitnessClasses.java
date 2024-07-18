package com.unitbv.spring_boot_tutorial.Ddomain;

import java.util.List;
import java.util.Optional;

public interface FitnessClasses {
    List<FitnessClass> getAllFitnessClasses();
    void createOrUpdate(FitnessClass fitnessClass);
    Optional<FitnessClass> getFitnessClassById(String id);
}
