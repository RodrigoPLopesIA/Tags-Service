package com.rodrigolopesai.tags_service.dtos.response.error;

import org.springframework.http.HttpStatus;

public record ResponseErrorDTO(String message, HttpStatus status) {
    
}
