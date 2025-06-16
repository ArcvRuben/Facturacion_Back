package com.inventFact.inventFact.infrastructure.mongo.repository;

import com.inventFact.inventFact.domain.mongo.entity.ProveedorMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProveedorMongoRepository extends MongoRepository<ProveedorMongo, String> {
}
