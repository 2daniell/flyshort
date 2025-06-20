package com.daniel.flyshort.infra.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.flyshort.infra.persistence.model.ShortUrlModel;

public interface SpringDataFlyShortRepository extends JpaRepository<ShortUrlModel, Long> {
    
    Optional<ShortUrlModel> findBySlug(String slug);
}
