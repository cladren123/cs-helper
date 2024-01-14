package com.cshelper.cshelper.exception;


import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.stream.Collectors;



@RestControllerAdvice
public class GlobalExceptionHandler {


  // DTO 형태와 다른 형태가 들어왔을 때 발생하는 에러
  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<String> handleTypeMismatch(HttpMessageNotReadableException e) {
    return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body("입력 타입이 잘 못 되었습니다.");
  }


  // DTO의 Null 값을 보냈을 때의 처리
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List<String>> handleNotValid(MethodArgumentNotValidException e) {
    List<String> errors = e.getBindingResult().getAllErrors().stream()
            .map(ObjectError::getDefaultMessage)
            .collect(Collectors.toList());

    return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(errors);
  }



}
