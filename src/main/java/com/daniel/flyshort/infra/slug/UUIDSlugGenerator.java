package com.daniel.flyshort.infra.slug;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.daniel.flyshort.core.entities.Slug;
import com.daniel.flyshort.core.strategy.SlugGenerator;

@Component
public class UUIDSlugGenerator implements SlugGenerator {

    @Override
    public Slug generate() {
        String slug = UUID.randomUUID().toString().substring(0, 8);
        return new Slug(slug);
    }
    
}
