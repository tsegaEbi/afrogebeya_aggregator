package com.afrogebeya.aggregator.commons.models.views;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class ApiResponse <T>{
    T  data;
    String message;
    HttpStatus httpStatus;
    Boolean result;
}
