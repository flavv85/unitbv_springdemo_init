package com.unitbv.spring_boot_tutorial.Aexposition.dto.Review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class ConsultReviewDTO {
    String id;
    String coach_id;
    String member_id;
    int mark;
}
