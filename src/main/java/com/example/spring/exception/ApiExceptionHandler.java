package com.example.spring.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice(basePackages = "com.example.spring.Controller")
public class ApiExceptionHandler {

    @ExceptionHandler(ProdutoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> handleNotFound(ProdutoNotFoundException ex) {
        return Map.of(
                "error", "Não encontrado.",
                "message", ex.getMessage()
        );
    }
}
