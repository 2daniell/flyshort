package com.daniel.flyshort.interfaces.web.input;

import jakarta.validation.constraints.NotBlank;

public record CreateShortUrlInput(
    @NotBlank
    String url
) {
    
}
