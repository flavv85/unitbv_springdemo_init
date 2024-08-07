package com.unitbv.spring_boot_tutorial.Ddomain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "coach")
@Builder
@AllArgsConstructor

public class Coach {
    @Id
    @Column(name = "coach_id", nullable = false, unique = true)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "coach", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FitnessClass> fitnessClasses = new ArrayList<>();

    public List<FitnessClass> getFitnessClasses() {
        return fitnessClasses;
    }

    public void setFitnessClasses(List<FitnessClass> fitnessClasses) {
        this.fitnessClasses = fitnessClasses;
    }

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

    public Coach() {
    }

    public Coach(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // specific methods for bidirectional @OneToMany and @ManyToOne relations
    // for adding and deleting children (fitness classes) from parent entity (coach)
        public void addFitnessClass(FitnessClass fitnessClass) {
        fitnessClasses.add(fitnessClass);
        fitnessClass.setCoach(this);
    }

    public void removeFitnessClass(FitnessClass fitnessClass) {
        fitnessClasses.remove(fitnessClass);
        fitnessClass.setCoach(null);
    }
}
