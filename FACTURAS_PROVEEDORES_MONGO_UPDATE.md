# Actualización del Sistema de Facturas - MongoDB

## Resumen de Cambios

Se ha actualizado el sistema completo de facturas en MongoDB para que coincida exactamente con las entidades JPA existentes. Las entidades MongoDB ahora tienen los mismos campos y estructura que sus contrapartes en MySQL/JPA.

## Entidades MongoDB Actualizadas

### 1. FacturasProveedoresMongo
- **Ubicación**: `domain/mongo/entity/FacturasProveedoresMongo.java`
- **Campos** (idénticos a la entidad JPA):
  - `id` (String en lugar de Long)
  - `urlPdf`
  - `numeroFactura`
  - `fechaEmision`
  - `fechaRegistro`
  - `total`
  - `estadoDePago`
  - `productosRegistrados`
  - `visible`
  - `proveedorId` (referencia en lugar de objeto)
  - `detalleIds` (lista de referencias a detalles)

### 2. ProductoMongo
- **Ubicación**: `domain/mongo/entity/ProductoMongo.java`
- **Campos** (idénticos a la entidad JPA):
  - `id` (String en lugar de Long)
  - `nombreProducto`
  - `cantidadDisponoble` (manteniendo el typo de la entidad original)
  - `disponibilidad`
  - `fechaIngreso`
  - `visible`
  - `precio`
  - `categoriaId` (referencia en lugar de objeto)
  - `proveedorId` (referencia en lugar de objeto)

### 3. ProveedorMongo
- **Ubicación**: `domain/mongo/entity/ProveedorMongo.java`
- **Campos** (idénticos a la entidad JPA):
  - `id` (String en lugar de Long)
  - `nombreProveedor`
  - `rucProveedor`
  - `productosIds` (lista de referencias a productos)
  - `facturasIds` (lista de referencias a facturas)

### 4. DetalleFacturaProveedorMongo
- **Ubicación**: `domain/mongo/entity/DetalleFacturaProveedorMongo.java`
- **Campos** (idénticos a DetalleFacturaCliente JPA):
  - `id` (String en lugar de Long)
  - `facturaId` (referencia en lugar de objeto)
  - `productoId` (referencia en lugar de objeto)
  - `cantidad`
  - `precio`
  - Método `getSubtotal()` para cálculo dinámico

## Nuevas Entidades MongoDB

### 5. FacturaClienteMongo
- **Ubicación**: `domain/mongo/entity/FacturaClienteMongo.java`
- **Campos** (idénticos a la entidad JPA):
  - `id` (String en lugar de Long)
  - `fechaEmision`
  - `total`
  - `usuarioId` (referencia en lugar de objeto)
  - `detalleIds` (lista de referencias a detalles)

### 6. DetalleFacturaClienteMongo
- **Ubicación**: `domain/mongo/entity/DetalleFacturaClienteMongo.java`
- **Campos** (idénticos a la entidad JPA):
  - `id` (String en lugar de Long)
  - `facturaId` (referencia en lugar de objeto)
  - `productoId` (referencia en lugar de objeto)
  - `cantidad`
  - `precio`
  - Método `getSubtotal()` para cálculo dinámico

## Características Importantes

### Consistencia con JPA
- ✅ Todos los campos coinciden exactamente con las entidades JPA
- ✅ Se mantuvieron los nombres de campos tal como están en JPA (incluyendo typos como "cantidadDisponoble")
- ✅ Se eliminaron campos adicionales que no existen en JPA (como subtotal, impuestos, observaciones)
- ✅ Los tipos de datos son compatibles (Long -> String para IDs, referencias por ID en lugar de objetos)

### Funcionalidades Mantenidas
- ✅ Cálculos automáticos de totales
- ✅ Transaccionalidad en operaciones complejas
- ✅ APIs REST completas
- ✅ Repositorios con consultas especializadas
- ✅ Servicios con lógica de negocio

### Arquitectura
- ✅ Separación clara entre capas (domain, application, infrastructure)
- ✅ Uso de referencias por ID en lugar de objetos anidados (mejor para MongoDB)
- ✅ DTOs para operaciones complejas
- ✅ Controladores con manejo de errores

## Ejemplo de Uso

### Crear una factura de proveedor con productos

```json
POST /api/mongo/facturas-proveedores/con-detalles
{
  "factura": {
    "numeroFactura": "FAC-001",
    "fechaEmision": "2025-06-20",
    "proveedorId": "proveedor123",
    "estadoDePago": "PENDIENTE"
  },
  "detalles": [
    {
      "productoId": "producto1",
      "cantidad": 10,
      "precio": 15.50
    },
    {
      "productoId": "producto2",
      "cantidad": 5,
      "precio": 25.00
    }
  ]
}
```

## Repositorios y Servicios

- ✅ FacturasProveedoresMongoRepository - con consultas especializadas
- ✅ DetalleFacturaProveedorMongoRepository - para gestión de detalles
- ✅ ProductoMongoRepository - para gestión de productos
- ✅ ProveedorMongoRepository - para gestión de proveedores
- ✅ Servicios correspondientes con lógica de negocio
- ✅ Controladores REST con endpoints completos

## Compatibilidad

Las entidades MongoDB son ahora completamente compatibles con la estructura JPA existente, permitiendo:
- Migración de datos sencilla entre sistemas
- Consistencia en la lógica de negocio
- Mantenimiento simplificado del código
- Reutilización de validaciones y reglas de negocio
