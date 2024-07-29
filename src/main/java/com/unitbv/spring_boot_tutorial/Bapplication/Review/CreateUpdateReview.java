package com.unitbv.spring_boot_tutorial.Bapplication.Review;

import com.unitbv.spring_boot_tutorial.Ddomain.Review;
import com.unitbv.spring_boot_tutorial.Ddomain.Reviews;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreateUpdateReview {
    @Autowired
    Reviews reviews;
    public void createReview(Review review) {
        reviews.createReview(review);
    }

}
