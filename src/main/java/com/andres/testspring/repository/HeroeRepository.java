package com.andres.testspring.repository;

import com.andres.testspring.model.Heroe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

// Query creation:
// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#appendix.query.method.subject

@Repository
public interface HeroeRepository extends JpaRepository<Heroe, Long> {
    List<Heroe> findByNameContainsIgnoreCase(@NonNull String name);



}
