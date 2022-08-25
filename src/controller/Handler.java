package controller;

import color.Color;
import models.User;
import repos.UserRepo;
import services.UserServices;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Handler {
    private final UserRepo userRepo;
    private final UserServices userServices;

    public Handler(Connection connection) {
        this.userRepo = new UserRepo(connection);
        this.userServices = new UserServices(this.userRepo);
    }

    public void showMenu() {
        boolean keyout = true;
        Scanner scanner = new Scanner(System.in);
        while (keyout) {
            System.out.println(Color.GREEN + "Выбирете номер и нажмите Enter:");
            System.out.println("1.Добавить пользователя 2.Показать всех пользователей 3.Редактировать пользователя c id 4.Удалить пользователя c id 5.Получить пользователя c id 6.выход(или другой)\"" + Color.DEFAULT);
            switch (scanner.next()) {
                case "1": {
                    System.out.println("Введите данные пользователя: ");
                    User user = new User().setParametrUserNoId(userRepo);
                    user.setId(userRepo.getAllUsers().size() + 1);//
                    userRepo.addUser(user);
                    break;
                }
                case "2": {
                    List<User> userList = userRepo.getAllUsers();
                    for (User us : userList) {
                        System.out.println(us);
                    }
                    break;
                }
                case "3": {
                    System.out.println("Введите данные : ");
                    System.out.println("Редактируемый пользователь ID ? : ");
                    int tmpId = scanner.nextInt();
                    User user = new User().setParametrUserNoId(userRepo);
                    user.setId(tmpId);
                    userRepo.updateUser(user);
                    break;
                }
                case "4": {
                    System.out.println("Введите данные : ");
                    System.out.println("Удалить пользователя ID ? : ");
                    int tmpId = scanner.nextInt();
                    userRepo.deleteUserById(tmpId);
                    break;
                }
                case "5": {
                    System.out.println("Введите данные : ");
                    System.out.println("Получить пользователя ID ? : ");
                    int tmpId = scanner.nextInt();
                    User user = userRepo.getUserById(tmpId);
                    System.out.println(user);
                    break;
                }
                default: {
                    keyout = false;
                }
            }
        }
        scanner.close();

    }
}
