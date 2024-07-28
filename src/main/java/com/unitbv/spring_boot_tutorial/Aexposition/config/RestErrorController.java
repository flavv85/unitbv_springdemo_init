package com.unitbv.spring_boot_tutorial.Aexposition.config;

import com.unitbv.spring_boot_tutorial.Ddomain.exceptions.UnknownObjectException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RestErrorController extends ResponseEntityExceptionHandler {

    @ExceptionHandler()
    public ResponseEntity<CustomErrorMessage> handleUnknownObjectException(UnknownObjectException exception) {
        CustomErrorMessage customErrorMessage = CustomErrorMessage.builder()
                .title("Unknown Object Exception")
                .details(exception.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .build();

        return ResponseEntity
                .status(customErrorMessage.getStatus())
                .contentType(MediaType.APPLICATION_JSON)
                .body(customErrorMessage);
    }
}
