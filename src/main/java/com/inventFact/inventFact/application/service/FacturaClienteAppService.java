package com.inventFact.inventFact.application.service;

import com.inventFact.inventFact.domain.entity.FacturaCliente;
import com.inventFact.inventFact.domain.entity.Producto;
import com.inventFact.inventFact.domain.entity.Usuario;
import com.inventFact.inventFact.domain.service.FacturaClienteService;
import com.inventFact.inventFact.domain.service.ProductoRepository;
import com.inventFact.inventFact.domain.service.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class FacturaClienteAppService {

    private final FacturaClienteService facturaClienteService;
    private final UsuarioRepository usuarioRepository;
    private final ProductoRepository productoRepository;

    public FacturaCliente crearFactura(FacturaCliente factura) {

        // Obtener el usuario desde el repositorio
        Usuario usuario = usuarioRepository.findById(factura.getUsuario().getId());
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }
        factura.setUsuario(usuario);

        // Cargar productos completos y asignar factura a cada detalle
        factura.getDetalles().forEach(detalle -> {
            Producto producto = productoRepository.findById(detalle.getProducto().getIdProducto());
            if (producto == null) {
                throw new RuntimeException("Producto no encontrado");
            }
            detalle.setProducto(producto);
            detalle.setFactura(factura);
        });

        factura.setFechaEmision(new Date());
        return facturaClienteService.save(factura);
    }

    public List<FacturaCliente> findAll() {
        return facturaClienteService.findAll();
    }
    public FacturaCliente findById(Long id) {
        return facturaClienteService.findById(id);
    }

    public void delete(Long id) {
        facturaClienteService.delete(id);
    }

}



