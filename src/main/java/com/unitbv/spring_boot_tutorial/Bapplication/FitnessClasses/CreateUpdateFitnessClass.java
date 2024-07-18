package com.unitbv.spring_boot_tutorial.Bapplication.FitnessClasses;


import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClasses;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE,makeFinal=true)
public class CreateUpdateFitnessClass {
    @Autowired
    FitnessClasses fitnessClasses;

    public void Create(FitnessClass fitnessClass) {
        fitnessClasses.CreateOrUpdate(fitnessClass);
    }
}
