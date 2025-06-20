package com.daniel.flyshort.core.entities;

import java.time.LocalDateTime;

public class ShortUrl {

    private final Long id;
    private Slug slug;
    private String original;
    private final LocalDateTime createdAt;

    public ShortUrl(Long id, Slug slug, String original, LocalDateTime createdAt) {
        this.id = id;
        this.slug = slug;
        this.original = original;
        this.createdAt = createdAt;
    }

    public ShortUrl(Long id, Slug slug, String original) {
        this(id, slug, original, LocalDateTime.now());
    }

    public ShortUrl(Slug slug, String original) {
        this(null, slug, original);
    }

    public String getOriginal() {
        return original;
    }

    public Long getId() {
        return id;
    }

    public Slug getSlug() {
        return slug;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}
