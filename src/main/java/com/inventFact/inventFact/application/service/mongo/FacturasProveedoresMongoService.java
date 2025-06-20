package com.inventFact.inventFact.application.service.mongo;

import com.inventFact.inventFact.domain.mongo.entity.FacturasProveedoresMongo;
import com.inventFact.inventFact.domain.mongo.entity.DetalleFacturaProveedorMongo;
import com.inventFact.inventFact.infrastructure.mongo.repository.FacturasProveedoresMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Date;

@Service
public class FacturasProveedoresMongoService {
    
    private final FacturasProveedoresMongoRepository repository;
    
    @Autowired
    private DetalleFacturaProveedorMongoService detalleService;

    public FacturasProveedoresMongoService(FacturasProveedoresMongoRepository repository) {
        this.repository = repository;
    }

    public List<FacturasProveedoresMongo> findAll() {
        return repository.findAll();
    }

    public Optional<FacturasProveedoresMongo> findById(String id) {
        return repository.findById(id);
    }

    public FacturasProveedoresMongo save(FacturasProveedoresMongo factura) {
        if (factura.getFechaRegistro() == null) {
            factura.setFechaRegistro(new Date());
        }
        return repository.save(factura);
    }    @Transactional
    public FacturasProveedoresMongo saveWithDetalles(FacturasProveedoresMongo factura, 
                                                    List<DetalleFacturaProveedorMongo> detalles) {
        // Guardar la factura primero
        FacturasProveedoresMongo facturaGuardada = save(factura);
        
        // Asignar el ID de la factura a todos los detalles
        detalles.forEach(detalle -> detalle.setFacturaId(facturaGuardada.getId()));
        
        // Guardar los detalles
        List<DetalleFacturaProveedorMongo> detallesGuardados = detalleService.saveAll(detalles);
        
        // Actualizar la factura con los IDs de los detalles
        List<String> detalleIds = new ArrayList<>();
        detallesGuardados.forEach(detalle -> detalleIds.add(detalle.getId()));
        facturaGuardada.setDetalleIds(detalleIds);
        
        // Calcular total
        Double total = detalleService.calcularTotalPorFactura(facturaGuardada.getId());
        facturaGuardada.setTotal(total);
        
        // Guardar la factura actualizada
        return repository.save(facturaGuardada);
    }

    public List<FacturasProveedoresMongo> findByProveedorId(String proveedorId) {
        return repository.findByProveedorId(proveedorId);
    }

    public List<FacturasProveedoresMongo> findByEstadoDePago(String estadoDePago) {
        return repository.findByEstadoDePago(estadoDePago);
    }

    public List<FacturasProveedoresMongo> findByVisible(Boolean visible) {
        return repository.findByVisible(visible);
    }

    @Transactional
    public void deleteById(String id) {
        // Eliminar primero los detalles asociados
        detalleService.deleteByFacturaId(id);
        // Luego eliminar la factura
        repository.deleteById(id);
    }

    public void updateEstadoPago(String id, String nuevoEstado) {
        Optional<FacturasProveedoresMongo> facturaOpt = findById(id);
        if (facturaOpt.isPresent()) {
            FacturasProveedoresMongo factura = facturaOpt.get();
            factura.setEstadoDePago(nuevoEstado);
            repository.save(factura);
        }
    }

    public void marcarProductosRegistrados(String id) {
        Optional<FacturasProveedoresMongo> facturaOpt = findById(id);
        if (facturaOpt.isPresent()) {
            FacturasProveedoresMongo factura = facturaOpt.get();
            factura.setProductosRegistrados(true);
            repository.save(factura);
        }
    }

    public List<DetalleFacturaProveedorMongo> getDetallesByFacturaId(String facturaId) {
        return detalleService.findByFacturaId(facturaId);
    }
}
