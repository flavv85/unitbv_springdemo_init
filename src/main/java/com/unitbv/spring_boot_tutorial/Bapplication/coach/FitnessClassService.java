package com.unitbv.spring_boot_tutorial.Bapplication.coach;

        import com.unitbv.spring_boot_tutorial.Aexposition.dto.*;
        import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
        import com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.FitnessClassRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.stream.Collectors;

@Service
public class FitnessClassService {

    @Autowired
    private FitnessClassRepository fitnessClassRepository;

    public List<FitnessClassDto> getAll() {
        return fitnessClassRepository.findAll().stream().map(fitnessClass ->
                FitnessClassDto.builder()
                        .id(Long.valueOf(fitnessClass.getId()))
                        .build()
        ).collect(Collectors.toList());
    }

    public FitnessClassDto getById(Long id) {
        FitnessClass fitnessClass = fitnessClassRepository.findById(String.valueOf(id)).orElseThrow(() ->
                new RuntimeException("FitnessClass not found"));
        return FitnessClassDto.builder()
                .id(Long.valueOf(fitnessClass.getId()))
                .build();
    }


}
