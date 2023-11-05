/*
package com.agent47.StudentManagement.Exception;
import com.agent47.StudentManagement.entity.DuplicateFirstNameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<String> handleResponseStatusException(ResponseStatusException ex) {
        HttpStatusCode statusCode = ex.getStatusCode();
        String errorMessage = ex.getReason();
        return new ResponseEntity<>(errorMessage, statusCode);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return errors;
    }
    @ExceptionHandler(DuplicateFirstNameException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<String> handleDuplicateFirstNameException(DuplicateFirstNameException ex){
        String errorMessage =ex.getMessage();
        return new ResponseEntity<>(errorMessage,HttpStatus.CONFLICT);

    }
    
}
*/
