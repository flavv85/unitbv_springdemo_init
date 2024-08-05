package com.unitbv.spring_boot_tutorial.Aexposition;


import com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClass.ConsultFitnessClassDTO;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClass.CreateUpdateFitnessClassDto;
import com.unitbv.spring_boot_tutorial.Aexposition.mapper.FitnessClassMapperService;
import com.unitbv.spring_boot_tutorial.Bapplication.FitnessClass.*;
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
    ConsultFitnessClassesByID consultFitnessClassesByID;
    CreateFitnessClass createFitnessClass;
    DeleteFitnessClass deleteFitnessClass;
    UpdateFitnessClass updateFitnessClass;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateUpdateFitnessClassDto dto) {
        FitnessClass toBePersistedFitnessClass = fitnessClassMapperService.mapToEntity(dto, null);
        createFitnessClass.create(toBePersistedFitnessClass);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultFitnessClassDTO> getById(@PathVariable String id) {
        Optional<FitnessClass> fitnessClass = consultFitnessClassesByID.ConsultById(id);
        if (fitnessClass.isPresent()) {
            ConsultFitnessClassDTO fitnessClassDto = fitnessClassMapperService.mapFromDomain(fitnessClass.get());
            return new ResponseEntity<>(fitnessClassDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<ConsultFitnessClassDTO>> consultAll() {
        List<FitnessClass> fitnessClasses = consultAllFitnessClasses.ConsultAll();
        List<ConsultFitnessClassDTO> fitnessClassDtoList = fitnessClasses.stream().map(fitnessClassMapperService::mapFromDomain).toList();
        return new ResponseEntity<>(fitnessClassDtoList, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-by-id/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") String id) {
        deleteFitnessClass.Delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ConsultFitnessClassDTO> updateFitnessClass(
            @PathVariable String id,
            @RequestBody CreateUpdateFitnessClassDto dto) {
        FitnessClass toBeUpdatedFitnessClass = fitnessClassMapperService.mapToEntity(dto, id);
        updateFitnessClass.update(toBeUpdatedFitnessClass);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
