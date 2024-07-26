package com.unitbv.spring_boot_tutorial.Ddomain;

import java.util.List;
import java.util.Optional;

public interface FitnessClasses {
    List<FitnessClass> getAllFitnessClasses();
    Optional<FitnessClass> getFitnessClassById(String id);
    void createOrUpdate(FitnessClass fitnessClass);
    void delete(FitnessClass fitnessClass);

}
