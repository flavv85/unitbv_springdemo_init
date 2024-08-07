package com.unitbv.spring_boot_tutorial.Ddomain;

import com.unitbv.spring_boot_tutorial.Ddomain.exceptions.UnknownFitnessClassException;
import com.unitbv.spring_boot_tutorial.Ddomain.exceptions.UnknownMemberException;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
//@AllArgsConstructor
public class FitnessClassValidations {

   public void checkMembersNumberForOneFitnessClass(FitnessClass fitnessClass) {
        int membersSize = 0;
        if (fitnessClass.getMembers() != null) {
            membersSize = fitnessClass.getMembers().size();
        }
        if (membersSize < 1) {
            throw new UnknownFitnessClassException(String.format("Fitness class %s has too few members", fitnessClass.getName()));
        } else if (membersSize > 8) {
            throw new UnknownFitnessClassException(String.format("Fitness class %s has too many members", fitnessClass.getName()));
        }
    }

    //TODO remove static, use dependency injection
    //TODO this check must set on the save/update part
    public void CheckMembersNumbers(List<FitnessClass> fitnessClasses) {
        for (FitnessClass fitnessClass : fitnessClasses) {
            if (fitnessClass.getMembers().isEmpty()) {
                throw new UnknownMemberException(String.format("Fitness class %s has %s which are not enough members", fitnessClass.getName(), fitnessClass.getMembers().size()));
            } else if (fitnessClass.getMembers().size() > 8) {
                throw new UnknownMemberException(String.format("Fitness class %s has %s which are too many members", fitnessClass.getName(), fitnessClass.getMembers().size()));
            }
        }
    }

}
