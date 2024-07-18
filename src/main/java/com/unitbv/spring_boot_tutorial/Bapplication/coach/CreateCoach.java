package com.unitbv.spring_boot_tutorial.Bapplication.coach;

import aj.org.objectweb.asm.commons.TryCatchBlockSorter;
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
public class CreateCoach {

    @Autowired
    Coaches coaches;

    public void create(Coach coach) {
        //TODO add validation here for duration missing dates, missing ids and other properties
        if(coach.getId() != null) coaches.createOrUpdate(coach);
    }

}
