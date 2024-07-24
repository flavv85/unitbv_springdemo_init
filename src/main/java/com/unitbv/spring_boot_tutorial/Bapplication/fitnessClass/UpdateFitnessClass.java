package com.unitbv.spring_boot_tutorial.Bapplication.fitnessClass;

import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import com.unitbv.spring_boot_tutorial.Ddomain.Coaches;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClasses;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateFitnessClass {

    @Autowired
    FitnessClasses fitnessClasses;

    public void update(FitnessClass fitnessClass) {
        if (fitnessClass.getId() == null || !fitnessClasses.existsById(fitnessClass.getId())) {
            throw new IllegalArgumentException("Fitness class ID does not exist");
        }
        fitnessClasses.createOrUpdate(fitnessClass);
    }

}
