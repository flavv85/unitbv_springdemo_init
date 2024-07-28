package com.unitbv.spring_boot_tutorial.Ddomain;

import java.util.List;
import java.util.Optional;

public interface Coaches {
    List<Coach> getAllCoaches();
    void createOrUpdate(Coach coach);
    Optional<Coach> getCoachById(String coachId);
    List<Coach> getAllCoachesByName(String name);
    void deleteCoachNativeQuery(String coachId);
    void delete(String coachId);
}
