package com.unitbv.spring_boot_tutorial.Bapplication.member;

import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClasses;
import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import com.unitbv.spring_boot_tutorial.Ddomain.Members;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ConsultAllMembersByFitnessClass {
    Members members;
    FitnessClasses fitnessClasses;

    public Set<Member> consultAllByFitnessClass(String fitnessClassId)
    {
        FitnessClass fitnessClass = fitnessClasses.getFitnessClassById(fitnessClassId).orElseThrow();
        return fitnessClass.getMembers();

    }

}
