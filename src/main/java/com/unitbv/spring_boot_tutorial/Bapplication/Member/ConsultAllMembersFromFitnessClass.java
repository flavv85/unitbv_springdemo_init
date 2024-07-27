package com.unitbv.spring_boot_tutorial.Bapplication.Member;

import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import com.unitbv.spring_boot_tutorial.Ddomain.Members;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE, makeFinal=true)
public class ConsultAllMembersFromFitnessClass {
    Members members;
    public Optional<Set<Member>> ConsutlAll(FitnessClass fitnessClass)
    {
        return members.GetMembersByFitnessClass(fitnessClass);
    }

}
