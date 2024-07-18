package com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.implementation;

import com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.FitnessClassesRepository;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClasses;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FitnessClassesSdj implements FitnessClasses {
    FitnessClassesRepository FitnessClassesRepository;

    @Override
    public List<FitnessClass> getFitnessClasses() {
        return FitnessClassesRepository.findAll();
    }

    @Override
    public void CreateOrUpdate(FitnessClass fitnessClass) {

        FitnessClassesRepository.save(fitnessClass);
    }
}
