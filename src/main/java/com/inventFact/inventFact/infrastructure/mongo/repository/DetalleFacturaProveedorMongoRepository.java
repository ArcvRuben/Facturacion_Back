package com.inventFact.inventFact.infrastructure.mongo.repository;

import com.inventFact.inventFact.domain.mongo.entity.DetalleFacturaProveedorMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleFacturaProveedorMongoRepository extends MongoRepository<DetalleFacturaProveedorMongo, String> {
    
    List<DetalleFacturaProveedorMongo> findByFacturaId(String facturaId);
    
    List<DetalleFacturaProveedorMongo> findByProductoId(String productoId);
    
    void deleteByFacturaId(String facturaId);
}
