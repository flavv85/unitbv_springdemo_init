package com.unitbv.spring_boot_tutorial.Aexposition.dto.Coaches;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateUpdateCoachDto {
    public String name;



//    public List<CreateUpdateFitnessClassDto> fitnessClasses;
    //TODO add a also a list of fitnessClass objects to demonstrate the power of the @OneToMany / @ManyToOne
//    public List<CreateUpdateFitnessClassDto> getFitnessClasses() {
//        return fitnessClasses;
//    }
}