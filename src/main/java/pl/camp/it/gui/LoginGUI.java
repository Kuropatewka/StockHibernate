package pl.camp.it.gui;

import org.apache.commons.codec.digest.DigestUtils;
import pl.camp.it.services.IUserService;
import pl.camp.it.services.UserService;
import pl.camp.it.session.SessionFactory;

import java.util.Scanner;

public class LoginGUI {

    private static final Scanner scanner = new Scanner(System.in);
    public static IUserService iUserService = new UserService();

    public static void showLoginMainMenu() {
        System.out.println("--------------------");
        System.out.println("1. Zaloguj");
        System.out.println("2. Zarejestruj");
        System.out.println("3. Exit");
        System.out.println("Podaj cyfrę: ");

        switch (scanner.nextLine()) {
            case "1":
                showLoginScreen();
                showLoginMainMenu();
                break;
            case "2":
                showRegisterMenuScreen();
                showLoginMainMenu();
                break;
            case "3":
                SessionFactory.sessionFactory.close();
                System.exit(0);
                break;
            default:
                System.out.println("Nieprawidłowy wybór");
                showLoginMainMenu();
                break;
        }

    }

    private static void showLoginScreen() {
        System.out.println("Podaj login: ");
        String login = scanner.nextLine();
        System.out.println("Podaj hasło: ");
        String password = scanner.nextLine();

        if (iUserService.checkLoginAndPassword(login, password)) {
            GUI.showMainMenu();
        }
    }

    private static void showRegisterMenuScreen() {
        System.out.println("Podaj login: ");
        String login = scanner.nextLine();

        if (iUserService.checkUserExist(login)) {
            System.out.println("Podany login jest zajęty, spróbuj jeszcze raz");
            showRegisterMenuScreen();
            return;
        }
        System.out.println("Podaj hasło: ");
        String password = scanner.nextLine();

        String hashedPassword = DigestUtils.md5Hex(password);
        iUserService.generateAndSaveUser(login, hashedPassword);
        System.out.println("Rejestracja zakończona");
    }

}
