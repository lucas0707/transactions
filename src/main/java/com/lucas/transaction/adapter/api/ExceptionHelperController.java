package com.lucas.transaction.adapter.api;

import com.lucas.transaction.exceptions.domain.DomainException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHelperController {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHelperController.class);

    @ExceptionHandler(value = { DomainException.class })
    public ResponseEntity<Object> handleDomainException(DomainException ex) {
        logger.error("Domain Error: " + ex.getMessage());
        return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

