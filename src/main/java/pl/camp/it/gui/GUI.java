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
        System.out.println("3. Exit");
        System.out.println("Podaj cyfrę: ");

        String choose = scanner.nextLine();

        switch (choose) {
            case "1":
                System.out.println("Wpisz nazwę produktu");
                String name = scanner.nextLine();
                System.out.println("Wpisz ilość produktu");
                String amount = scanner.nextLine();
                System.out.println("Wpisz kod kreskowy produktu");
                String barcode = scanner.nextLine();
                System.out.println("Wpisz nazwę kategorii");
                String categoryName = scanner.nextLine();

                ProductServices.generateAndSaveProduct(name, amount, barcode, categoryName);
                System.out.println("Dodano produkt do bazy");
                break;
            case "2":
                System.out.println("Wpisz nazwę kategorii");
                String categoryName2 = scanner.nextLine();

                CategoryServices.generateAndSaveCategory(categoryName2);
                System.out.println("Dodano kategorię do bazy");
                break;
            case "3":
                SessionFactory.sessionFactory.close();
                System.exit(0);
            default:
                System.out.println("Nieprawidłowy wybór");
                showMainMenu();
                break;
        }
    }
}
