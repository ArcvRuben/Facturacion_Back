package com.inventFact.inventFact.infrastructure.mongo.repository;

import com.inventFact.inventFact.domain.mongo.entity.FacturasProveedoresMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Date;

@Repository
public interface FacturasProveedoresMongoRepository extends MongoRepository<FacturasProveedoresMongo, String> {
    
    List<FacturasProveedoresMongo> findByProveedorId(String proveedorId);
    
    List<FacturasProveedoresMongo> findByEstadoDePago(String estadoDePago);
    
    List<FacturasProveedoresMongo> findByVisible(Boolean visible);
    
    List<FacturasProveedoresMongo> findByProductosRegistrados(Boolean productosRegistrados);
    
    List<FacturasProveedoresMongo> findByFechaEmisionBetween(Date fechaInicio, Date fechaFin);
    
    List<FacturasProveedoresMongo> findByProveedorIdAndEstadoDePago(String proveedorId, String estadoDePago);
    
    List<FacturasProveedoresMongo> findByNumeroFacturaContaining(String numeroFactura);
}
