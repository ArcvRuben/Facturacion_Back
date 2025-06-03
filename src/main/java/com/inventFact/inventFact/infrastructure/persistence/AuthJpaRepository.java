package com.inventFact.inventFact.infrastructure.persistence;

import com.inventFact.inventFact.domain.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthJpaRepository extends JpaRepository<Auth,Long> {

    Optional<Auth> findByUsername(String usuario);
}
