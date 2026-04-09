package mercajoja.products;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/// Representa un producto de alimentación.
public class FoodProduct extends Product {
    private final LocalDate expiryDate;


     /// Crea un nuevo producto de alimentación.
     ///
     /// @param name       El nombre del producto.
     /// @param price      El precio base del producto.
     /// @param barcode    El código de barras del producto.
     /// @param expiryDate La fecha de caducidad del producto.
    public FoodProduct(String name, double price, int barcode, LocalDate expiryDate) {
        super(name, price, barcode);
        this.expiryDate = expiryDate;
    }

    @Override
    public double getPrice() {
        long daysToExpiry = ChronoUnit.DAYS.between(LocalDate.now(), expiryDate);
        return price - price * (1.0 / (daysToExpiry + 1.0)) + price * 0.1;
    }
}
