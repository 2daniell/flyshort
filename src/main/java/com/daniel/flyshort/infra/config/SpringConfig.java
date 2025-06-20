package com.daniel.flyshort.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.daniel.flyshort.application.usecase.CreateShortUrlInteractor;
import com.daniel.flyshort.application.usecase.GetOriginalUrlInteractor;
import com.daniel.flyshort.core.repository.FlyShortRepository;
import com.daniel.flyshort.core.strategy.SlugGenerator;

@Configuration
public class SpringConfig {

    @Bean
    public CreateShortUrlInteractor createShortUrlInteractor(SlugGenerator generator, FlyShortRepository repository) {
        return new CreateShortUrlInteractor(generator, repository);
    }

    @Bean
    public GetOriginalUrlInteractor getOriginalUrlInteractor(FlyShortRepository repository) {
        return new GetOriginalUrlInteractor(repository);
    }
    
}
