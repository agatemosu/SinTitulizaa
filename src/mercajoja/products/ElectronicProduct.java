package mercajoja.products;

/**
 * Representa un producto electrónico.
 */
public class ElectronicProduct extends Product {
    private final int warrantyDays;

    /**
     * Crea un nuevo producto electrónico.
     *
     * @param name         El nombre del producto.
     * @param price        El precio base del producto.
     * @param barcode      El código de barras del producto.
     * @param warrantyDays Los días de garantía del producto.
     */
    public ElectronicProduct(String name, double price, int barcode, int warrantyDays) {
        super(name, price, barcode);
        this.warrantyDays = warrantyDays;
    }

    @Override
    public double getPrice() {
        return price + price * warrantyDays / 365.0 * 0.1;
    }
}
