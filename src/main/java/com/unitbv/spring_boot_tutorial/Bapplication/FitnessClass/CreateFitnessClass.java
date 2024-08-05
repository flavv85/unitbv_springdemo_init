package com.unitbv.spring_boot_tutorial.Bapplication.FitnessClass;

import com.unitbv.spring_boot_tutorial.Ddomain.Coaches;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClassValidations;
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
    FitnessClassValidations validations;
    Coaches coaches;

    public void create(FitnessClass fitnessClass) {
        //TODO check if coach if from fitnessClass really exists in db

        coaches.getCoachById(fitnessClass.getCoach().getId());
        //TODO daca nu exista aruncam exceptie

        validations.checkMembersNumberForOneFitnessClass(fitnessClass);
        fitnessClasses.CreateOrUpdate(fitnessClass);
    }
}