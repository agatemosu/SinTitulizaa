package mercajoja.menus;

import mercajoja.model.Cart;
import mercajoja.model.CartProductComparator;
import mercajoja.products.Product;

import java.util.ArrayList;
import java.util.Map;

/**
 * Menú del carrito.
 */
public class CartMenu {
    /**
     * Muestra los productos del carrito junto con la cantidad añadida de cada uno.
     */
    public static void showCart() {
        System.out.println("------------");
        System.out.println("-- Carret --");
        System.out.println("------------");

        var entries = new ArrayList<>(Cart.getCart().entrySet());

        var comparator = new CartProductComparator();
        entries.sort((e1, e2) -> comparator.compare(e1.getKey(), e2.getKey()));

        for (Map.Entry<Product, Integer> entry : entries) {
            printEntry(entry.getKey(), entry.getValue());
        }
    }

    private static void printEntry(Product product, int quantity) {
        System.out.printf("%s -> %s%n", product.getName(), quantity);
    }
}
