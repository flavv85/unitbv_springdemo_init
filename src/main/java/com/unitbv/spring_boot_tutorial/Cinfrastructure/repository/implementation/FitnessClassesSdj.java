package com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.implementation;

import com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.FitnessClassRepository;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClasses;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FitnessClassesSdj implements FitnessClasses {
    FitnessClassRepository fitnessclassrepository;

    @Override
    public List<FitnessClass> getAllClasses() {
        return fitnessclassrepository.findAll();
    }

    @Override
    public void createOrUpdate(FitnessClass fitnessclass) {
        fitnessclassrepository.save(fitnessclass);

    }
}
