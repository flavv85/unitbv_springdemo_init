package com.unitbv.spring_boot_tutorial.Cinfrastucture.repository.implementation;

import com.unitbv.spring_boot_tutorial.Cinfrastucture.repository.CoachRepository;
import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import com.unitbv.spring_boot_tutorial.Ddomain.Coaches;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class CoachesSdj implements Coaches {

    CoachRepository coachRepository;

    @Override
    public List<Coach> getAllCoaches() {
        return coachRepository.findAll();
    }

    @Override
    public void createOrUpdate(Coach coach) {
        coachRepository.save(coach);
    }

    @Override
    public Coach getCoachById(String id) {
       return coachRepository.findById(id).orElse(null);
    }



}
