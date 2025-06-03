package com.inventFact.inventFact.application.service;

import com.inventFact.inventFact.domain.entity.Roles;
import com.inventFact.inventFact.domain.service.RolesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RolesService {

    private final RolesRepository rolesRepository;

    public List<Roles> findAll(){
        return rolesRepository.findAll();
    };

    public Roles findById(Long id){
        return rolesRepository.findById(id);
    };

    public Roles save(Roles rol){
        return rolesRepository.save(rol);
    };

    public void delete(Long id){
        rolesRepository.delete(id);
    };
}
