package com.unitbv.spring_boot_tutorial.Aexposition;


import com.unitbv.spring_boot_tutorial.Aexposition.dto.CreateUpdateFitnessClassDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClassDto;
import com.unitbv.spring_boot_tutorial.Aexposition.mapper.FitnessClassMapperService;
import com.unitbv.spring_boot_tutorial.Bapplication.fitness_class.ConsultAllFitnessClasses;
import com.unitbv.spring_boot_tutorial.Bapplication.fitness_class.CreateFitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/fitness-class")
public class FitnessClassController {

    ConsultAllFitnessClasses consultAllFitnessClasses;
    FitnessClassMapperService fitnessClassMapperService;
    CreateFitnessClass createFitnessClass;

    @GetMapping
    public ResponseEntity<List<FitnessClassDto>> consultAll() {
        List<FitnessClass> fitnessClasses = consultAllFitnessClasses.consultAll();
        List<FitnessClassDto> fitnessClassDtoList = fitnessClasses.stream().map(fitnessClassMapperService::mapFromDomain).toList();
        return new ResponseEntity<>(fitnessClassDtoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateUpdateFitnessClassDto dto) {
        FitnessClass toBePersistedFitnessClass = fitnessClassMapperService.mapToEntity(dto, null);
        createFitnessClass.create(toBePersistedFitnessClass);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FitnessClassDto> getById(@PathVariable String id) {
        Optional<FitnessClass> fitnessClass = consultAllFitnessClasses.consultById(id);
        if (fitnessClass.isPresent()) {
            FitnessClassDto fitnessClassDto = fitnessClassMapperService.mapFromDomain(fitnessClass.get());
            return new ResponseEntity<>(fitnessClassDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
