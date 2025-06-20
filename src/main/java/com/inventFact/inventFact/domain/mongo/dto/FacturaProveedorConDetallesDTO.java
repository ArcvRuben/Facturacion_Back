package com.inventFact.inventFact.domain.mongo.dto;

import com.inventFact.inventFact.domain.mongo.entity.FacturasProveedoresMongo;
import com.inventFact.inventFact.domain.mongo.entity.DetalleFacturaProveedorMongo;

import java.util.List;

public class FacturaProveedorConDetallesDTO {
    
    private FacturasProveedoresMongo factura;
    private List<DetalleFacturaProveedorMongo> detalles;

    // Constructores
    public FacturaProveedorConDetallesDTO() {}

    public FacturaProveedorConDetallesDTO(FacturasProveedoresMongo factura, List<DetalleFacturaProveedorMongo> detalles) {
        this.factura = factura;
        this.detalles = detalles;
    }

    // Getters y setters
    public FacturasProveedoresMongo getFactura() {
        return factura;
    }

    public void setFactura(FacturasProveedoresMongo factura) {
        this.factura = factura;
    }

    public List<DetalleFacturaProveedorMongo> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleFacturaProveedorMongo> detalles) {
        this.detalles = detalles;
    }
}
