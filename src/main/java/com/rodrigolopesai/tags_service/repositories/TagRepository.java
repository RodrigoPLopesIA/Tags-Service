package com.rodrigolopesai.tags_service.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rodrigolopesai.tags_service.entities.Tag;


public interface TagRepository extends MongoRepository<Tag, String>{
    
}
