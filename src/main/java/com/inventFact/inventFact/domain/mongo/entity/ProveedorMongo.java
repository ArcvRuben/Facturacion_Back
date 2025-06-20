package com.inventFact.inventFact.domain.mongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "proveedores")
public class ProveedorMongo {
    @Id
    private String id;
    private String nombreProveedor;
    private String rucProveedor;
    private List<String> productosIds; // Referencias a productos
    private List<String> facturasIds; // Referencias a facturas

    // Constructor por defecto
    public ProveedorMongo() {}

    // Constructor con parámetros
    public ProveedorMongo(String nombreProveedor, String rucProveedor) {
        this.nombreProveedor = nombreProveedor;
        this.rucProveedor = rucProveedor;
    }

    // Getters y setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombreProveedor() { return nombreProveedor; }
    public void setNombreProveedor(String nombreProveedor) { this.nombreProveedor = nombreProveedor; }

    public String getRucProveedor() { return rucProveedor; }
    public void setRucProveedor(String rucProveedor) { this.rucProveedor = rucProveedor; }

    public List<String> getProductosIds() { return productosIds; }
    public void setProductosIds(List<String> productosIds) { this.productosIds = productosIds; }

    public List<String> getFacturasIds() { return facturasIds; }
    public void setFacturasIds(List<String> facturasIds) { this.facturasIds = facturasIds; }
}
