package com.unitbv.spring_boot_tutorial.Ddomain;

import java.util.List;
import java.util.Optional;

public interface FitnessClasses {
    Optional<FitnessClass> getFitnessClassById(String id);
    List<FitnessClass> getAllFitnessClasses();
    void createOrUpdate(FitnessClass fitnessClass);
    List<FitnessClass> getAllFitnessClassesById(String fitnessClassId);
    void deleteFitnessClassNativeQuery(String fitnessClassId);

    void delete(FitnessClass fitnessClass);
    boolean existsById(String id);

}