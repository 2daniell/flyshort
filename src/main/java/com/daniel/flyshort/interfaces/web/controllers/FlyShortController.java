package com.daniel.flyshort.interfaces.web.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.flyshort.application.usecase.CreateShortUrlInteractor;
import com.daniel.flyshort.application.usecase.GetOriginalUrlInteractor;
import com.daniel.flyshort.core.entities.ShortUrl;
import com.daniel.flyshort.interfaces.web.input.CreateShortUrlInput;
import com.daniel.flyshort.interfaces.web.output.ShortUrlOutput;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/s")
public class FlyShortController {

    private static final String ADDRESS = "http://localhost:8080/s/";

    private final GetOriginalUrlInteractor getOriginalUrlInteractor;
    private final CreateShortUrlInteractor createShortUrlInteractor;

    public FlyShortController(GetOriginalUrlInteractor getOriginalUrlInteractor,
            CreateShortUrlInteractor createShortUrlInteractor) {
        this.getOriginalUrlInteractor = getOriginalUrlInteractor;
        this.createShortUrlInteractor = createShortUrlInteractor;
    }

    @PostMapping
    public ResponseEntity<Object> createShortUrl(@RequestBody @Valid CreateShortUrlInput input) {
        ShortUrl shortUrl = createShortUrlInteractor.execute(input.url());
        return ResponseEntity.status(HttpStatus.CREATED).body(new ShortUrlOutput(ADDRESS + shortUrl.getSlug().getValue(), shortUrl.getOriginal()));
    }

    @GetMapping("/{slug}")
    public ResponseEntity<Object> getOriginalUrl(@PathVariable String slug) {
        Optional<ShortUrl> optional = getOriginalUrlInteractor.execute(slug);
        return optional.isPresent() ? ResponseEntity.status(HttpStatus.FOUND).header("Location", optional.get().getOriginal()).build(): 
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
}
