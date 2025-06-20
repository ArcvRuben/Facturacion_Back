package com.inventFact.inventFact.domain.mongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "productos")
public class ProductoMongo {
    @Id
    private String id;
    private String nombreProducto;
    private Double cantidadDisponoble; // Mantengo el typo igual que en JPA
    private Boolean disponibilidad;
    private Date fechaIngreso;
    private Boolean visible;
    private Double precio;
    private String categoriaId; // Referencia a la categoría
    private String proveedorId; // Referencia al proveedor

    // Constructor por defecto
    public ProductoMongo() {}

    // Constructor con parámetros principales
    public ProductoMongo(String nombreProducto, Double precio, String proveedorId, String categoriaId) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.proveedorId = proveedorId;
        this.categoriaId = categoriaId;
        this.fechaIngreso = new Date();
        this.visible = true;
        this.disponibilidad = true;
        this.cantidadDisponoble = 0.0;
    }

    // Getters y setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombreProducto() { return nombreProducto; }
    public void setNombreProducto(String nombreProducto) { this.nombreProducto = nombreProducto; }

    public Double getCantidadDisponoble() { return cantidadDisponoble; }
    public void setCantidadDisponoble(Double cantidadDisponoble) { this.cantidadDisponoble = cantidadDisponoble; }

    public Boolean getDisponibilidad() { return disponibilidad; }
    public void setDisponibilidad(Boolean disponibilidad) { this.disponibilidad = disponibilidad; }

    public Date getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(Date fechaIngreso) { this.fechaIngreso = fechaIngreso; }

    public Boolean getVisible() { return visible; }
    public void setVisible(Boolean visible) { this.visible = visible; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public String getCategoriaId() { return categoriaId; }
    public void setCategoriaId(String categoriaId) { this.categoriaId = categoriaId; }

    public String getProveedorId() { return proveedorId; }
    public void setProveedorId(String proveedorId) { this.proveedorId = proveedorId; }
}
