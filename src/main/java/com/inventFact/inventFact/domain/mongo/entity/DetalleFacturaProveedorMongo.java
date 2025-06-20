package com.inventFact.inventFact.domain.mongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "detalle_factura_proveedor")
public class DetalleFacturaProveedorMongo {
    @Id
    private String id;
    private String facturaId; // Referencia a la factura
    private String productoId; // Referencia al producto
    private Integer cantidad;
    private Double precio; // Campo igual que en DetalleFacturaCliente

    // Constructor por defecto
    public DetalleFacturaProveedorMongo() {}

    // Constructor con parámetros
    public DetalleFacturaProveedorMongo(String facturaId, String productoId, Integer cantidad, Double precio) {
        this.facturaId = facturaId;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Getters y setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFacturaId() { return facturaId; }
    public void setFacturaId(String facturaId) { this.facturaId = facturaId; }

    public String getProductoId() { return productoId; }
    public void setProductoId(String productoId) { this.productoId = productoId; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    // Método auxiliar para calcular subtotal
    public Double getSubtotal() {
        if (cantidad != null && precio != null) {
            return cantidad * precio;
        }
        return 0.0;
    }
}
