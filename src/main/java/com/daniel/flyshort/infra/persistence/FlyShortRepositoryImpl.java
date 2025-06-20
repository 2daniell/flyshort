package com.daniel.flyshort.infra.persistence;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.daniel.flyshort.core.entities.ShortUrl;
import com.daniel.flyshort.core.repository.FlyShortRepository;
import com.daniel.flyshort.infra.persistence.mapper.ShortUrlMapper;
import com.daniel.flyshort.infra.persistence.model.ShortUrlModel;

@Repository
public class FlyShortRepositoryImpl implements FlyShortRepository {

    private final SpringDataFlyShortRepository repository;
    private final ShortUrlMapper mapper;

    public FlyShortRepositoryImpl(SpringDataFlyShortRepository repository, ShortUrlMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<ShortUrl> findBySlug(String slug) {
        Optional<ShortUrlModel> optionalUrl = repository.findBySlug(slug);
        return optionalUrl.isEmpty() ? Optional.empty() : optionalUrl.map(mapper::toDomain);
    }

    @Override
    public ShortUrl save(ShortUrl shortUrl) {
        ShortUrlModel model = mapper.toModel(shortUrl);
        return mapper.toDomain(repository.save(model));
    }

    @Override
    public Long count() {
        return repository.count();
    }
    
}
