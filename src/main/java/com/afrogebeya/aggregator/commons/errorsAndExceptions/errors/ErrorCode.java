package com.afrogebeya.aggregator.commons.errorsAndExceptions.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public enum ErrorCode {
    SUCCESS(1,"Success",HttpStatus.OK),
    INVALID_PARAMETER(2,"Invalid Parameter",HttpStatus.BAD_REQUEST),
    UNEXPECTED_ERROR(3,"Unexpected error",HttpStatus.INTERNAL_SERVER_ERROR),
    UNAUTHORIZED(4,"Not authorized",HttpStatus.UNAUTHORIZED);
    int id;
    String name;
    HttpStatus httpStatus;
    ErrorCode(int id,String name, HttpStatus httpStatus){
        this.id=id;
        this.name=name;
        this.httpStatus=httpStatus;
    }

}
