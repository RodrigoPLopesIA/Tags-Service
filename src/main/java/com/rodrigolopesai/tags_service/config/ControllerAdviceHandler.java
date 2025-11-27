package com.rodrigolopesai.tags_service.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rodrigolopesai.tags_service.dtos.response.error.ResponseErrorDTO;
import com.rodrigolopesai.tags_service.exceptions.TagAlreadyExistsException;
import com.rodrigolopesai.tags_service.exceptions.TagNotFoundException;


@ControllerAdvice
public class ControllerAdviceHandler {
    

    @ExceptionHandler(TagNotFoundException.class)
    public ResponseEntity<ResponseErrorDTO> tagNotFoundException(TagNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseErrorDTO(ex.getMessage(), HttpStatus.NOT_FOUND));
    }

    @ExceptionHandler(TagAlreadyExistsException.class)
    public ResponseEntity<ResponseErrorDTO> tagAlreadyExistsException(TagAlreadyExistsException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseErrorDTO(ex.getMessage(), HttpStatus.BAD_REQUEST));
    }
}   
