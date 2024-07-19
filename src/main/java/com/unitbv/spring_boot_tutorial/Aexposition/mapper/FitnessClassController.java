package com.unitbv.spring_boot_tutorial.Aexposition.mapper;


import com.unitbv.spring_boot_tutorial.Aexposition.dto.*;
import com.unitbv.spring_boot_tutorial.Bapplication.coach.FitnessClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fitness-classes")
public class FitnessClassController {

    @Autowired
    private FitnessClassService fitnessClassService;

    @GetMapping
    public List<FitnessClassDto> getAll() {
        return fitnessClassService.getAll();
    }

    @GetMapping("/{id}")
    public FitnessClassDto getById(@PathVariable Long id) {
        return fitnessClassService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody CreateUpdateFitnessClassDto createUpdateFitnessClassDto) {
        fitnessClassService.create(createUpdateFitnessClassDto);
    }
}
