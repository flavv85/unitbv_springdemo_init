package com.unitbv.spring_boot_tutorial.Ddomain;

import com.unitbv.spring_boot_tutorial.Ddomain.exceptions.UnknownFitnessClassException;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FitnessClassValidations {

    public static void CheckMembersNumberForOneFitnessClass(FitnessClass fitnessClass) {
        int membersSize = fitnessClass.getMembers().size();
        if (membersSize < 3) {
            throw new UnknownFitnessClassException(String.format("Fitness class %s has too few members", fitnessClass.getName()));
        } else if (membersSize > 8) {
            throw new UnknownFitnessClassException(String.format("Fitness class %s has too many members", fitnessClass.getName()));
        }
    }
    public static void CheckMembersNumbers(List<FitnessClass> fitnessClasses) {
        List<String> tooFewMembers=new ArrayList<>();
        List<String> tooManyMembers=new ArrayList<>();
        for(FitnessClass fitnessClass : fitnessClasses) {
            if(fitnessClass.getMembers().size() < 3) {
                tooFewMembers.add(fitnessClass.getName());
            }
            else if(fitnessClass.getMembers().size() > 8) {
                tooManyMembers.add(fitnessClass.getName());
            }
        }
        StringBuilder errorMessage=new StringBuilder();
        if(!tooFewMembers.isEmpty()) {
            errorMessage.append(String.format("Fitness classes %s have too few members",tooFewMembers));
        }
        if(!tooManyMembers.isEmpty()) {
            errorMessage.append(String.format("Fitness classes %s have too many members",tooManyMembers));
        }
        throw new UnknownFitnessClassException(errorMessage.toString());
    }

}
