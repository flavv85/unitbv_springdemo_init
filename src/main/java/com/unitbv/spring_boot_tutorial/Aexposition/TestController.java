package com.unitbv.spring_boot_tutorial.Aexposition;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/ping-body")
    public ResponseEntity<String> pingWithResponseEntity() {
        //TODO de facut dupa masa
        return new ResponseEntity<>("RsadsrsdfsfsfRResponseEntity: Up and running!", HttpStatus.ACCEPTED);
    }

}
