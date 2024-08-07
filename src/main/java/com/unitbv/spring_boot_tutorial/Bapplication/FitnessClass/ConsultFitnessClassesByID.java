package com.unitbv.spring_boot_tutorial.Bapplication.FitnessClass;

import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClasses;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ConsultFitnessClassesByID {
    FitnessClasses fitnessClasses;

    public Optional<FitnessClass> ConsultById(String id) {
        return fitnessClasses.getFitnessClassById(id);
    }
}