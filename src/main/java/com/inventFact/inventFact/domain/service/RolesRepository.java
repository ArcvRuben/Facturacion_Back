package com.inventFact.inventFact.domain.service;

import com.inventFact.inventFact.domain.entity.Roles;

import java.util.List;

public interface RolesRepository {

    public List<Roles> findAll();

    public Roles findById(Long id);

    public Roles save(Roles rol);

    public void delete(Long id);
}
