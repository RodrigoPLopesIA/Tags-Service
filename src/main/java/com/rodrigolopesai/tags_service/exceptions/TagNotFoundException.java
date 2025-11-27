package com.rodrigolopesai.tags_service.exceptions;

public class TagNotFoundException extends RuntimeException {


    public TagNotFoundException(String message) {
        super(message);
    }
}
