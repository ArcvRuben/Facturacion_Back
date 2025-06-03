package com.inventFact.inventFact.application.controlador;

import com.inventFact.inventFact.application.service.FacturasProveedoresService;
import com.inventFact.inventFact.domain.entity.FacturasProveedores;
import com.inventFact.inventFact.domain.entity.Proveedor;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/facturasProveedores")
@CrossOrigin("http://localhost:4200")
public class FacturasProveedoresController {

    private final FacturasProveedoresService facturasProveedoresService;

    private final String uploadDir = "uploads/";

    @GetMapping("/")
    public ResponseEntity<List<FacturasProveedores>> findAll(){
        List<FacturasProveedores> facturasProveedores = facturasProveedoresService.findAll();

        if (facturasProveedores.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(facturasProveedores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturasProveedores> findById(@PathVariable Long id){
        return ResponseEntity.ok(facturasProveedoresService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<FacturasProveedores> save(@RequestBody FacturasProveedores facturasProveedores){
        facturasProveedores.setVisible(true);
        return  ResponseEntity.status(HttpStatus.CREATED).body(facturasProveedoresService.save(facturasProveedores));
    }

    @PutMapping("/pdf/{id}")
    public ResponseEntity<FacturasProveedores> insertImg(@RequestParam("file") MultipartFile file, @PathVariable Long id) {
        try {
            File directory = new File(uploadDir);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            FacturasProveedores facturasProveedores = facturasProveedoresService.findById(id);
            if (facturasProveedores == null) {
                return ResponseEntity.notFound().build();
            }

            String originalFileName = file.getOriginalFilename();
            String fileExtension = "";

            if (originalFileName != null && originalFileName.contains(".")) {
                fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
            }

            // Generar nombre único usando UUID
            String uniqueFileName = UUID.randomUUID().toString() + fileExtension;
            Path filePath = Paths.get(uploadDir, uniqueFileName);
            Files.write(filePath, file.getBytes());

            String fileUrl = "/uploads/" + uniqueFileName;

            facturasProveedores.setUrlPdf(fileUrl);

            return ResponseEntity.status(HttpStatus.CREATED).body(facturasProveedoresService.save(facturasProveedores));
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el archivo PDF", e);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(facturasProveedoresService.findById(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        facturasProveedoresService.eliminarFactura(id);
        return ResponseEntity.noContent().build();
    }

}
