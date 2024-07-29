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
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal=true)
public class ConsultAllFitnessClasses {
    FitnessClasses fitnessClasses;
    public List<FitnessClass> ConsultAll(){
        List<FitnessClass> fitnessclasses=fitnessClasses.getFitnessClasses();
        FitnessClassValidations.CheckMembersNumbers(fitnessclasses);

        return fitnessclasses;
    }
}