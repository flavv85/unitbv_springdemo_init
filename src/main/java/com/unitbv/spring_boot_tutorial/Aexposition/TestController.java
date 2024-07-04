package com.unitbv.spring_boot_tutorial.Aexposition;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/ping")
    public String ping() {
        return "Up and running!";
    }

    @GetMapping("/ping-body")
    public ResponseEntity<String> pingWithResponseEntity() {
        return new ResponseEntity<>("ResponseEntity: Up and running!", HttpStatus.ACCEPTED);
    }

}
