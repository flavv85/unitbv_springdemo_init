package com.unitbv.spring_boot_tutorial.Ddomain;

import jakarta.persistence.*;

<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> refs/heads/main
import java.util.List;

@Entity
@Table(name = "coach")
public class Coach {
    @Id
    @Column(name = "coach_id", unique = true)
    private String id;
    @Column(name = "name")
    private String name;

<<<<<<< HEAD
    @OneToMany
    @JoinColumn(name = "fitness_class_id")
    private List<FitnessClass> fitnessClasses;
=======
    @OneToMany(mappedBy = "coach", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FitnessClass> fitnessClasses = new ArrayList<>();

    public List<FitnessClass> getFitnessClasses() {
        return fitnessClasses;
    }

    public void setFitnessClasses(List<FitnessClass> fitnessClasses) {
        this.fitnessClasses = fitnessClasses;
    }
>>>>>>> refs/heads/main

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

<<<<<<< HEAD
=======
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
>>>>>>> refs/heads/main
}
