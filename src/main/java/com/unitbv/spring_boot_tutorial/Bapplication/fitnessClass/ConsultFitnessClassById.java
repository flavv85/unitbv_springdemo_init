package com.unitbv.spring_boot_tutorial.Bapplication.fitnessClass;

import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import com.unitbv.spring_boot_tutorial.Ddomain.Coaches;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClasses;
import com.unitbv.spring_boot_tutorial.Ddomain.exceptions.UnknownObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultFitnessClassById {

    @Autowired
    FitnessClasses fitnessClasses;

    public FitnessClass consult(String id) {
        return fitnessClasses.getFitnessClassById(id).orElseThrow(() -> new UnknownObjectException(String.format("The fitness class with id %s was not found", id)));
    }

}
