package mercajoja.menus;

import mercajoja.model.Cart;
import mercajoja.products.Product;

import java.time.LocalDate;
import java.util.Map;

/**
 * Menú del cajero.
 */
public class CashierMenu {
    /**
     * Muestra el resumen de compra y vacía el carrito.
     */
    public static void goToCashier() {
        System.out.println("---------------------------");
        System.out.println("MERCAJOJA");
        System.out.println("---------------------------");
        System.out.println("Data: " + LocalDate.now());
        System.out.println("---------------------------");
        Cart.getCart()
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> printEntry(entry.getKey(), entry.getValue()));
        System.out.println("---------------------------");
        System.out.println("Total: " + Cart.calculateCartTotal());
        Cart.clearCart();
    }

    private static void printEntry(Product product, int quantity) {
        System.out.printf("%s - %s%n  %.2f * %d = %.2f%n", product.getBarcode(), product.getName(), product.getPrice(), quantity, product.getPrice() * quantity);
    }
}
