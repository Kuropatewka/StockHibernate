package pl.camp.it.gui;

import pl.camp.it.dao.CategoryDAO;
import pl.camp.it.model.Category;
import pl.camp.it.services.CategoryServices;
import pl.camp.it.services.ProductServices;

import java.util.Scanner;

public class GUIMethods {

    private static final Scanner scanner = new Scanner(System.in);

    public static void addProducts() {
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
        GUI.showMainMenu();
    }

    public static void addCategory() {
        System.out.println("Wpisz nazwę kategorii");
        String categoryName = scanner.nextLine();

        CategoryServices.generateAndSaveCategory(categoryName);
        System.out.println("Dodano kategorię do bazy");
        GUI.showMainMenu();
    }

    public static void deleteCategory() {
        System.out.println("Wpisz nazwę kategorii");
        String categoryName = scanner.nextLine();

        if (categoryName.equals("Brak kategorii")) {
            System.out.println("Nie można usunąć tej kategorii");
            deleteCategory();
        } else {

        }
    }
}
