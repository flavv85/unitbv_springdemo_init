package com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClasses;



import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateUpdateFitnessClassDTO {
    public LocalDateTime startTime;
    public LocalDateTime endTime;

}
