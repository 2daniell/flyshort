package com.daniel.flyshort.infra.persistence.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "urls", indexes = {
    @Index(name = "idx_slug", columnList = "slug")
})
public class ShortUrlModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true) @NotNull @NotBlank
    private String slug;

    @Column(nullable = false) @NotNull @NotBlank
    private String original;
    
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public ShortUrlModel() {}
    public ShortUrlModel(String slug, String original, LocalDateTime createdAt) {
        this.slug = slug;
        this.original = original;
        this.createdAt = createdAt;
    }

    public String getOriginal() {
        return original;
    }

    public Long getId() {
        return id;
    }

    public String getSlug() {
        return slug;
    }

    public LocalDateTime getCreateAt() {
        return createdAt;
    }

}
