package com.unitbv.spring_boot_tutorial;

import com.unitbv.spring_boot_tutorial.Bapplication.FitnessClass.ConsultAllFitnessClasses;
import com.unitbv.spring_boot_tutorial.Ddomain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ConsultAllFitnessClassesTest {
    @Autowired
    ConsultAllFitnessClasses sut;

    @MockBean
    FitnessClasses fitnessClasses;

    @Test
    void testConsult() {
        LocalDateTime startTime = LocalDateTime.of(2024, 8, 5, 16, 0, 0);
        LocalDateTime endTime = LocalDateTime.of(2024, 8, 5, 18, 0, 0);

        Coach coach = Coach
                .builder()
                .name("Test Coach")
                .id("c1")
                .build();

        FitnessClass fitnessClass1 = FitnessClass
                .builder()
                .id("fc1")
                .name("zumba")
                .coach(coach)
                .startTime(startTime)
                .endTime(endTime)
                .members(Set.of(Member.builder()
                        .id("m1")
                        .name("name1")
                        .nickname("nickname1")
                        .status(MemberStatus.ACTIVE).build()))
                .build();

        FitnessClass fitnessClass2 = FitnessClass
                .builder()
                .id("fc2")
                .name("pilates")
                .coach(coach)
                .startTime(startTime)
                .endTime(endTime)
                .members(Set.of(Member.builder()
                        .id("m2")
                        .name("name2")
                        .nickname("nickname2")
                        .status(MemberStatus.ACTIVE).build()))
                .build();
        List<FitnessClass> fitnessClassList = List.of(fitnessClass1, fitnessClass2);
        when(fitnessClasses.getFitnessClasses()).thenReturn(fitnessClassList);
        List<FitnessClass> result = sut.consultAll();

        assertNotNull(result);
        assertEquals(result.size(), 2);
        assertEquals(result.stream().map(FitnessClass::getId).toList(), List.of("fc1", "fc2"));
        assertEquals(result.get(0).getCoach().getName(), result.get(1).getCoach().getName());
        assertEquals(result.stream().filter(fitnessClass -> fitnessClass.getId().equals("fc1")).map(fitnessClass -> fitnessClass.getStartTime().toLocalDate()).findFirst().get(), startTime.toLocalDate());
    }
}
