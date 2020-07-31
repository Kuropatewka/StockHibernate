package pl.camp.it.services;

public interface IUserService {

    void generateAndSaveUser(String login, String hashedPassword);
    boolean checkUserExist(String login);
    boolean checkLoginAndPassword(String login, String password);
}
