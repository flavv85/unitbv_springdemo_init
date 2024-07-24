package com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.implementation;

import com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.FitnessClassRepository;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClasses;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class FitnessClassesSdj implements FitnessClasses {

    FitnessClassRepository fitnessClassRepository;

    @Override
    public List<FitnessClass> getAllFitnessClasses() {
        return fitnessClassRepository.findAll();
    }

    @Override
    public void createOrUpdate(FitnessClass fitnessClass) {
        fitnessClassRepository.save(fitnessClass);
    }

    @Override
    public List<FitnessClass> getAllFitnessClassesById(String fitnessClassId) {
        return fitnessClassRepository.findAllByIdContaining(fitnessClassId);
    }

    @Override
    public void deleteFitnessClassNativeQuery(String fitnessClassId) {
        fitnessClassRepository.deleteFitnessClassById(fitnessClassId);

    }

    public Optional<FitnessClass> getFitnessClassById(String id){
        return fitnessClassRepository.findById(id);
    }
    public void deleteFitnessClassById(String fitnessClassId){
        fitnessClassRepository.deleteFitnessClassById(fitnessClassId);
    }
    public void delete(FitnessClass fitnessClass){
        fitnessClassRepository.delete(fitnessClass);
    }
    public boolean existsById(String id){
        return fitnessClassRepository.existsById(id);
    }



}
