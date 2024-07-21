package com.unitbv.spring_boot_tutorial.Aexposition;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClass.ConsultFitnessClassDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClass.CreateUpdateFitnessClassDto;
import com.unitbv.spring_boot_tutorial.Aexposition.mapper.FitnessClassMapper;
import com.unitbv.spring_boot_tutorial.Bapplication.fitnessClass.ConsultAllFitnessClasses;
import com.unitbv.spring_boot_tutorial.Bapplication.fitnessClass.CreateFitnessClass;
import com.unitbv.spring_boot_tutorial.Bapplication.fitnessClass.FitnessClassService;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
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
        Optional<FitnessClass> fitnessClass = fitnessClassService.getMemberById(id);
        ConsultFitnessClassDto consultFitnessClassDto = fitnessClassMapper.mapFromDomain(fitnessClass.get());
        return new ResponseEntity<>(consultFitnessClassDto, HttpStatus.OK);
    }

}
