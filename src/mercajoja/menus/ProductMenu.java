package mercajoja.menus;

import mercajoja.Main;
import mercajoja.model.Cart;
import mercajoja.products.ElectronicProduct;
import mercajoja.products.FoodProduct;
import mercajoja.products.TextileProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/// Menú para añadir productos al carrito.
public class ProductMenu {
    /// Formulario para añadir un producto al carrito.
    public static void addProduct() {
        while (true) {
            System.out.println("--------------");
            System.out.println("-- PRODUCTE --");
            System.out.println("--------------");
            System.out.println("1) Alimentació");
            System.out.println("2) Tèxtil");
            System.out.println("3) Electronica");
            System.out.println("Q) Tornar");

            var choice = Main.sc.nextLine();

            if (choice.equals("Q") || choice.equals("q")) {
                break;
            }

            if (!choice.equals("1") && !choice.equals("2") && !choice.equals("3")) {
                System.out.println("Opció no vàlida.");
                continue;
            }

            try {
                System.out.print("Codi de barres: ");
                int barcode = Integer.parseUnsignedInt(Main.sc.nextLine());
                if (barcode == 0) {
                    System.out.println("Codi de barres invàlid.");
                    continue;
                }

                // buscar si el producto existe para ahorrar introducir todos sus datos de nuevo
                var existingProduct = Cart.searchProductByBarcode(barcode);
                if (existingProduct.isPresent()) {
                    Cart.addProduct(existingProduct.get());
                    continue;
                }

                System.out.print("Nom producte: ");
                var productName = Main.sc.nextLine();
                if (productName.isBlank()) {
                    System.out.println("Falta nom.");
                    continue;
                }

                System.out.print("Preu: ");
                double price = Double.parseDouble(Main.sc.nextLine());
                if (price < 0) {
                    System.out.println("Preu no pot ser negatiu.");
                    continue;
                }

                switch (choice) {
                    case "1" -> {
                        System.out.print("Data de caducitat (dd/mm/aaaa): ");
                        var dateStr = Main.sc.nextLine();

                        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        var expiryDate = LocalDate.parse(dateStr, formatter);

                        var p = new FoodProduct(productName, price, barcode, expiryDate);
                        Cart.addProduct(p);
                    }
                    case "2" -> {
                        System.out.print("Composició: ");
                        var composition = Main.sc.nextLine();
                        if (productName.isBlank()) {
                            System.out.println("Falta composició.");
                            continue;
                        }

                        var p = new TextileProduct(productName, price, barcode, composition);
                        Cart.addProduct(p);
                    }
                    case "3" -> {
                        System.out.print("Garantia (dies): ");
                        int warrantyDays = Integer.parseUnsignedInt(Main.sc.nextLine());

                        var p = new ElectronicProduct(productName, price, barcode, warrantyDays);
                        Cart.addProduct(p);
                    }
                }
            } catch (NumberFormatException ignored) {
                System.out.println("Format numèric incorrecte.");
            } catch (DateTimeParseException e) {
                System.out.println("Format de data incorrecte.");
            }
        }
    }
}
