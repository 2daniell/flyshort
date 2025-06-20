package com.daniel.flyshort.flyshort.core.entities;

public class ShortUrl {

    private final Long id;
    private Slug slug;
    private final String original;

    public ShortUrl(Long id, Slug slug, String original) {
        this.id = id;
        this.slug = slug;
        this.original = original;
    }

    
    
}
