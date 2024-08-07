package com.unitbv.spring_boot_tutorial;

import com.unitbv.spring_boot_tutorial.Bapplication.FitnessClass.CreateFitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.*;
import com.unitbv.spring_boot_tutorial.Ddomain.exceptions.UnknownFitnessClassException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CreateFitnessClassesTest {
    @Autowired
    CreateFitnessClass sut;

    @MockBean
    FitnessClasses fitnessClasses;

    @MockBean
    Coaches coaches;

    @MockBean
    FitnessClassValidations fitnessClassValidations;


    private LocalDateTime START_TIME;
    private LocalDateTime END_TIME;
    private Coach MOCK_COACH;

    @BeforeEach
    void init() {
        START_TIME = LocalDateTime.of(2024, 8, 5, 16, 0, 0);
        END_TIME = LocalDateTime.of(2024, 8, 5, 18, 0, 0);
        MOCK_COACH = Coach
                .builder()
                .name("Test Coach")
                .id("c1")
                .build();

        when(coaches.getCoachById(any())).thenReturn(Optional.ofNullable(MOCK_COACH));
//        doNothing().when(fitnessClassValidations).checkMembersNumberForOneFitnessClass(any());
    }

    @Test
    void testCreateSuccessful() {

        FitnessClass fitnessClass = FitnessClass
                .builder()
                .id("fc1")
                .name("pilates")
                .coach(MOCK_COACH)
                .startTime(START_TIME)
                .endTime(END_TIME)
                .members(Set.of(Member.builder()
                        .id("m2")
                        .name("name2")
                        .nickname("nickname2")
                        .status(MemberStatus.ACTIVE).build()))
                .build();

        sut.create(fitnessClass);

        assertNotNull(fitnessClass);
        assertEquals(fitnessClass.getCoach().getId(), MOCK_COACH.getId());
        assertEquals(fitnessClass.getId(), "fc1");
    }

    @Test
    void testCreateUnsuccessful() {
        FitnessClass fitnessClass = FitnessClass
                .builder()
                .id("fc1")
                .name("pilates")
                .coach(MOCK_COACH)
                .startTime(START_TIME)
                .endTime(END_TIME)
                .members(new HashSet<>())
                .build();
        assertThrows(UnknownFitnessClassException.class, () -> sut.create(fitnessClass));
    }

}
