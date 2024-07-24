package com.unitbv.spring_boot_tutorial.Aexposition.dto;

import lombok.*;

<<<<<<< HEAD
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateUpdateFitnessClassDto {
    public String id;

    public LocalDateTime startTime;

    public LocalDateTime endTime;

    public String getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
=======
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CreateUpdateFitnessClassDto {
    String startTime;
    String endTime;
    String coachId;
>>>>>>> refs/heads/main
}
