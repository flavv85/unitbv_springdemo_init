package com.unitbv.spring_boot_tutorial.Bapplication.fitness_class;

import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClasses;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConsultAllFitnessClasses {

    private final FitnessClasses fitnessClasses;

    public List<FitnessClass> consultAll() {
        return fitnessClasses.getAllFitnessClasses();
    }

    public Optional<FitnessClass> consultById(String id) {
        return fitnessClasses.getFitnessClassById(id);
    }
}