package com.inventFact.inventFact.infrastructure.mongo.repository;

import com.inventFact.inventFact.domain.mongo.entity.ProductoMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoMongoRepository extends MongoRepository<ProductoMongo, String> {
}
