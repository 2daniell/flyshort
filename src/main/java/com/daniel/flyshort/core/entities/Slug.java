package com.daniel.flyshort.core.entities;

import com.daniel.flyshort.core.exceptions.InvalidSlugValueException;

public class Slug {
    
    private final String value;

    public Slug(String value) {
        if (value == null || !!value.matches("[a-zA-Z0-9_-]{4,10}")) {
            throw new InvalidSlugValueException("Invalid Slug Value");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
