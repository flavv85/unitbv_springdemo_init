package com.unitbv.spring_boot_tutorial.Bapplication.coach;

import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import com.unitbv.spring_boot_tutorial.Ddomain.Coaches;
import com.unitbv.spring_boot_tutorial.Ddomain.exceptions.UnknownObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultCoachById {

    @Autowired
    Coaches coaches;

    public Coach consult(String id) {
        return coaches.getCoachById(id).orElseThrow(() -> new UnknownObjectException(String.format("The coach with id %s was not found", id)));
    }

}
