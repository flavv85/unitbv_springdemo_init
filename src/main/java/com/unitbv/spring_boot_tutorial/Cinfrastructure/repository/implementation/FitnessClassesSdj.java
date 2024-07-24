package com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.implementation;


import com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.FitnessClassesRepository;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClasses;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FitnessClassesSdj implements FitnessClasses {
    FitnessClassesRepository FitnessClassesRepository;
    private final FitnessClassesRepository fitnessClassesRepository;

    @Override
    public List<FitnessClass> getFitnessClasses() {
        return FitnessClassesRepository.findAll();
    }

    @Override
    public void CreateOrUpdate(FitnessClass fitnessClass) {

        FitnessClassesRepository.save(fitnessClass);
    }

    @Override
    public Optional<FitnessClass> getFitnessClassById(String id) {
        return FitnessClassesRepository.findById(id);
    }

    @Override
    public void deleteFitnessClass(FitnessClass fitnessClass) {
        fitnessClassesRepository.delete(fitnessClass);
    }

}