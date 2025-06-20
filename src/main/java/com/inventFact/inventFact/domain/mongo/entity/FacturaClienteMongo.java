package com.inventFact.inventFact.domain.mongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;

@Document(collection = "facturas_clientes")
public class FacturaClienteMongo {
    @Id
    private String id;
    private Date fechaEmision;
    private Double total;
    private String usuarioId; // Referencia al usuario
    private List<String> detalleIds; // Lista de IDs de detalles de factura

    // Constructor por defecto
    public FacturaClienteMongo() {}

    // Constructor con parámetros
    public FacturaClienteMongo(Date fechaEmision, String usuarioId) {
        this.fechaEmision = fechaEmision;
        this.usuarioId = usuarioId;
        this.total = 0.0;
    }

    // Getters y setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Date getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(Date fechaEmision) { this.fechaEmision = fechaEmision; }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }

    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }

    public List<String> getDetalleIds() { return detalleIds; }
    public void setDetalleIds(List<String> detalleIds) { this.detalleIds = detalleIds; }
}
