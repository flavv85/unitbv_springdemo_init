package com.unitbv.spring_boot_tutorial.Ddomain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "member")
@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Member {

    @Id
    @Column(name = "member_id")
    String id;

    @Column(name = "name")
    String name;

    @Column(name = "nickname")
    String nickname;


}
