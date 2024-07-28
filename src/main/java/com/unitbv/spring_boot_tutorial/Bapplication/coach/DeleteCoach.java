package com.unitbv.spring_boot_tutorial.Bapplication.coach;

import com.unitbv.spring_boot_tutorial.Ddomain.Coaches;
import com.unitbv.spring_boot_tutorial.Ddomain.exceptions.UnknownObjectException;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@AllArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DeleteCoach {

    @Autowired
    Coaches coaches;

    public void delete(String id) {
        checkIfCoachExistInDb(id);
        coaches.delete(id);
        log.info("Coach was successfully deleted!");
    }

    public void deleteById(String coachId) {
        checkIfCoachExistInDb(coachId);
        coaches.deleteCoachNativeQuery(coachId);
        log.info("Coach was successfully deleted!");
    }

    private void checkIfCoachExistInDb(String id) {
        coaches.getCoachById(id).orElseThrow(() -> new UnknownObjectException(String.format("Coach with id %s was not found", id)));
    }
}
