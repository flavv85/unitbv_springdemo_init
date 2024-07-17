    package com.unitbv.spring_boot_tutorial.Bapplication;

    import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
    import com.unitbv.spring_boot_tutorial.Ddomain.Coaches;
    import lombok.AccessLevel;
    import lombok.RequiredArgsConstructor;
    import lombok.experimental.FieldDefaults;
    import org.springframework.stereotype.Service;

    @Service
    @RequiredArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

    public class ConsultByIdCoach {
        Coaches coaches;
        public Coach consultById(String id) {return coaches.getCoachById(id); }
    }
