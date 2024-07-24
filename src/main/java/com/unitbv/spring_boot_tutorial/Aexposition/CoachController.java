package com.unitbv.spring_boot_tutorial.Aexposition;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.ConsultCoachDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.CreateUpdateCoachDto;
import com.unitbv.spring_boot_tutorial.Aexposition.mapper.CoachMapperService;
import com.unitbv.spring_boot_tutorial.Bapplication.coach.*;
import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import lombok.AllArgsConstructor;
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
    ConsultCoachById consultCoachById;
    ConsultAllCoachesByName consultAllCoachesByName;
    UpdateCoach updateCoach;
    DeleteCoach deleteCoach;


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

<<<<<<< HEAD
    //TODO getbyid de coach
    @GetMapping("/{id}")
    public ResponseEntity<ConsultCoachDto> getById(@PathVariable String id)
    {
        Coach coach = createCoach.getById(id);
        return ResponseEntity.ok(coachMapperService.mapFromDomain(coach));
=======
    @GetMapping("/{coachId}")
    public ResponseEntity<ConsultCoachDto> consultById(@PathVariable String coachId) {
        return new ResponseEntity<>(coachMapperService.mapFromDomain(consultCoachById.consult(coachId)), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<ConsultCoachDto>> consultAllByName(@PathVariable String name) {
        List<Coach> coachList = consultAllCoachesByName.consultByName(name);
        List<ConsultCoachDto> consultCoachDtoList = coachList.stream().map(coach -> coachMapperService.mapFromDomain(coach)).toList();
        return ResponseEntity.ok(consultCoachDtoList);
    }

    //update coach
    @PutMapping(value = "/{id}")
    public ResponseEntity<ConsultCoachDto> updateCoach(
            @PathVariable String id,
            @RequestBody CreateUpdateCoachDto dto) {
        Coach toBeUpdatedCoach = coachMapperService.mapToEntity(dto, id);
        updateCoach.update(toBeUpdatedCoach);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // delete coach
    @DeleteMapping(value = "/delete-by-id/{id}")
    public ResponseEntity<Void> deleteCoachById(@PathVariable(value = "id") String id) {
        deleteCoach.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCoach(@PathVariable(value = "id") String id) {
        deleteCoach.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
>>>>>>> refs/heads/main
    }

}
