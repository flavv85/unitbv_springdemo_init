package com.unitbv.spring_boot_tutorial.Bapplication.FitnessClass;


import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClasses;
import com.unitbv.spring_boot_tutorial.Ddomain.exceptions.UnknownObjectException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DeleteFitnessClass {
    FitnessClasses fitnessClasses;
    public void Delete(String fitnessClassId) {
        FitnessClass fitnessClass = fitnessClasses.getFitnessClassById(fitnessClassId).orElseThrow(
                () -> new UnknownObjectException(String.format("Fitness class with id %s was not found", fitnessClassId)));
        fitnessClasses.deleteFitnessClass(fitnessClass);
    }

}
