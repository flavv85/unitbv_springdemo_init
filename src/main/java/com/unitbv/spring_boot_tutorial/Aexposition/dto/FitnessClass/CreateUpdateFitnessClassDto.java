package com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClass;

import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import com.unitbv.spring_boot_tutorial.Ddomain.Member;

import java.time.LocalDateTime;
import java.util.Set;

public class CreateUpdateFitnessClassDto {
    LocalDateTime startTime;
    LocalDateTime endTime;
    Coach coach;
    Set<Member> members;

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Coach getCoach() {
        return coach;
    }

    public Set<Member> getMembers() {
        return members;
    }
}
