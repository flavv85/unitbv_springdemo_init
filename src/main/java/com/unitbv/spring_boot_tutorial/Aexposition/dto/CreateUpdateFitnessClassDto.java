package com.unitbv.spring_boot_tutorial.Aexposition.dto;

import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateUpdateFitnessClassDto {

    Coach coach;
    public Coach getCoach() {
        return coach;
    }
    public LocalDateTime startTime;
    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime endTime;
    public LocalDateTime getEndTime() {
        return endTime;
    }

}
