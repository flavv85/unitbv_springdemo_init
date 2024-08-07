package com.unitbv.spring_boot_tutorial.Bapplication.FitnessClass;

import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClassValidations;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClasses;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ConsultAllFitnessClasses {
    FitnessClasses fitnessClasses;

    //TODO validation is need on create / update not retrieve from db
//    FitnessClassValidations fitnessClassValidations;

    public List<FitnessClass> consultAll() {
        List<FitnessClass> fitnessClasses = this.fitnessClasses.getFitnessClasses();
        //TODO validation is need on create / update not retrieve from db
//        fitnessClassValidations.CheckMembersNumbers(fitnessClasses);
        return fitnessClasses;
    }
}