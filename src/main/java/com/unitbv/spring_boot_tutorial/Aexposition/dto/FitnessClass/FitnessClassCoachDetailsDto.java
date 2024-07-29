package com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class FitnessClassCoachDetailsDto {

    String name;
    String id;
    String duration;

    // added method to format the display the hour format nicely when return data in dto
    public String appendHourToDuration(String duration) {
        if (duration.equals("1")) {
            return duration + " hour";
        }
        return duration + " hours";
    }

}
