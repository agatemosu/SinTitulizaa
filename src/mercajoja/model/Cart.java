package mercajoja.model;

import mercajoja.products.Product;
import mercajoja.products.TextileProduct;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/// Clase que gestiona el carrito.
public class Cart {
    private static final Map<Product, Integer> products = new HashMap<>();

    private Cart() {
    }

    /// Obtiene el carrito.
    ///
    /// @return El carrito.
    public static Map<Product, Integer> getProducts() {
        // hacer una copia del carrito para que no se pueda modificar desde fuera
        return new HashMap<>(products);
    }

    /// Añade un producto al carrito.
    ///
    /// @param product El producto a añadir.
    public static void addProduct(Product product) {
        if (products.size() >= 100) {
            return;
        }

        products.compute(product, (key, quantity) -> {
            // añadir el primer producto en el carrito
            if (quantity == null) {
                return 1;
            }

            // rechazar añadir más de un producto textil
            if (product instanceof TextileProduct) {
                return quantity;
            }

            // añadir un producto más
            return quantity + 1;
        });
    }

    /// Busca un producto en el carrito por su código de barras.
    ///
    /// @param barcode Código de barras del producto.
    /// @return El producto si se encuentra.
    public static Optional<Product> searchProductByBarcode(int barcode) {
        return products.keySet().stream().filter(product -> Objects.equals(product.getBarcode(), barcode)).findFirst();
    }

    /// Calcula el importe total del carrito.
    ///
    /// @return El importe total de todos los productos en el carrito.
    public static double calculateCartTotal() {
        return products.entrySet().stream().mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue()).sum();
    }

    /// Vacía el carrito.
    public static void clearCart() {
        products.clear();
    }
}
