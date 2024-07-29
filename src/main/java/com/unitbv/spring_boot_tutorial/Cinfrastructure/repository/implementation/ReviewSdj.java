package com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.implementation;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.Coach.ConsultCoachDto;
import com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.ReviewRepository;
import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import com.unitbv.spring_boot_tutorial.Ddomain.Review;
import com.unitbv.spring_boot_tutorial.Ddomain.Reviews;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReviewSdj implements Reviews {

    ReviewRepository reviewRepository;
    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public void createReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public Set<Coach> getCoachesWithMarkBetterThan8() {
        List<Review> reviews = getAllReviews();
        Set<Coach>coaches = new HashSet<>();
        for (Review review : reviews) {
            if(review.getMark()>8)
                coaches.add(review.getCoach());
        }
        return coaches;
    }
}
