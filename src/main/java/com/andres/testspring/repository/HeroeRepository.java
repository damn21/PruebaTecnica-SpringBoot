package com.andres.testspring.repository;

import com.andres.testspring.model.Heroe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Query creation:
// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#appendix.query.method.subject
public interface HeroeRepository extends JpaRepository<Heroe, Long> {
}
