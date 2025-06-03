package com.inventFact.inventFact.infrastructure.persistence;

import com.inventFact.inventFact.domain.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolJpaRepositoty extends JpaRepository<Roles,Long> {
}
