package com.unitbv.spring_boot_tutorial.Ddomain;

import java.util.List;
import java.util.Set;

public interface Reviews {
    List<Review> getAllReviews();
    void createReview(Review review);
    Set<Coach> getCoachesWithMarkBetterThan8();

}
