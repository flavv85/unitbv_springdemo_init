package com.unitbv.spring_boot_tutorial.Ddomain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "coach")

public class Coach {
    @Id
    @Column(name = "coach_id", nullable = false, unique = true)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

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
}
