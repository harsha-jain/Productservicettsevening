package com.example.productservicettsevening.controller;

import com.example.productservicettsevening.Exceptions.NotFoundException;
import com.example.productservicettsevening.dtos.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvices {
    @ExceptionHandler(NotFoundException.class)

    public ResponseEntity<ErrorResponseDto>handleException(Exception e){
        ErrorResponseDto errorResponseDto=new ErrorResponseDto();
        errorResponseDto.setErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }

}
