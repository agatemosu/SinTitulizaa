package mercajoja.model;

import mercajoja.menus.CartMenu;
import mercajoja.products.Product;
import mercajoja.products.TextileProduct;

import java.util.Comparator;

/// Comparador de [Product] para [CartMenu].
public class CartProductComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        // ordenar por composición si ambos son textil
        if (p1 instanceof TextileProduct t1 && p2 instanceof TextileProduct t2) {
            return t1.getComposition().compareToIgnoreCase(t2.getComposition());
        }

        // mover el producto textil hacia arriba
        if (p1 instanceof TextileProduct) return -1;
        if (p2 instanceof TextileProduct) return 1;

        // ordenar por nombre si ninguno de los dos productos es textil
        return p1.getName().compareTo(p2.getName());
    }
}
