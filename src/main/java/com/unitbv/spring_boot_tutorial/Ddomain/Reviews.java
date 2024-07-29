package com.unitbv.spring_boot_tutorial.Ddomain;

import java.util.List;

public interface Reviews {
    List<Review> getAllReviews();
    void createReview(Review review);

}
