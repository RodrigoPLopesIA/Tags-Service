package com.rodrigolopesai.tags_service.dtos.request.tag;

import jakarta.validation.constraints.NotBlank;

public record RequestTagDTO(@NotBlank String name) {
    
}
