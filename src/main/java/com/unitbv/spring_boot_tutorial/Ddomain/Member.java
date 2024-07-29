package com.unitbv.spring_boot_tutorial.Ddomain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Entity
@Table(name = "member")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Member {

    @Id
    @Column(name = "member_id")
    String id;

    @Column(name = "member_name")
    String name;

    @Column(name = "member_nickname")
    String nickname;

    @Enumerated(EnumType.STRING)
    @Column(name="member_status")
    MemberStatus status;
    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
