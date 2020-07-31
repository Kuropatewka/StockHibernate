package pl.camp.it.services;

import org.apache.commons.codec.digest.DigestUtils;
import pl.camp.it.dao.IUserDAO;
import pl.camp.it.dao.UserDAO;
import pl.camp.it.model.User;

public class UserService implements IUserService {

    public static IUserDAO iUserDAO = new UserDAO();

    @Override
    public void generateAndSaveUser(String login, String hashedPassword) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(hashedPassword);

        iUserDAO.saveUserToDatabase(user);
    }

    @Override
    public boolean checkUserExist(String login) {
        for (User user : iUserDAO.getAllUserFromDatabase()) {
            if (user.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkLoginAndPassword(String login, String password) {
        for (User user : iUserDAO.getAllUserFromDatabase()) {
            if (user.getLogin().equals(login)) {
                String hashedPassword = DigestUtils.md5Hex(password);
                if(hashedPassword.equals(user.getPassword())) {
                    System.out.println("Zalogowano");
                    return true;
                } else {
                    System.out.println("Nie udało się zalogować");
                    return false;
                }
            }
        }
        System.out.println("Nie udało się zalogować");
        return false;
    }
}
