package com.rodrigolopesai.tags_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigolopesai.tags_service.dtos.request.tag.RequestTagDTO;
import com.rodrigolopesai.tags_service.dtos.response.tag.ResponseTagDTO;
import com.rodrigolopesai.tags_service.entities.Tag;
import com.rodrigolopesai.tags_service.services.TagService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @PostMapping
    public ResponseEntity<ResponseTagDTO> create(@Valid @RequestBody RequestTagDTO tag) {
        ResponseTagDTO created = tagService.create(tag);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<Page<ResponseTagDTO>> findAll(Pageable page) {
        return ResponseEntity.ok(tagService.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseTagDTO> findById(@PathVariable String id) {
        return ResponseEntity.ok(tagService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseTagDTO> update(@PathVariable String id, @Valid @RequestBody RequestTagDTO tag) {
        return ResponseEntity.ok(tagService.update(id, tag));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        tagService.delete(id);
        return ResponseEntity.noContent().build();
    }
}