package com.unitbv.spring_boot_tutorial.Bapplication.Review;

import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import com.unitbv.spring_boot_tutorial.Ddomain.Reviews;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ConsultCoachesWithGrade {
    Reviews reviews;

    public Set<Coach> getCoaches()
    {
        return reviews.getCoachesWithMarkBetterThan8();
    }

}
