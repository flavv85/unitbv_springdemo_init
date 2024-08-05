package com.unitbv.spring_boot_tutorial;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClass.CreateUpdateFitnessClassDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.Member.MemberDTO;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FitnessClassAPIITTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    Flyway flyway;

    @BeforeEach
    void init() {
        flyway.migrate();
    }

    @Test
    void testCreateFitnessClass() throws Exception {
        CreateUpdateFitnessClassDto dto = CreateUpdateFitnessClassDto
                .builder()
                .name("zumba")
                .startTime("2024-08-05T17:00")
                .endTime("2024-08-05T17:00")
                .coachId("151916c4-291c-4125-9ae7-d045eeece9ea")
                .members(Set.of(new MemberDTO("151916c4-291c-4125-9ae7-d045eeece9ee", "JohnnyR")))
                .build();

        mockMvc.perform(post("/api/fitness-class")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto))
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
