package com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.implementation;

import com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.CoachRepository;
import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import com.unitbv.spring_boot_tutorial.Ddomain.Coaches;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CoachesSdj implements Coaches {

    CoachRepository coachRepository;

    @Override
    public List<Coach> getAllCoaches() {
        return coachRepository.findAll();
    }

    public Optional<Coach> getCoachById(String id)
    {
        return coachRepository.findById(id);
    }


    @Override
    public void createOrUpdate(Coach coach) {
        coachRepository.save(coach);
    }

    @Override
    public Optional<Coach> getCoachById(String coachId) {
        return ObjectUtils.isEmpty(coachId) ? Optional.empty() : coachRepository.findById(coachId);
    }

    @Override
    public List<Coach> getAllCoachesByName(String name) {
        return coachRepository.findAllByNameContaining(name);
    }

    @Override
    public void deleteCoachNativeQuery(String coachId) {
        coachRepository.deleteCoachById(coachId);
    }

    @Override
    public void delete(Coach coach) {
        coachRepository.delete(coach);
    }
}
