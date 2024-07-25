package com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.implementation;

import com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.FitnessClassRepository;
import com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.MemberRepository;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClasses;
import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import com.unitbv.spring_boot_tutorial.Ddomain.Members;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FitnessClassSdj implements FitnessClasses {

    FitnessClassRepository fitnessClassRepository;

    public List<FitnessClass> getAllFitnessClasses()
    {
        return fitnessClassRepository.findAll();
    }

    public Optional<FitnessClass> getFitnessClassById(String id)
    {
        return fitnessClassRepository.findById(id);
    }

    public void createOrUpdate(FitnessClass fitnessClass) {
        fitnessClassRepository.save(fitnessClass);
    }

    @Override
    public void delete(FitnessClass fitnessClass) {
        fitnessClassRepository.delete(fitnessClass);
    }
}
