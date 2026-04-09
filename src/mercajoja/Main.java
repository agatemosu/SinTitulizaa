package mercajoja;

import mercajoja.menus.CartMenu;
import mercajoja.menus.CashierMenu;
import mercajoja.menus.ProductMenu;

import java.util.Scanner;

/// Clase principal de la aplicación.
public class Main {
    /// Scanner global para leer la entrada del usuario desde consola.
    public static final Scanner sc = new Scanner(System.in);

    /// Método principal de la aplicación.
    ///
    /// @param args Argumentos de la línea de comandos.
    public static void main(String[] args) {
        while (true) {
            printMenu();
            var choice = sc.nextLine();

            switch (choice) {
                case "1" -> ProductMenu.addProduct();
                case "2" -> CashierMenu.goToCashier();
                case "3" -> CartMenu.showCart();
                case "Q", "q" -> {
                    return;
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("###########");
        System.out.println("## INICI ##");
        System.out.println("###########");
        System.out.println("1) Introduir producte");
        System.out.println("2) Passar per caixa");
        System.out.println("3) Mostrar carret de compra");
        System.out.println("Q) Acabar");
    }
}
