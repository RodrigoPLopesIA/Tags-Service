package com.rodrigolopesai.tags_service.exceptions;

public class TagAlreadyExistsException extends RuntimeException {


    public TagAlreadyExistsException(String message) {
        super(message);
    }
}
