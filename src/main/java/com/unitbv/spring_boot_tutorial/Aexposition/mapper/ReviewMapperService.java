package com.unitbv.spring_boot_tutorial.Aexposition.mapper;

import com.unitbv.spring_boot_tutorial.Aexposition.MemberController;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.Review.ConsultReviewDTO;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.Review.CreateUpdateReviewDTO;
import com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.CoachRepository;
import com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.MemberRepository;
import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import com.unitbv.spring_boot_tutorial.Ddomain.Member;
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
    CoachRepository coachRepository;
    MemberRepository memberRepository;
    public ConsultReviewDTO mapFromDomain(Review review) {
        return ConsultReviewDTO.builder()
                .id(review.getId())
                .coach_id(review.getCoach().getId())
                .member_id(review.getMember().getId())
                .mark(review.getMark())
                .build();
    }
    public Review mapToEntity(CreateUpdateReviewDTO dto,String reviewId)
    {
        Review review = new Review();
        review.setId(StringUtils.hasText(reviewId) ? reviewId : String.valueOf(UUID.randomUUID()));
        review.setMark(dto.getMark());
        if (StringUtils.hasText(dto.getCoach_id())) {
            Coach coach = coachRepository.findById(dto.getCoach_id()).orElse(null);
            review.setCoach(coach);
        } else {
            review.setCoach(null);
        }
        if (StringUtils.hasText(dto.getMember_id())) {
            Member member= memberRepository.findById(dto.getMember_id()).orElse(null);
            review.setMember(member);
        } else {
            review.setMember(null);;
        }
        return review;
    }
}
