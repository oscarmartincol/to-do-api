package com.oscarmartincol.to_do_list.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleNotFound(RuntimeException ex) {

        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
