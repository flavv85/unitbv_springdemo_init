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
    @Column(name="coach_id")
    String coach_id;
    @Column(name="member_id")
    String member_id;
    @Column(name="mark")
    int mark;

}
