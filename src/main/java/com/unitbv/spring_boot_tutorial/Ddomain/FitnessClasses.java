package com.unitbv.spring_boot_tutorial.Ddomain;

import org.springframework.stereotype.Service;

import java.util.List;

public interface FitnessClasses {
    List<FitnessClass> getAllClasses();
    void createOrUpdate(FitnessClass fitnessclass);
}
