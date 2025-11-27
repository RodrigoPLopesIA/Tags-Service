package com.rodrigolopesai.tags_service.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rodrigolopesai.tags_service.dtos.request.tag.RequestTagDTO;
import com.rodrigolopesai.tags_service.dtos.response.tag.ResponseTagDTO;
import com.rodrigolopesai.tags_service.entities.Tag;
import com.rodrigolopesai.tags_service.exceptions.TagAlreadyExistsException;
import com.rodrigolopesai.tags_service.exceptions.TagNotFoundException;
import com.rodrigolopesai.tags_service.repositories.TagRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    public ResponseTagDTO create(RequestTagDTO request) {

        // Validação de duplicidade
        if (tagRepository.existsByNameIgnoreCase(request.name())) {
            throw new TagAlreadyExistsException("Tag already exists");
        }

        Tag tag = new Tag();
        tag.setName(request.name());

        Tag saved = tagRepository.save(tag);

        return new ResponseTagDTO(saved.getId(), saved.getName(), tag.getCreatedAt(), tag.getUpdatedAt());
    }

    public Page<ResponseTagDTO> findAll(Pageable page) {
        return tagRepository.findAll(page)
                .map(tag -> new ResponseTagDTO(tag.getId(), tag.getName(), tag.getCreatedAt(), tag.getUpdatedAt()));
    }

    // Retorna entidade (uso interno)
    private Tag findEntityById(String id) {
        return tagRepository.findById(id)
                .orElseThrow(() -> new TagNotFoundException("Tag not found"));
    }

    // Retorna DTO
    public ResponseTagDTO findById(String id) {
        Tag tag = findEntityById(id);
        return new ResponseTagDTO(tag.getId(), tag.getName(), tag.getCreatedAt(), tag.getUpdatedAt());
    }

    public ResponseTagDTO update(String id, RequestTagDTO updated) {
        Tag existing = findEntityById(id);

        existing.setName(updated.name());

        Tag saved = tagRepository.save(existing);

        return new ResponseTagDTO(saved.getId(), saved.getName(), saved.getCreatedAt(), saved.getUpdatedAt());
    }

    public void delete(String id) {
        Tag existing = findEntityById(id);
        tagRepository.delete(existing);
    }

    public List<ResponseTagDTO> findByIds(List<String> ids) {
        return tagRepository.findAllById(ids)
                .stream()
                .map(tag -> new ResponseTagDTO(tag.getId(), tag.getName(), tag.getCreatedAt(), tag.getUpdatedAt()))
                .toList();
    }
}

