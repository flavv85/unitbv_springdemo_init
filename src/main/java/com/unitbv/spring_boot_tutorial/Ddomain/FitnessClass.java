package com.unitbv.spring_boot_tutorial.Ddomain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "fitness_class")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FitnessClass {

    @Id
    @Column(name = "fitness_class_id")
    String id;

    @Column(name = "start_time")
    LocalDateTime startTime;

    @Column(name = "end_time")
    LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "coach_id")
    Coach coach;

    @ManyToMany
            @JoinTable(name = "fitness_classes_members",
            joinColumns = @JoinColumn(name = "fitness_class_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id"))
    Set<Member> members = new HashSet<>();

}
