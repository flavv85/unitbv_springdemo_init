package com.unitbv.spring_boot_tutorial.Aexposition;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.ConsultCoachDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.ConsultFitnessClassDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.CreateUpdateCoachDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.CreateUpdateFitnessClassDto;
import com.unitbv.spring_boot_tutorial.Aexposition.mapper.CoachMapperService;
import com.unitbv.spring_boot_tutorial.Aexposition.mapper.FitnessClassMapperService;
import com.unitbv.spring_boot_tutorial.Bapplication.coach.ConsultAllCoaches;
import com.unitbv.spring_boot_tutorial.Bapplication.coach.ConsultAllFitnessClasses;
import com.unitbv.spring_boot_tutorial.Bapplication.coach.CreateCoach;
import com.unitbv.spring_boot_tutorial.Bapplication.coach.CreateFitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/fitnessclass")
public class FitnessClassController {

    ConsultAllFitnessClasses consultAllFitnessClasses;
    FitnessClassMapperService fitnessClassMapperService;
    CreateFitnessClass createFitnessClass;

    @GetMapping
    public ResponseEntity<List<ConsultFitnessClassDto>> consultAll() {
        List<FitnessClass> fitnessClasses = consultAllFitnessClasses.consultAll();
        List<ConsultFitnessClassDto> fitnessClassDtoList = fitnessClasses.stream().map(fitnessClassMapperService::mapFromDomain).toList();
        return new ResponseEntity<>(fitnessClassDtoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateUpdateFitnessClassDto dto) {
        FitnessClass toBePersistedFitnessClass = fitnessClassMapperService.mapToEntity(dto, null);
        createFitnessClass.create(toBePersistedFitnessClass);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
