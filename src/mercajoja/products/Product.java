package mercajoja.products;

import java.util.Objects;

/// Representa un producto genérico.
/// Clase abstracta que proporciona atributos comunes a todos los productos.
public abstract class Product implements Comparable<Product> {
    /// El nombre del producto.
    protected final String name;
    /// El código de barras del producto.
    protected final int barcode;
    /// El precio base del producto.
    protected double price;

    /// Crea un nuevo producto con nombre, precio y código de barras especificados.
    ///
    /// @param name    El nombre del producto.
    /// @param price   El precio base del producto.
    /// @param barcode El código de barras del producto.
    public Product(String name, double price, int barcode) {
        this.name = name;
        this.price = price;
        this.barcode = barcode;
    }

    /// Obtiene el precio actual del producto.
    ///
    /// @return El precio actual del producto.
    public double getPrice() {
        return price;
    }

    /// Obtiene el nombre del producto.
    ///
    /// @return El nombre del producto.
    public String getName() {
        return name;
    }

    /// Obtiene el código de barras del producto.
    ///
    /// @return El código de barras del producto.
    public int getBarcode() {
        return barcode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Product product)) return false;
        return barcode == product.barcode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(barcode);
    }

    @Override
    public int compareTo(Product p) {
        return Integer.compare(barcode, p.barcode);
    }
}
