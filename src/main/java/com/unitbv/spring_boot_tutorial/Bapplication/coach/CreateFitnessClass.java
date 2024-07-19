package com.unitbv.spring_boot_tutorial.Bapplication.coach;

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
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreateFitnessClass {

    @Autowired
    FitnessClasses fitnessClasses;

    public void create(FitnessClass fitnessClass) {
        if(fitnessClass == null)
        {
            throw new IllegalArgumentException("Fitness Class cannot be null.");
        }
        if(fitnessClass.getId() == null)
        {
            throw new IllegalArgumentException("Fitness Class id cannot be null.");
        }
        if(fitnessClass.getStartTime() == null)
        {
            throw new IllegalArgumentException("Fitness Clas start time cannot be null.");
        }
        if(fitnessClass.getEndTime() == null)
        {
            throw new IllegalArgumentException("Fitness Clas end time cannot be null.");
        }
        fitnessClasses.createOrUpdate(fitnessClass);
    }
}
