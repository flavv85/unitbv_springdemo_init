package com.unitbv.spring_boot_tutorial.Bapplication.coach;

import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import com.unitbv.spring_boot_tutorial.Ddomain.Coaches;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UpdateCoach {

    @Autowired
    Coaches coaches;

    public void update(Coach coach) {
        if (coach.getId() == null || !coaches.existsById(coach.getId())) {
            throw new IllegalArgumentException("Coach ID does not exist");
        }
        coaches.createOrUpdate(coach);
    }

}
