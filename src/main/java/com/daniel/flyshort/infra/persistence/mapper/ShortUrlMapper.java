package com.daniel.flyshort.infra.persistence.mapper;

import org.springframework.stereotype.Component;

import com.daniel.flyshort.core.entities.ShortUrl;
import com.daniel.flyshort.core.entities.Slug;
import com.daniel.flyshort.infra.persistence.model.ShortUrlModel;

@Component
public class ShortUrlMapper {
    
    public ShortUrl toDomain(ShortUrlModel model) {
        return new ShortUrl(model.getId(), new Slug(model.getSlug()), model.getOriginal(), model.getCreateAt());
    }

    public ShortUrlModel toModel(ShortUrl entity) {
        return new ShortUrlModel(entity.getSlug().getValue(), entity.getOriginal(), entity.getCreatedAt());
    }

}
