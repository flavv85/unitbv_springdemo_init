package com.unitbv.spring_boot_tutorial.Bapplication.coach;

import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import com.unitbv.spring_boot_tutorial.Ddomain.Coaches;
import com.unitbv.spring_boot_tutorial.Ddomain.exceptions.UnknownObjectException;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DeleteCoach {

    @Autowired
    Coaches coaches;

    public void delete(String id) {
        Coach coach = coaches.getCoachById(id).orElseThrow(
                () -> new UnknownObjectException(String.format("Coach with id %s was not found", id)));
        coaches.delete(coach);
    }

    public void deleteById(String coachId) {
        coaches.getCoachById(coachId).orElseThrow(
                () -> new UnknownObjectException(String.format("Coach with id %s was not found", coachId)));
        coaches.deleteCoachNativeQuery(coachId);
    }

}
