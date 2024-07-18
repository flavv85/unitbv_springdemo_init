package com.unitbv.spring_boot_tutorial.Ddomain;

import java.util.List;

public interface FitnessClasses {
    List<FitnessClass> getFitnessClasses();
    void CreateOrUpdate(FitnessClass fitnessClass);

}
