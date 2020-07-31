package pl.camp.it.gui;

import pl.camp.it.model.Category;
import pl.camp.it.services.CategoryServices;
import pl.camp.it.services.ICategoryService;
import pl.camp.it.services.IProductService;
import pl.camp.it.services.ProductServices;
import pl.camp.it.session.SessionFactory;

import java.util.Scanner;

public class GUI {

    private static final Scanner scanner = new Scanner(System.in);
    public static ICategoryService iCategoryService = new CategoryServices();
    public static IProductService iProductService = new ProductServices();

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
                addProducts();
                break;
            case "2":
                addCategory();
                break;
            case "3":
                deleteCategory();
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

    public static void addProducts() {
        System.out.println("Wpisz nazwę produktu: ");
        String name = scanner.nextLine();
        System.out.println("Wpisz ilość produktu: ");
        String amount = scanner.nextLine();
        System.out.println("Wpisz cenę produktu: ");
        String price = scanner.nextLine();
        System.out.println("Wpisz kod kreskowy produktu: ");
        String barcode = scanner.nextLine();
        System.out.println("Wpisz nazwę kategorii: ");
        String category = scanner.nextLine();

        iProductService.generateAndSaveProduct(name, amount, price, barcode, category);
        System.out.println("Dodano produkt do bazy");
        GUI.showMainMenu();
    }

    public static void addCategory() {
        System.out.println("Wpisz nazwę kategorii");
        String categoryName = scanner.nextLine();

        iCategoryService.generateAndSaveCategory(categoryName);
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
