package com.unitbv.spring_boot_tutorial.Aexposition.dto.Review;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor

public class CreateUpdateReviewDTO {
    String coach_id;
    String member_id;
    int mark;
}
