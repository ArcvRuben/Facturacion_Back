package com.inventFact.inventFact.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "proveedor")
public class Proveedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProveedor;
    private String nombreProveedor;
    private String rucProveedor;

    @OneToMany(mappedBy = "proveedor",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Producto> productos;

    @OneToMany(mappedBy = "proveedor",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<FacturasProveedores> facturasProveedores;
}
