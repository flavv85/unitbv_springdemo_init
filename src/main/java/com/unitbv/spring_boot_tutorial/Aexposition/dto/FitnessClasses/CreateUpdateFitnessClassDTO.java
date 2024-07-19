package com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClasses;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateUpdateFitnessClassDTO {
    public String coachID;
    public LocalDateTime startTime;
    public LocalDateTime endTime;

    /*

  }
    "coachID" :"f6efe923-8a91-4731-8a87-f7ee7fedee98",
    "endTime":"2024-06-25 13:00:00",
    "startTime":"2024-06-27 13:00:00"
}

     */

}
