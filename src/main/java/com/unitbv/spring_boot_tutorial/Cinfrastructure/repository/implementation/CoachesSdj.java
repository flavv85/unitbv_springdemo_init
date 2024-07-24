package com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.implementation;

import com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.CoachRepository;
import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import com.unitbv.spring_boot_tutorial.Ddomain.Coaches;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

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

    @Override
    public void createOrUpdate(Coach coach) {
        coachRepository.save(coach);
    }
    public Optional<Coach> getCoachById(String id){
        return coachRepository.findById(id);
    }
    public void deleteCoachNativeQuery(String coachId){
        coachRepository.deleteCoachById(coachId);
    }
    public void delete(Coach coach){
        coachRepository.delete(coach);
    }
    public List<Coach> getAllCoachesByName(String name){
        return coachRepository.findAllByNameContaining(name);
    }
    public boolean existsById(String id){
        return coachRepository.existsById(id);
    }

}
