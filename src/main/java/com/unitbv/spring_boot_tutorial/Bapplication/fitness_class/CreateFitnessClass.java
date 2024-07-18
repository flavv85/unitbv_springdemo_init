package com.unitbv.spring_boot_tutorial.Bapplication.fitness_class;

import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClasses;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CreateFitnessClass {

    private final FitnessClasses fitnessClasses;

    public void create(FitnessClass fitnessClass) {
        fitnessClasses.createOrUpdate(fitnessClass);
    }
}