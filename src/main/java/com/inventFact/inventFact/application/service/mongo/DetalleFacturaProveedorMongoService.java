package com.inventFact.inventFact.application.service.mongo;

import com.inventFact.inventFact.domain.mongo.entity.DetalleFacturaProveedorMongo;
import com.inventFact.inventFact.infrastructure.mongo.repository.DetalleFacturaProveedorMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleFacturaProveedorMongoService {
    
    @Autowired
    private DetalleFacturaProveedorMongoRepository detalleRepository;
      public DetalleFacturaProveedorMongo save(DetalleFacturaProveedorMongo detalle) {
        return detalleRepository.save(detalle);
    }
    
    public List<DetalleFacturaProveedorMongo> findAll() {
        return detalleRepository.findAll();
    }
    
    public Optional<DetalleFacturaProveedorMongo> findById(String id) {
        return detalleRepository.findById(id);
    }
    
    public List<DetalleFacturaProveedorMongo> findByFacturaId(String facturaId) {
        return detalleRepository.findByFacturaId(facturaId);
    }
    
    public List<DetalleFacturaProveedorMongo> findByProductoId(String productoId) {
        return detalleRepository.findByProductoId(productoId);
    }
    
    public void deleteById(String id) {
        detalleRepository.deleteById(id);
    }
    
    public void deleteByFacturaId(String facturaId) {
        detalleRepository.deleteByFacturaId(facturaId);
    }
      public List<DetalleFacturaProveedorMongo> saveAll(List<DetalleFacturaProveedorMongo> detalles) {
        return detalleRepository.saveAll(detalles);
    }
      public Double calcularTotalPorFactura(String facturaId) {
        List<DetalleFacturaProveedorMongo> detalles = findByFacturaId(facturaId);
        return detalles.stream()
                .mapToDouble(detalle -> detalle.getSubtotal())
                .sum();
    }
}
