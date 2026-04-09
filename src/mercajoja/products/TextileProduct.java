package mercajoja.products;

/// Representa un producto textil.
public class TextileProduct extends Product {
    private final String composition;

    /// Crea un nuevo producto textil.
    ///
    /// @param name        El nombre del producto.
    /// @param price       El precio base del producto.
    /// @param barcode     El código de barras del producto.
    /// @param composition La composición del producto.
    public TextileProduct(String name, double price, int barcode, String composition) {
        super(name, price, barcode);
        this.composition = composition;
    }

    /// Obtiene la composición del producto.
    ///
    /// @return La composición del producto.
    public String getComposition() {
        return composition;
    }
}
