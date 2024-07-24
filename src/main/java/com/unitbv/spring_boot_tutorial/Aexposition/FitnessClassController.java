package com.unitbv.spring_boot_tutorial.Aexposition;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.ConsultCoachDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.ConsultFitnessClassDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.CreateUpdateCoachDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.CreateUpdateFitnessClassDto;
import com.unitbv.spring_boot_tutorial.Aexposition.mapper.FitnessClassMapperService;
import com.unitbv.spring_boot_tutorial.Bapplication.fitnessClass.*;
import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
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

    FitnessClassMapperService fitnessClassMapperService;
    ConsultAllFitnessClasses consultAllFitnessClasses;
    CreateFitnessClass createFitnessClass;
    DeleteFitnessClass deleteFitnessClass;
    UpdateFitnessClass updateFitnessClass;
    ConsultFitnessClassById consultFitnessClassById;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateUpdateFitnessClassDto dto) {
        FitnessClass toBePersistedFitnessClass = fitnessClassMapperService.mapToEntity(dto, null);
        createFitnessClass.create(toBePersistedFitnessClass);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ConsultFitnessClassDto> getById(@PathVariable String id) {
        Optional<FitnessClass> fitnessClass = consultAllFitnessClasses.consultById(id);
        if (fitnessClass.isPresent()) {
            ConsultFitnessClassDto fitnessClassDto = fitnessClassMapperService.mapFromDomain(fitnessClass.get());
            return new ResponseEntity<>(fitnessClassDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public ResponseEntity<List<ConsultFitnessClassDto>> consultAll() {
        List<FitnessClass> fitnessClasses = consultAllFitnessClasses.consultAll();
        List<ConsultFitnessClassDto> fitnessClassDtoList = fitnessClasses.stream().map(fitnessClassMapperService::mapFromDomain).toList();
        return new ResponseEntity<>(fitnessClassDtoList, HttpStatus.OK);
    }


    //update fc
    @PutMapping(value = "/{id}")
    public ResponseEntity<ConsultCoachDto> updateFitnessClass(
            @PathVariable String id,
            @RequestBody CreateUpdateFitnessClassDto dto) {
        FitnessClass toBeUpdatedFitnessClass = fitnessClassMapperService.mapToEntity(dto, id);
        updateFitnessClass.update(toBeUpdatedFitnessClass);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // delete fc
    @DeleteMapping(value = "/delete-by-id/{id}")
    public ResponseEntity<Void> deleteFitnessClassById(@PathVariable(value = "id") String id) {
        deleteFitnessClass.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteFitnessClass(@PathVariable(value = "id") String id) {
        deleteFitnessClass.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}