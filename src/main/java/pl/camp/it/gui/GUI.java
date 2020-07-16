package pl.camp.it.gui;

import pl.camp.it.services.CategoryServices;
import pl.camp.it.services.ProductServices;
import pl.camp.it.session.SessionFactory;

import java.util.Scanner;

public class GUI {

    private static final Scanner scanner = new Scanner(System.in);

    public static void showMainMenu() {
        System.out.println("--------------------");
        System.out.println("1. Dodaj produkt");
        System.out.println("2. Dodaj kategorię");
        System.out.println("3. Usuń kategorię");
        System.out.println("4. Exit");
        System.out.println("Podaj cyfrę: ");

        String choose = scanner.nextLine();

        switch (choose) {
            case "1":
                GUIMethods.addProducts();
                break;
            case "2":
                GUIMethods.addCategory();
                break;
            case "3":
                GUIMethods.deleteCategory();
                break;
            case "4":
                SessionFactory.sessionFactory.close();
                System.exit(0);
            default:
                System.out.println("Nieprawidłowy wybór");
                showMainMenu();
                break;
        }
    }
}
