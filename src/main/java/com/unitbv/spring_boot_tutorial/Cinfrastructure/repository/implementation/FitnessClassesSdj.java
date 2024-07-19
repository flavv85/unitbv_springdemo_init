package com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.implementation;

import com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.repository.FitnessClassRepository;
import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
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

    FitnessClassRepository fitnessClassRepository;

    @Override
    public List<FitnessClass> getAllFitnessClasses() {
        return fitnessClassRepository.findAll();
    }

    @Override
    public void createOrUpdate(FitnessClass fitnessClass) {
        fitnessClassRepository.save(fitnessClass);
    }
}
