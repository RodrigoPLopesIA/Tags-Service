package com.rodrigolopesai.tags_service.services;

import org.springframework.stereotype.Service;

import com.rodrigolopesai.tags_service.repositories.TagRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TagService {


    private final TagRepository tagRepository;

    


}
