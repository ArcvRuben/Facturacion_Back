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
    // Puedes agregar listas de productos y facturas como referencias si lo deseas
    // private List<String> productosIds;
    // private List<String> facturasIds;
    // Getters y setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombreProveedor() { return nombreProveedor; }
    public void setNombreProveedor(String nombreProveedor) { this.nombreProveedor = nombreProveedor; }
    public String getRucProveedor() { return rucProveedor; }
    public void setRucProveedor(String rucProveedor) { this.rucProveedor = rucProveedor; }
}
