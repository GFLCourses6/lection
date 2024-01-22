package org.example.webIntegration;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Set;

@ControllerAdvice
public class ExceptionCustomHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class) // передаем ексепшн который нам нужно хендлить для контроллера
    public ResponseEntity<String> validationHandleException(MethodArgumentNotValidException methodArgumentNotValidException){
        List<ObjectError> allErrors = methodArgumentNotValidException.getAllErrors();
        String errorMessage = "" ;

        if(!allErrors.isEmpty()){
            StringBuilder stringBuilder = new StringBuilder();
            allErrors
                    .forEach(constraintViolation -> stringBuilder.append(constraintViolation.getDefaultMessage()).append("\n"));
            errorMessage = stringBuilder.toString();
        }

        return ResponseEntity.ok(errorMessage);
    }

    @ExceptionHandler(ConstraintViolationException.class) // передаем ексепшн который нам нужно хендлить для контроллера
    public ResponseEntity<String> validationHandleException(ConstraintViolationException constraintViolationException){
        Set<ConstraintViolation<?>> constraintViolations = constraintViolationException.getConstraintViolations();
        String errorMessage = "" ;

        if(!constraintViolations.isEmpty()){
            StringBuilder stringBuilder = new StringBuilder();
            constraintViolations
                    .forEach(constraintViolation -> stringBuilder.append(constraintViolation.getMessage()).append("\n"));
            errorMessage = stringBuilder.toString();
        }

        return ResponseEntity.ok(errorMessage);
    }
}

