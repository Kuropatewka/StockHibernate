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
        System.out.println("4. Dostępne produkty");
        System.out.println("5. Dostępne kategorie");
        System.out.println("6. Dostępne produkty z danej kategorii");
        System.out.println("7. Wyloguj");
        System.out.println("Podaj cyfrę: ");

        String choose = scanner.nextLine();

        switch (choose) {
            case "1":
                addProductScreen();
                break;
            case "2":
                addCategoryScreen();
                break;
            case "3":
                deleteCategoryScreen();
                break;
            case "4":
                System.out.println(iProductService.getAllProducts());
                showMainMenu();
                break;
            case "5":
                System.out.println(iCategoryService.getAllCategories());
                showMainMenu();
                break;
            case "6":
                productsFromCategoryScreen();
                break;
            case "7":
                LoginGUI.showLoginMainMenu();
            default:
                System.out.println("Nieprawidłowy wybór");
                showMainMenu();
                break;
        }
    }

    public static void addProductScreen() {
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
        if (iCategoryService.categoryExist(category)) {
            Category category2 = iCategoryService.getCategoryByName(category);
            iProductService.generateAndSaveProduct(name, amount, price, barcode, category2);
            System.out.println("Produkt dodany do istniejącej kategorii");
        } else if (iCategoryService.categoryExistWithDeleted(category)) {
            System.out.println("Taka kategoria już istniała, nie można dodać ponownie");
        } else {
            iProductService.generateAndSaveProductWithNewCategory(name, amount, price, barcode, category);
            System.out.println("Produkt dodany oraz utworzono nową kategorię");
        }

        GUI.showMainMenu();
    }

    public static void addCategoryScreen() {
        System.out.println("Wpisz nazwę kategorii");
        String name = scanner.nextLine();
        if (iCategoryService.categoryExist(name)) {
            System.out.println("Podana kategoria już istnieje");
        } else if (iCategoryService.categoryExistWithDeleted(name)) {
            System.out.println("Podana kategoria została usunięta, nie można dodać ponownie");
        } else {
            iCategoryService.generateAndSaveCategory(name);
            System.out.println("Kategoria została dodana");
        }

        GUI.showMainMenu();
    }

    public static void deleteCategoryScreen() {
        System.out.println("Wpisz nazwę kategorii");
        String category = scanner.nextLine();
        if (category.equals("Brak kategorii")) {
            System.out.println("Nie można usunąć tej kategorii");
            return;
        }
        if (iCategoryService.categoryExist(category)) {
            Category category2 = iCategoryService.getCategoryByName(category);
            Category brakKategorii = iCategoryService.getCategoryByName("Brak kategorii");
            iProductService.updateProductCategoryToBrakKategorii(iProductService.getProductsByCategory(category2), brakKategorii);
            iCategoryService.deleteCategory(category2);
            System.out.println("Kateogria usunięta a produkty przeniesione do: Brak kategorii");
        } else {
            System.out.println("Nie ma takiej kategorii");
        }

        GUI.showMainMenu();
    }

    public static void productsFromCategoryScreen() {
        System.out.println("Wpisz nazwę kategorii: ");
        String category = scanner.nextLine();
        if (iCategoryService.categoryExist(category)) {
            Category category2 = iCategoryService.getCategoryByName(category);
            System.out.println(iProductService.getProductsByCategory(category2));
        } else {
            System.out.println("Nie ma takiej kategorii");
        }

        GUI.showMainMenu();

    }
}
