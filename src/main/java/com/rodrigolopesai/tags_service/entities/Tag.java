package com.rodrigolopesai.tags_service.entities;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
@Document(collection = "tags")
public class Tag {

    @Id
    private String id;

    private String name;

    @CreatedDate 
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;
}
