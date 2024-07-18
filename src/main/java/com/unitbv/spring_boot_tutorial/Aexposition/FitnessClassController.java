package com.unitbv.spring_boot_tutorial.Aexposition;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClasses.ConsultFitnessClassDTO;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClasses.CreateUpdateFitnessClassDTO;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.Members.ConsultMembersDTO;
import com.unitbv.spring_boot_tutorial.Aexposition.mapper.FitnessClassMapperService;
import com.unitbv.spring_boot_tutorial.Bapplication.FitnessClasses.ConsultAllFitnessClasses;
import com.unitbv.spring_boot_tutorial.Bapplication.FitnessClasses.ConsultFitnessClassesByID;
import com.unitbv.spring_boot_tutorial.Bapplication.FitnessClasses.CreateUpdateFitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/fitnessClass")
public class FitnessClassController {
    ConsultAllFitnessClasses consultAllFitnessClasses;
    CreateUpdateFitnessClass createUpdateFitnessClass;
    FitnessClassMapperService fitnessClassMapperService;
    ConsultFitnessClassesByID consultFitnessClassesByID;

    @GetMapping
    public ResponseEntity<List<ConsultFitnessClassDTO>> consultAll() {
        List<FitnessClass> fitnessClasses =consultAllFitnessClasses.ConsultAll();
        List<ConsultFitnessClassDTO> fitnessClassDTOList = fitnessClasses.stream().map(fitnessClassMapperService::mapFromDomain).toList();
        return new ResponseEntity<>(fitnessClassDTOList, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateUpdateFitnessClassDTO DTO) {
        FitnessClass newFitnessClass=fitnessClassMapperService.mapToEntity(DTO,null);
        createUpdateFitnessClass.Create(newFitnessClass);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ConsultFitnessClassDTO> getFitnessClassById(@PathVariable String id) {
        Optional<FitnessClass> fitnessClass=consultFitnessClassesByID.ConsultById(id);
        if(fitnessClass.isPresent()) {
            ConsultFitnessClassDTO fitnessClassDTO= fitnessClassMapperService.mapFromDomain(fitnessClass.get());
            return new ResponseEntity<>(fitnessClassDTO,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
