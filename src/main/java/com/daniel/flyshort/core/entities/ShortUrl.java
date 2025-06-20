package com.daniel.flyshort.core.entities;

public class ShortUrl {

    private final Long id;
    private Slug slug;
    private final String original;

    public ShortUrl(Long id, Slug slug, String original) {
        this.id = id;
        this.slug = slug;
        this.original = original;
    }

    public ShortUrl(Slug slug, String original) {
        this(null, slug, original);
    }

    public String getOriginal() {
        return original;
    }

}
