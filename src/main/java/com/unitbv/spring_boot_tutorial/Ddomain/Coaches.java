package com.unitbv.spring_boot_tutorial.Ddomain;

import java.util.List;

public interface Coaches {
    List<Coach> getAllCoaches();
    void createOrUpdate(Coach coach);
    Coach getById(String Id);
}
