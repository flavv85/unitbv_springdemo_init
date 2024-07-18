package com.unitbv.spring_boot_tutorial.Ddomain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "coach")
public class Coach {
    @Id
    @Column(name = "coach_id", nullable = false, unique = true)
    private String id;
    @Column(name = "name")
    private String name;

    @OneToMany
    @JoinColumn(name = "fitnessClass_id")
    private List<FitnessClass> fitnessClasses;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FitnessClass> getFitnessClasses() {
        return fitnessClasses;
    }

    public void setFitnessClasses(List<FitnessClass> fitnessClasses) {
        this.fitnessClasses = fitnessClasses;
    }

    public Coach() {
    }

    public Coach(String id, String name) {
        this.id = id;
        this.name = name;
    }

}
