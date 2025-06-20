package com.inventFact.inventFact.domain.mongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;

@Document(collection = "facturas_proveedores")
public class FacturasProveedoresMongo {
    @Id
    private String id;
    private String urlPdf;
    private String numeroFactura;
    private Date fechaEmision;
    private Date fechaRegistro;
    private Double total;
    private String estadoDePago;
    private Boolean productosRegistrados;
    private Boolean visible;
    private String proveedorId; // Referencia al proveedor
    private List<String> detalleIds; // Lista de IDs de detalles de factura    // Constructores
    public FacturasProveedoresMongo() {}

    public FacturasProveedoresMongo(String numeroFactura, Date fechaEmision, String proveedorId) {
        this.numeroFactura = numeroFactura;
        this.fechaEmision = fechaEmision;
        this.fechaRegistro = new Date();
        this.proveedorId = proveedorId;
        this.visible = true;
        this.productosRegistrados = false;
        this.estadoDePago = "PENDIENTE";
    }

    // Getters y setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUrlPdf() { return urlPdf; }
    public void setUrlPdf(String urlPdf) { this.urlPdf = urlPdf; }

    public String getNumeroFactura() { return numeroFactura; }
    public void setNumeroFactura(String numeroFactura) { this.numeroFactura = numeroFactura; }

    public Date getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(Date fechaEmision) { this.fechaEmision = fechaEmision; }

    public Date getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(Date fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }

    public String getEstadoDePago() { return estadoDePago; }
    public void setEstadoDePago(String estadoDePago) { this.estadoDePago = estadoDePago; }

    public Boolean getProductosRegistrados() { return productosRegistrados; }
    public void setProductosRegistrados(Boolean productosRegistrados) { this.productosRegistrados = productosRegistrados; }

    public Boolean getVisible() { return visible; }
    public void setVisible(Boolean visible) { this.visible = visible; }

    public String getProveedorId() { return proveedorId; }
    public void setProveedorId(String proveedorId) { this.proveedorId = proveedorId; }

    public List<String> getDetalleIds() { return detalleIds; }
    public void setDetalleIds(List<String> detalleIds) { this.detalleIds = detalleIds; }
}
