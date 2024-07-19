package com.unitbv.spring_boot_tutorial.Aexposition;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.ConsultCoachDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.CreateUpdateCoachDto;
import com.unitbv.spring_boot_tutorial.Aexposition.mapper.CoachMapperService;
import com.unitbv.spring_boot_tutorial.Bapplication.coach.ConsultAllCoaches;
import com.unitbv.spring_boot_tutorial.Bapplication.coach.CreateCoach;
import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/coach")
public class CoachController {

    ConsultAllCoaches consultAllCoaches;
    CoachMapperService coachMapperService;
    CreateCoach createCoach;

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
    public ResponseEntity<ConsultCoachDto> getCoachById(@PathVariable String id){
        Coach coach = coachMapperService.findCoachById(id);
        ConsultCoachDto coachDto = coachMapperService.(coach);
        return new ResponseEntity<>(coachDto, HttpStatus.OK);
    }
    //TODO getbyid de coach

}
