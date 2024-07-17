package com.unitbv.spring_boot_tutorial.Bapplication;


import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClasses;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ConsultByIdFitnessClass {
    FitnessClasses fitnessClasses;
    public FitnessClass consultById(String id) {return fitnessClasses.getFitnessClassById(id); }
}
