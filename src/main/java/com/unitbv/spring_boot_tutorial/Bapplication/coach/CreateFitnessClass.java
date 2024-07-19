package com.unitbv.spring_boot_tutorial.Bapplication.coach;

import com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.FitnessClassRepository;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClasses;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreateFitnessClass {

    @Autowired
    FitnessClasses fitnessClasses;

    @Autowired
    FitnessClassRepository fitnessClassRepository;

    public void create(FitnessClass fitnessClass)
    {
        if(fitnessClass == null)
        {
            throw new IllegalArgumentException("FitnessClass object cannot be null");
        }

        if(fitnessClass.getId() == null || fitnessClass.getId().trim().isEmpty()){
            throw new IllegalArgumentException("FitnessClass id cannot be empty");
        }

        if(fitnessClass.getStartTime() == null || fitnessClass.getStartTime().isBefore(LocalDateTime.now()))
        {
            throw new IllegalArgumentException("FitnessClass startTime cannot be null or cannot be in the past.");
        }

        if(fitnessClass.getEndTime() == null || fitnessClass.getEndTime().isBefore(fitnessClass.getStartTime()))
        {
            throw new IllegalArgumentException("FitnessClass endTime cannot be null or cannot be before the start time");
        }
        fitnessClasses.createOrUpdate(fitnessClass);
    }

    public FitnessClass getById(String id)
    {
        return fitnessClassRepository.findById(id).orElseThrow(); new ResourceNotFoundException("FitnessClass with id " + id + " not found");
    }
}
