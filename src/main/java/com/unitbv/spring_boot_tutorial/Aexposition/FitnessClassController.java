package com.unitbv.spring_boot_tutorial.Aexposition;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.Coaches.ConsultCoachDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClasses.ConsultFitnessClassDTO;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClasses.CreateUpdateFitnessClassDTO;
import com.unitbv.spring_boot_tutorial.Aexposition.mapper.FitnessClassMapperService;
import com.unitbv.spring_boot_tutorial.Bapplication.FitnessClasses.ConsultAllFitnessClasses;
import com.unitbv.spring_boot_tutorial.Bapplication.FitnessClasses.CreateUpdateFitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/fitnessClass")
public class FitnessClassController {
    ConsultAllFitnessClasses consultAllFitnessClasses;
    CreateUpdateFitnessClass createUpdateFitnessClass;
    FitnessClassMapperService fitnessClassMapperService;

    @GetMapping
    public ResponseEntity<List<ConsultFitnessClassDTO>> consultAll() {
        List<FitnessClass> fitnessClasses =consultAllFitnessClasses.ConsultAllFitnessClasses();
        List<ConsultFitnessClassDTO> fitnessClassDTOList = fitnessClasses.stream().map(fitnessClassMapperService::mapFromDomain).toList();
        return new ResponseEntity<>(fitnessClassDTOList, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateUpdateFitnessClassDTO DTO) {
        FitnessClass newFitnessClass=fitnessClassMapperService.mapToEntity(DTO,null);
        createUpdateFitnessClass.Create(newFitnessClass);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
