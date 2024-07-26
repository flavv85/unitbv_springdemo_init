package com.unitbv.spring_boot_tutorial.Aexposition;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClass.ConsultFitnessClassDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClass.CreateUpdateFitnessClassDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.Member.ConsultMemberDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.Member.CreateUpdateMemberDto;
import com.unitbv.spring_boot_tutorial.Aexposition.mapper.FitnessClassMapper;
import com.unitbv.spring_boot_tutorial.Bapplication.fitnessClass.*;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fitnessclasses")
@AllArgsConstructor
public class FitnessClassController {

    ConsultAllFitnessClasses consultAllFitnessClasses;
    FitnessClassMapper fitnessClassMapper;
    CreateFitnessClass createFitnessClass;
    FitnessClassService fitnessClassService;

    UpdateFitnessClass updateFitnessClass;
    DeleteFitnessClass deleteFitnessClass;

    @GetMapping
    public ResponseEntity<List<ConsultFitnessClassDto>> consultAll()
    {
        List<FitnessClass> fitnessClasses = consultAllFitnessClasses.consultAll();
        List<ConsultFitnessClassDto> fitnessClassDtoList = fitnessClasses.stream().map(fitnessClassMapper::mapFromDomain).toList();
        return new ResponseEntity<>(fitnessClassDtoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateUpdateFitnessClassDto dto) {
        FitnessClass toBePersistedFitnessClass = fitnessClassMapper.mapToEntity(dto, null);
        createFitnessClass.create(toBePersistedFitnessClass);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultFitnessClassDto> getFitnessClassById(@PathVariable String id)
    {
        Optional<FitnessClass> fitnessClass = fitnessClassService.getFitnessClassById(id);
        ConsultFitnessClassDto consultFitnessClassDto = fitnessClassMapper.mapFromDomain(fitnessClass.get());
        return new ResponseEntity<>(consultFitnessClassDto, HttpStatus.OK);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<ConsultMemberDto> updateMember(
            @PathVariable String id,
            @RequestBody CreateUpdateFitnessClassDto dto) {
        FitnessClass toBeUpdatedFitnessClass = fitnessClassMapper.mapToEntity(dto, id);
        updateFitnessClass.update(toBeUpdatedFitnessClass);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCoach(@PathVariable(value = "id") String id) {
        deleteFitnessClass.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
