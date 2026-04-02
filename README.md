# 🛒 Mercajoja

Aplicación de consola en Java que simula un sistema básico de gestión de compras en un supermercado. Permite añadir productos al carrito, visualizarlo y finalizar la compra pasando por caja.

---

## 📌 Funcionalidades

- Añadir productos de distintos tipos:
  - 🥦 Alimentación
  - 👕 Textil
  - 💻 Electrónica
- Visualizar el carrito de compra
- Calcular el total de la compra
- Simular el paso por caja (ticket)
- Gestión automática de cantidades
- Reglas específicas según tipo de producto

---

## ▶️ Uso

La aplicación se ejecuta desde consola. Al iniciarla, se presenta un menú interactivo donde el usuario puede navegar entre las diferentes opciones disponibles para gestionar la compra.

### 🧭 Flujo general

1. **Añadir productos al carrito**
   - Se selecciona el tipo de producto
   - Se introducen los datos requeridos según la categoría
   - El producto se añade al carrito o se actualiza su cantidad (según reglas de negocio)
2. **Consultar el carrito**
   - Permite visualizar todos los productos añadidos
   - Muestra cantidades y ordenación aplicada automáticamente
3. **Pasar por caja**
   - Genera el ticket de compra con el total calculado
   - Aplica las reglas específicas de cada tipo de producto
   - Vacía el carrito tras finalizar la compra
4. **Salir de la aplicación**
   - Finaliza la ejecución del programa de forma segura

---

## 🧠 Reglas de negocio

### 🥦 Productos de alimentación

- Precio ajustado según fecha de caducidad
- Cuanto más cerca de caducar, mayor descuento

### 👕 Productos textiles

- Solo se permite **una unidad por producto**

### 💻 Productos electrónicos

- Precio incrementado según días de garantía

---

## 🛠️ Detalles técnicos

- Uso de `HashMap<Product, Integer>` para el carrito (máximo 100 productos distintos)
- Identificación única de productos mediante `barcode`
- Aplicación funciona completamente por consola
- Implementación de:
  - `equals()` y `hashCode()` en `Product`
  - `Comparable<Product>` para orden natural
  - `Comparator` personalizado para el carrito
- Manejo de errores:
  - Formato numérico
  - Fechas inválidas
  - Validaciones de entrada

---

## 🔄 Ordenación del carrito

- Los productos textiles aparecen primero
- Textiles ordenados por composición
- Resto ordenado por nombre

---

## 📚 Documentación

Puedes consultar la documentación Javadoc del proyecto aquí:

👉 https://agatemosu.github.io/SinTitulizaa/
