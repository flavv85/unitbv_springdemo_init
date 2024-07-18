package com.unitbv.spring_boot_tutorial.Ddomain;

import com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.CoachRepository;

import java.util.List;
import java.util.Optional;

public interface Coaches {
    List<Coach> getAllCoaches();
    Optional<Coach> getCoachById(String id);
    void createOrUpdate(Coach coach);
}