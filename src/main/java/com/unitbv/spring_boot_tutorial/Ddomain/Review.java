package com.unitbv.spring_boot_tutorial.Ddomain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "review")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Review {
    @Id
    @Column(name="review_id")
    String id;
    @OneToOne
    @JoinColumn(name="coach_id")
    Coach coach;
    @OneToOne
    @JoinColumn(name="member_id")
    Member member;
    @Column(name="mark")
    int mark;

}
