package com.unitbv.spring_boot_tutorial.Bapplication.FitnessClass;

import com.unitbv.spring_boot_tutorial.Ddomain.Coaches;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClassValidations;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClasses;
import com.unitbv.spring_boot_tutorial.Ddomain.exceptions.UnknownFitnessClassException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreateFitnessClass {

    FitnessClasses fitnessClasses;
    Coaches coaches;

    public void create(FitnessClass fitnessClass) {
        //TODO check if coach if from fitnessClass really exists in db
        coaches.getCoachById(fitnessClass.getCoach().getId());
        //TODO daca nu exista aruncam exceptie

        validateMembers(fitnessClass);
        fitnessClasses.CreateOrUpdate(fitnessClass);
    }

    private void validateMembers(FitnessClass fitnessClass) {
        int membersSize = 0;
        if (fitnessClass.getMembers() != null) {
            membersSize = fitnessClass.getMembers().size();
        }
        if (membersSize < 1) {
            throw new UnknownFitnessClassException(String.format("Fitness class %s has too few members", fitnessClass.getName()));
        } else if (membersSize > 8) {
            throw new UnknownFitnessClassException(String.format("Fitness class %s has too many members", fitnessClass.getName()));
        }
    }
}