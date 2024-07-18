package com.unitbv.spring_boot_tutorial.Bapplication.coach;

import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClasses;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ConsultAllFitnessClasses {

    FitnessClasses fitnessClasses;

    public List<FitnessClass> consultAll(){
       return fitnessClasses.getAllFitnessClasses();
    }
}
