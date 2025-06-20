package com.daniel.flyshort.core.repository;

import java.util.Optional;

import com.daniel.flyshort.core.entities.ShortUrl;

public interface FlyShortRepository {
    
    Optional<ShortUrl> findBySlug(String slug);
    ShortUrl save(ShortUrl shortUrl);


}
