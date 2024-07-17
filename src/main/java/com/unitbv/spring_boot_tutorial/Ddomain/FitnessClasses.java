package com.unitbv.spring_boot_tutorial.Ddomain;

import java.util.List;

public interface FitnessClasses {
    List<FitnessClass> getAllFitnessClasses();
    void createOrUpdate(FitnessClass fitnessClass);
    FitnessClass getById(String Id);
}
