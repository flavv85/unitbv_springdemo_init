package com.unitbv.spring_boot_tutorial.Bapplication.coach;


import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import com.unitbv.spring_boot_tutorial.Ddomain.Coaches;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ConsultCoachesByID {
    Coaches coaches;
    public Optional<Coach> getCoachById(String id) {
        return coaches.getCoachById(id);
    }
}
