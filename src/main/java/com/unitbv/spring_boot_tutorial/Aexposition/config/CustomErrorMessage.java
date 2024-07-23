package com.unitbv.spring_boot_tutorial.Aexposition.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomErrorMessage {
    String title;
    HttpStatus status;
    String details;
}
