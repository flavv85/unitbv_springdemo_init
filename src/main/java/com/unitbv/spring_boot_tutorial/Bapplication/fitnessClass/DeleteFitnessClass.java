package com.unitbv.spring_boot_tutorial.Bapplication.fitnessClass;

import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClasses;
import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import com.unitbv.spring_boot_tutorial.Ddomain.Members;
import com.unitbv.spring_boot_tutorial.Ddomain.exceptions.UnknownObjectException;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DeleteFitnessClass {

    @Autowired
    FitnessClasses fitnessClasses;

    public void delete(String id) {
        FitnessClass fitnessClass = fitnessClasses.getFitnessClassById(id).orElseThrow(
                () -> new UnknownObjectException(String.format("Coach with id %s was not found", id)));
        fitnessClasses.delete(fitnessClass);
    }


}
