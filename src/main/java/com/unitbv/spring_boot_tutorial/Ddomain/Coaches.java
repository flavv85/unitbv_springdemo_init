package com.unitbv.spring_boot_tutorial.Ddomain;

import java.util.List;
import java.util.Optional;

public interface Coaches {
    List<Coach> getAllCoaches();

    void createOrUpdate(Coach coach);

    //TODO de facut o metoda care verifica daca exista un obiect de tip Coach in db dupa id
    Optional<Coach> getById(String id);
}
