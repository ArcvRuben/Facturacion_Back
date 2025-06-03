package com.inventFact.inventFact.infrastructure.persistence;

import com.inventFact.inventFact.domain.entity.Auth_rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRolJpaRepository extends JpaRepository<Auth_rol,Long> {
}
