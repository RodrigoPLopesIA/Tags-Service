package com.rodrigolopesai.tags_service.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rodrigolopesai.tags_service.entities.Tag;
import com.rodrigolopesai.tags_service.exceptions.TagNotFoundException;
import com.rodrigolopesai.tags_service.repositories.TagRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TagService {


    private final TagRepository tagRepository;

    public Tag create(Tag tag) {

        return tagRepository.save(tag);
    }

    public List<Tag> findAll() {
        return tagRepository.findAll();
    }
    public Tag findById(String id) {
        return tagRepository.findById(id)
                .orElseThrow(() -> new TagNotFoundException("Tag not found"));
    }

    public Tag update(String id, Tag updated) {
        Tag existing = findById(id);

        existing.setName(updated.getName());

        return tagRepository.save(existing);
    }


    public void delete(String id) {
        Tag existing = findById(id);
        tagRepository.delete(existing);
    }

    public List<Tag> findByIds(List<String> ids) {
        return tagRepository.findAllById(ids);
    }


}
