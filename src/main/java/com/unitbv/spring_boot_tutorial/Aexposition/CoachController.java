package com.unitbv.spring_boot_tutorial.Aexposition;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.Coaches.ConsultCoachDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.Coaches.CreateUpdateCoachDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.Members.ConsultMembersDTO;
import com.unitbv.spring_boot_tutorial.Aexposition.mapper.CoachMapperService;
import com.unitbv.spring_boot_tutorial.Bapplication.Member.ConsultMembersByID;
import com.unitbv.spring_boot_tutorial.Bapplication.coach.ConsultAllCoaches;
import com.unitbv.spring_boot_tutorial.Bapplication.coach.ConsultCoachesByID;
import com.unitbv.spring_boot_tutorial.Bapplication.coach.CreateCoach;
import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/coach")
public class CoachController {

    private final ConsultCoachesByID consultCoachesByID;
    ConsultAllCoaches consultAllCoaches;
    CoachMapperService coachMapperService;
    CreateCoach createCoach;
    ConsultMembersByID consultMembersByID;

    @GetMapping
    public ResponseEntity<List<ConsultCoachDto>> consultAll() {
        List<Coach> coaches = consultAllCoaches.consultAll();
        List<ConsultCoachDto> coachDtoList = coaches.stream().map(coachMapperService::mapFromDomain).toList();
        return new ResponseEntity<>(coachDtoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateUpdateCoachDto dto) {
        Coach toBePersistedCoach = coachMapperService.mapToEntity(dto, null);
        createCoach.create(toBePersistedCoach);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultCoachDto> getCoachById(@PathVariable String id) {
        Optional<Coach> coach=consultCoachesByID.getCoachById(id);
        if(coach.isPresent()) {
            ConsultCoachDto memberDTO= coachMapperService.mapFromDomain(coach.get());
            return new ResponseEntity<>(memberDTO,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    //TODO getbyid de coach

}
