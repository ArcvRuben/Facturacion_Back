package com.inventFact.inventFact.infrastructure.mongo.repository;

import com.inventFact.inventFact.domain.mongo.entity.FacturasProveedoresMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FacturasProveedoresMongoRepository extends MongoRepository<FacturasProveedoresMongo, String> {
}
