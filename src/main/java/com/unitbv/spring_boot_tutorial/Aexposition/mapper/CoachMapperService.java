package com.unitbv.spring_boot_tutorial.Aexposition.mapper;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.Coach.ConsultCoachDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.Coach.CreateUpdateCoachDto;
import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Service
public class CoachMapperService {

    public ConsultCoachDto mapFromDomain(Coach coach) {
        return ConsultCoachDto
                .builder()
                .id(coach.getId())
                .name(coach.getName())
                .build();
    }

    public Coach mapToEntity(CreateUpdateCoachDto dto, String coachId) {
        Coach coach = new Coach();
        coach.setId(StringUtils.hasText(coachId) ? coachId : String.valueOf(UUID.randomUUID()));
        coach.setName(dto.getName());
        return coach;
    }

}
