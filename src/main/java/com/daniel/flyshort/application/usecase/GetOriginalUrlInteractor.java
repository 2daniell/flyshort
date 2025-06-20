package com.daniel.flyshort.application.usecase;

import java.util.Optional;

import com.daniel.flyshort.core.entities.ShortUrl;
import com.daniel.flyshort.core.repository.FlyShortRepository;

public class GetOriginalUrlInteractor implements UseCase<String, Optional<ShortUrl>> {

    private final FlyShortRepository repository;

    public GetOriginalUrlInteractor(FlyShortRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<ShortUrl> execute(String slug) {
        return repository.findBySlug(slug);
    }
    
}
