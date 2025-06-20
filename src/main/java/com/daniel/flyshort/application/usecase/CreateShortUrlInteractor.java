package com.daniel.flyshort.application.usecase;

import com.daniel.flyshort.application.validator.LinkValidator;
import com.daniel.flyshort.core.entities.ShortUrl;
import com.daniel.flyshort.core.entities.Slug;
import com.daniel.flyshort.core.exceptions.InvalidUrlException;
import com.daniel.flyshort.core.repository.FlyShortRepository;
import com.daniel.flyshort.core.strategy.SlugGenerator;

public class CreateShortUrlInteractor implements UseCase<String, ShortUrl> {

    private final SlugGenerator slugGenerator;
    private final FlyShortRepository repository;

    public CreateShortUrlInteractor(SlugGenerator slugGenerator, FlyShortRepository repository) {
        this.slugGenerator = slugGenerator;
        this.repository = repository;
    }

    @Override
    public ShortUrl execute(String originalUrl) {

        if (!LinkValidator.validate(originalUrl)) {
            throw new InvalidUrlException("Invalid URL");
        }
        
        Slug slug = slugGenerator.generate();

        while(repository.findBySlug(slug.getValue()).isPresent()) {
            slug = slugGenerator.generate();
        }

        ShortUrl shortUrl = new ShortUrl(slug, originalUrl);
        return repository.save(shortUrl);
    }
}