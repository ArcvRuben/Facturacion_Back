package com.inventFact.inventFact.infrastructure.adapter;

import com.inventFact.inventFact.domain.entity.Roles;
import com.inventFact.inventFact.domain.service.RolesRepository;
import com.inventFact.inventFact.infrastructure.persistence.RolJpaRepositoty;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Repository
public class RolesJpaAdapter implements RolesRepository {

    private final RolJpaRepositoty rolJpaRepositoty;

    @Override
    public List<Roles> findAll() {
        return rolJpaRepositoty.findAll();
    }

    @Override
    public Roles findById(Long id) {
        return rolJpaRepositoty.findById(id).orElseThrow(() -> new EntityNotFoundException("No existen datos"));
    }

    @Override
    public Roles save(Roles rol) {
        return rolJpaRepositoty.save(rol);
    }

    @Override
    public void delete(Long id) {
        rolJpaRepositoty.deleteById(id);
    }
}
