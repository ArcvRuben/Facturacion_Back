# Ejemplos de JSON para API MongoDB - Sistema de Facturación

## 📋 FACTURAS DE PROVEEDORES

### 1. POST - Crear Factura Simple
**Endpoint:** `POST /api/mongo/facturas-proveedores`

```json
{
  "numeroFactura": "FAC-PROV-001",
  "fechaEmision": "2025-06-20T10:00:00.000Z",
  "proveedorId": "60d5ecb54f3b4c1234567890",
  "estadoDePago": "PENDIENTE",
  "urlPdf": "https://storage.example.com/facturas/fac-001.pdf",
  "total": 0.0,
  "productosRegistrados": false,
  "visible": true
}
```

**Respuesta:**
```json
{
  "id": "60d5ecb54f3b4c1234567891",
  "numeroFactura": "FAC-PROV-001",
  "fechaEmision": "2025-06-20T10:00:00.000Z",
  "fechaRegistro": "2025-06-20T15:30:00.000Z",
  "proveedorId": "60d5ecb54f3b4c1234567890",
  "estadoDePago": "PENDIENTE",
  "urlPdf": "https://storage.example.com/facturas/fac-001.pdf",
  "total": 0.0,
  "productosRegistrados": false,
  "visible": true,
  "detalleIds": null
}
```

### 2. POST - Crear Factura con Detalles (Transaccional)
**Endpoint:** `POST /api/mongo/facturas-proveedores/con-detalles`

```json
{
  "factura": {
    "numeroFactura": "FAC-PROV-002",
    "fechaEmision": "2025-06-20T10:00:00.000Z",
    "proveedorId": "60d5ecb54f3b4c1234567890",
    "estadoDePago": "PENDIENTE",
    "urlPdf": "https://storage.example.com/facturas/fac-002.pdf",
    "productosRegistrados": true,
    "visible": true
  },
  "detalles": [
    {
      "productoId": "60d5ecb54f3b4c1234567892",
      "cantidad": 10,
      "precio": 15.50
    },
    {
      "productoId": "60d5ecb54f3b4c1234567893",
      "cantidad": 5,
      "precio": 25.00
    },
    {
      "productoId": "60d5ecb54f3b4c1234567894",
      "cantidad": 2,
      "precio": 75.00
    }
  ]
}
```

**Respuesta:**
```json
{
  "id": "60d5ecb54f3b4c1234567895",
  "numeroFactura": "FAC-PROV-002",
  "fechaEmision": "2025-06-20T10:00:00.000Z",
  "fechaRegistro": "2025-06-20T15:35:00.000Z",
  "proveedorId": "60d5ecb54f3b4c1234567890",
  "estadoDePago": "PENDIENTE",
  "urlPdf": "https://storage.example.com/facturas/fac-002.pdf",
  "total": 430.0,
  "productosRegistrados": true,
  "visible": true,
  "detalleIds": [
    "60d5ecb54f3b4c1234567896",
    "60d5ecb54f3b4c1234567897",
    "60d5ecb54f3b4c1234567898"
  ]
}
```

### 3. GET - Obtener Todas las Facturas
**Endpoint:** `GET /api/mongo/facturas-proveedores`

**Respuesta:**
```json
[
  {
    "id": "60d5ecb54f3b4c1234567891",
    "numeroFactura": "FAC-PROV-001",
    "fechaEmision": "2025-06-20T10:00:00.000Z",
    "fechaRegistro": "2025-06-20T15:30:00.000Z",
    "proveedorId": "60d5ecb54f3b4c1234567890",
    "estadoDePago": "PENDIENTE",
    "urlPdf": "https://storage.example.com/facturas/fac-001.pdf",
    "total": 0.0,
    "productosRegistrados": false,
    "visible": true,
    "detalleIds": null
  },
  {
    "id": "60d5ecb54f3b4c1234567895",
    "numeroFactura": "FAC-PROV-002",
    "fechaEmision": "2025-06-20T10:00:00.000Z",
    "fechaRegistro": "2025-06-20T15:35:00.000Z",
    "proveedorId": "60d5ecb54f3b4c1234567890",
    "estadoDePago": "PENDIENTE",
    "urlPdf": "https://storage.example.com/facturas/fac-002.pdf",
    "total": 430.0,
    "productosRegistrados": true,
    "visible": true,
    "detalleIds": [
      "60d5ecb54f3b4c1234567896",
      "60d5ecb54f3b4c1234567897",
      "60d5ecb54f3b4c1234567898"
    ]
  }
]
```

### 4. GET - Obtener Factura por ID
**Endpoint:** `GET /api/mongo/facturas-proveedores/60d5ecb54f3b4c1234567895`

**Respuesta:**
```json
{
  "id": "60d5ecb54f3b4c1234567895",
  "numeroFactura": "FAC-PROV-002",
  "fechaEmision": "2025-06-20T10:00:00.000Z",
  "fechaRegistro": "2025-06-20T15:35:00.000Z",
  "proveedorId": "60d5ecb54f3b4c1234567890",
  "estadoDePago": "PENDIENTE",
  "urlPdf": "https://storage.example.com/facturas/fac-002.pdf",
  "total": 430.0,
  "productosRegistrados": true,
  "visible": true,
  "detalleIds": [
    "60d5ecb54f3b4c1234567896",
    "60d5ecb54f3b4c1234567897",
    "60d5ecb54f3b4c1234567898"
  ]
}
```

### 5. GET - Obtener Facturas por Proveedor
**Endpoint:** `GET /api/mongo/facturas-proveedores/proveedor/60d5ecb54f3b4c1234567890`

**Respuesta:** Array de facturas del proveedor especificado

### 6. GET - Obtener Facturas por Estado
**Endpoint:** `GET /api/mongo/facturas-proveedores/estado/PENDIENTE`

**Respuesta:** Array de facturas con estado "PENDIENTE"

### 7. GET - Obtener Detalles de una Factura
**Endpoint:** `GET /api/mongo/facturas-proveedores/60d5ecb54f3b4c1234567895/detalles`

**Respuesta:**
```json
[
  {
    "id": "60d5ecb54f3b4c1234567896",
    "facturaId": "60d5ecb54f3b4c1234567895",
    "productoId": "60d5ecb54f3b4c1234567892",
    "cantidad": 10,
    "precio": 15.50
  },
  {
    "id": "60d5ecb54f3b4c1234567897",
    "facturaId": "60d5ecb54f3b4c1234567895",
    "productoId": "60d5ecb54f3b4c1234567893",
    "cantidad": 5,
    "precio": 25.00
  },
  {
    "id": "60d5ecb54f3b4c1234567898",
    "facturaId": "60d5ecb54f3b4c1234567895",
    "productoId": "60d5ecb54f3b4c1234567894",
    "cantidad": 2,
    "precio": 75.00
  }
]
```

### 8. PUT - Actualizar Factura Completa
**Endpoint:** `PUT /api/mongo/facturas-proveedores/60d5ecb54f3b4c1234567895`

```json
{
  "numeroFactura": "FAC-PROV-002-MODIFICADA",
  "fechaEmision": "2025-06-20T10:00:00.000Z",
  "proveedorId": "60d5ecb54f3b4c1234567890",
  "estadoDePago": "PAGADA",
  "urlPdf": "https://storage.example.com/facturas/fac-002-updated.pdf",
  "total": 430.0,
  "productosRegistrados": true,
  "visible": true
}
```

**Respuesta:**
```json
{
  "id": "60d5ecb54f3b4c1234567895",
  "numeroFactura": "FAC-PROV-002-MODIFICADA",
  "fechaEmision": "2025-06-20T10:00:00.000Z",
  "fechaRegistro": "2025-06-20T15:35:00.000Z",
  "proveedorId": "60d5ecb54f3b4c1234567890",
  "estadoDePago": "PAGADA",
  "urlPdf": "https://storage.example.com/facturas/fac-002-updated.pdf",
  "total": 430.0,
  "productosRegistrados": true,
  "visible": true,
  "detalleIds": [
    "60d5ecb54f3b4c1234567896",
    "60d5ecb54f3b4c1234567897",
    "60d5ecb54f3b4c1234567898"
  ]
}
```

### 9. PUT - Actualizar Solo Estado de Pago
**Endpoint:** `PUT /api/mongo/facturas-proveedores/60d5ecb54f3b4c1234567895/estado-pago`

```json
{
  "estadoDePago": "PAGADA"
}
```

**Respuesta:** `200 OK` (sin contenido)

### 10. PUT - Marcar Productos como Registrados
**Endpoint:** `PUT /api/mongo/facturas-proveedores/60d5ecb54f3b4c1234567895/marcar-productos-registrados`

**Respuesta:** `200 OK` (sin contenido)

---

## 📦 DETALLES DE FACTURA DE PROVEEDOR

### 11. POST - Crear Detalle Individual
**Endpoint:** `POST /api/mongo/detalle-factura-proveedor`

```json
{
  "facturaId": "60d5ecb54f3b4c1234567895",
  "productoId": "60d5ecb54f3b4c1234567899",
  "cantidad": 3,
  "precio": 45.00
}
```

**Respuesta:**
```json
{
  "id": "60d5ecb54f3b4c12345678a0",
  "facturaId": "60d5ecb54f3b4c1234567895",
  "productoId": "60d5ecb54f3b4c1234567899",
  "cantidad": 3,
  "precio": 45.00
}
```

### 12. POST - Crear Múltiples Detalles
**Endpoint:** `POST /api/mongo/detalle-factura-proveedor/batch`

```json
[
  {
    "facturaId": "60d5ecb54f3b4c1234567895",
    "productoId": "60d5ecb54f3b4c12345678a1",
    "cantidad": 8,
    "precio": 12.50
  },
  {
    "facturaId": "60d5ecb54f3b4c1234567895",
    "productoId": "60d5ecb54f3b4c12345678a2",
    "cantidad": 4,
    "precio": 30.00
  }
]
```

### 13. GET - Obtener Total de una Factura
**Endpoint:** `GET /api/mongo/detalle-factura-proveedor/total/factura/60d5ecb54f3b4c1234567895`

**Respuesta:**
```json
430.0
```

---

## 🏢 PROVEEDORES

### 14. POST - Crear Proveedor
**Endpoint:** `POST /api/mongo/proveedores`

```json
{
  "nombreProveedor": "Distribuidora ABC S.A.",
  "rucProveedor": "1234567890001"
}
```

**Respuesta:**
```json
{
  "id": "60d5ecb54f3b4c1234567890",
  "nombreProveedor": "Distribuidora ABC S.A.",
  "rucProveedor": "1234567890001",
  "productosIds": null,
  "facturasIds": null
}
```

### 15. PUT - Actualizar Proveedor
**Endpoint:** `PUT /api/mongo/proveedores/60d5ecb54f3b4c1234567890`

```json
{
  "nombreProveedor": "Distribuidora ABC S.A.C.",
  "rucProveedor": "1234567890001"
}
```

---

## 📱 PRODUCTOS

### 16. POST - Crear Producto
**Endpoint:** `POST /api/mongo/productos`

```json
{
  "nombreProducto": "Resma de Papel A4",
  "cantidadDisponoble": 100.0,
  "disponibilidad": true,
  "fechaIngreso": "2025-06-20T10:00:00.000Z",
  "visible": true,
  "precio": 15.50,
  "categoriaId": "60d5ecb54f3b4c12345678b0",
  "proveedorId": "60d5ecb54f3b4c1234567890"
}
```

**Respuesta:**
```json
{
  "id": "60d5ecb54f3b4c1234567892",
  "nombreProducto": "Resma de Papel A4",
  "cantidadDisponoble": 100.0,
  "disponibilidad": true,
  "fechaIngreso": "2025-06-20T10:00:00.000Z",
  "visible": true,
  "precio": 15.50,
  "categoriaId": "60d5ecb54f3b4c12345678b0",
  "proveedorId": "60d5ecb54f3b4c1234567890"
}
```

### 17. PUT - Actualizar Producto
**Endpoint:** `PUT /api/mongo/productos/60d5ecb54f3b4c1234567892`

```json
{
  "nombreProducto": "Resma de Papel A4 Premium",
  "cantidadDisponoble": 85.0,
  "disponibilidad": true,
  "fechaIngreso": "2025-06-20T10:00:00.000Z",
  "visible": true,
  "precio": 17.00,
  "categoriaId": "60d5ecb54f3b4c12345678b0",
  "proveedorId": "60d5ecb54f3b4c1234567890"
}
```

---

## 🧾 FACTURAS DE CLIENTES

### 18. POST - Crear Factura de Cliente con Detalles
**Endpoint:** `POST /api/mongo/facturas-clientes/con-detalles`

```json
{
  "factura": {
    "fechaEmision": "2025-06-20T14:00:00.000Z",
    "usuarioId": "60d5ecb54f3b4c12345678c0"
  },
  "detalles": [
    {
      "productoId": "60d5ecb54f3b4c1234567892",
      "cantidad": 2,
      "precio": 15.50
    },
    {
      "productoId": "60d5ecb54f3b4c1234567893",
      "cantidad": 1,
      "precio": 25.00
    }
  ]
}
```

**Respuesta:**
```json
{
  "id": "60d5ecb54f3b4c12345678c1",
  "fechaEmision": "2025-06-20T14:00:00.000Z",
  "usuarioId": "60d5ecb54f3b4c12345678c0",
  "total": 56.0,
  "detalleIds": [
    "60d5ecb54f3b4c12345678c2",
    "60d5ecb54f3b4c12345678c3"
  ]
}
```

---

## 📝 ESTADOS DE PAGO VÁLIDOS

```json
[
  "PENDIENTE",
  "PAGADA",
  "VENCIDA",
  "CANCELADA",
  "EN_PROCESO"
]
```

## 🔍 CONSULTAS ESPECIALES

### Filtros disponibles para GET:
- `/proveedor/{id}` - Facturas por proveedor
- `/estado/{estado}` - Facturas por estado de pago
- `/visible/{true|false}` - Facturas visibles u ocultas
- `/factura/{facturaId}` - Detalles de una factura específica
- `/producto/{productoId}` - Detalles que incluyen un producto específico

## ⚠️ NOTAS IMPORTANTES

1. **IDs MongoDB**: Todos los IDs en MongoDB son strings de 24 caracteres hexadecimales
2. **Fechas**: Usar formato ISO 8601 (`YYYY-MM-DDTHH:mm:ss.sssZ`)
3. **Campos Obligatorios**: `numeroFactura`, `fechaEmision`, `proveedorId` para facturas
4. **Cálculos**: Los totales se calculan automáticamente al usar endpoints `/con-detalles`
5. **Referencias**: Todos los IDs de referencia deben existir en sus respectivas colecciones
