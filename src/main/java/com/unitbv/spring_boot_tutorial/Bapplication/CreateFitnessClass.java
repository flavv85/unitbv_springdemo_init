package com.unitbv.spring_boot_tutorial.Bapplication;

import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClasses;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreateFitnessClass {


    FitnessClasses fitnessClasses;

    public void create(FitnessClass fitnessClass) {
        //TODO add validation here for duration missing dates, missing ids and other properties
        fitnessClasses.createOrUpdate(fitnessClass);
    }
}
