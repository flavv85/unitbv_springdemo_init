package com.unitbv.spring_boot_tutorial.Aexposition.mapper;

import com.unitbv.spring_boot_tutorial.Aexposition.MemberController;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.Review.ConsultReviewDTO;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.Review.CreateUpdateReviewDTO;
import com.unitbv.spring_boot_tutorial.Ddomain.Review;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReviewMapperService {
    private final MemberController memberController;

    public ConsultReviewDTO mapFromDomain(Review review) {
        return ConsultReviewDTO.builder()
                .id(review.getId())
                .coach_id(review.getCoach_id())
                .member_id(review.getMember_id())
                .mark(review.getMark())
                .build();
    }
    public Review mapToEntity(CreateUpdateReviewDTO dto,String reviewId)
    {
        return Review.builder()
                .id(StringUtils.hasText(reviewId) ? reviewId : String.valueOf(UUID.randomUUID()))
                .coach_id(dto.getCoach_id())
                .member_id(dto.getMember_id())
                .mark(dto.getMark())
                .build();
    }
}
