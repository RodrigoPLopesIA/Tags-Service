package com.rodrigolopesai.tags_service.dtos.response.tag;

import java.time.Instant;

public record ResponseTagDTO(String id, String name, Instant createdAt, Instant UpdateAT) {
    
}
