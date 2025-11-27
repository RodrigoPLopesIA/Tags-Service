package com.rodrigolopesai.tags_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/tags")
public class TagsController {



    @GetMapping
    public ResponseEntity<String> index() {
        return ResponseEntity.ok().body("Hello world");
    }
    
    
}
