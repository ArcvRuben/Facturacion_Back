package com.inventFact.inventFact.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "facturasProveedores")
public class FacturasProveedores implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactura;
    private String urlPdf;
    private String numeroFactura;
    private Date fechaEmision;
    private Date fechaRegistro;
    private Double total;
    private String estadoDePago;
    private Boolean productosRegistrados;
    private Boolean visible;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProveedor")
    private Proveedor proveedor;
}
