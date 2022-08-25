package models;

import repos.UserRepo;

import java.util.Scanner;

public class User {
    private int id;
    private String fullName;
    private String email;
    private String password;

    public User() {
    }

    public User(int id, String fullName, String email, String password) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User setParametrUserNoId(UserRepo userRepo) {
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Имя ? : ");
        user.setFullName(scanner.next());
        System.out.println();
        System.out.print("Email ? : ");
        user.setEmail(scanner.next());
        System.out.println();
        System.out.print("Password ? : ");
        user.setPassword(scanner.next());
        System.out.println();
        return user;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

