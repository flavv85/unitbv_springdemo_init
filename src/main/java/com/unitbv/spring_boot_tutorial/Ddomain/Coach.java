package com.unitbv.spring_boot_tutorial.Ddomain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "coach")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder

public class Coach {
    @Id
    @Column(name = "coach_id", nullable = false, unique = true)
    String id;

    @Column(name = "name", nullable = false)
    String name;

}
