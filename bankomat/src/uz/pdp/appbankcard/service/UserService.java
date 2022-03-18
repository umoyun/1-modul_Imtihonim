package uz.pdp.appbankcard.service;

import uz.pdp.appbankcard.Application;
import uz.pdp.appbankcard.controller.UserController;
import uz.pdp.appbankcard.database.Database;
import uz.pdp.appbankcard.models.User;
import uz.pdp.appbankcard.utils.UsScanner;

import java.util.regex.Pattern;

public class UserService {

    public static String register() {

        if (Database.countOfUsers == Database.users.length) {
            return "Users list is full";
        }

        System.out.println("Register window");

        System.out.print("Enter first name: ");
        String firstName = UsScanner.SCANNER_STR.nextLine().trim();

        System.out.print("Enter last name: ");
        String lastName = UsScanner.SCANNER_STR.nextLine().trim();

        System.out.print("Enter username: ");
        String username = UsScanner.SCANNER_STR.nextLine().trim();

        System.out.print("Enter password: ");
        String password = UsScanner.SCANNER_STR.nextLine().trim();

        System.out.print("Enter password again : ");
        String confirmPassword = UsScanner.SCANNER_STR.nextLine().trim();

        if (firstName.isEmpty()) {
            return "First name is required";
        }
        if (lastName.isEmpty()) {
            return "Last name is required";
        }
        if (username.isEmpty()) {
            return "Username is required";
        }
        if (Pattern.matches("^(?=.*[0-9])(?=.*[a-z]).{8,20}$",password)) {
            return "Password is required";
        }
        if (Pattern.matches("^(?=.*[0-9])(?=.*[a-z]).{8,20}$",confirmPassword)) {
            return "Confirm password is required";
        }

        for (int i = 0; i < Database.countOfUsers; i++) {
            if (Database.users[i].getUsername().equals(username)) {
                return "This username is already taken";
            }
        }

        if (!password.equals(confirmPassword)) {
            return "Passwords are no matches";
        }

        User user = new User(Database.countOfUsers + 1, firstName, lastName,
                username, password);
        Database.users[Database.countOfUsers] = user;
        Database.countOfUsers++;

        return "New user successfully registered";
    }

    public static String login() {

        System.out.println("Login window");

        System.out.print("Enter username: ");
        String username = UsScanner.SCANNER_STR.nextLine().trim();

        System.out.print("Enter password: ");
        String password = UsScanner.SCANNER_STR.nextLine().trim();

        for (int i = 0; i < Database.countOfUsers; i++) {
            User user = Database.users[i];
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                Application.currentUser = user;
                break;
            }
        }

        if (Application.currentUser == null) {
            return "Username or password is wrong";
        }

        if (Application.currentUser.isAdmin()) {
            UserController.adminPage();
        } else {
            UserController.userPage();
        }
        return null;
    }

    public static String showUsers() {
        if(Database.countOfUsers == 0){
            System.out.println("No users");
        }else{
            for (int i = 0; i < Database.countOfUsers; i++) {
                System.out.println(Database.users[i]);
            }
        }

        return null;
    }

    public static String giveAdminRoleToUser() {

        boolean hasUser = false;

        for (int i = 0; i < Database.countOfUsers; i++) {
            User user = Database.users[i];
            if(!user.isAdmin()){
                System.out.println(user);
                hasUser = true;
            }
        }

        if(!hasUser){
            return "No users";
        }

        System.out.print("Enter user id");
        int userId = UsScanner.SCANNER_NUM.nextInt();

        for (int i = 0; i < Database.countOfUsers; i++) {
            User user = Database.users[i];
            if(!user.isAdmin() && user.getId()==userId){
                user.setAdmin(true);
                return "Given admin role";
            }
        }
        return null;
    }

    public static String changePassword() {
        System.out.print("Enter new password : ");
        String repassword = UsScanner.SCANNER_STR.nextLine().trim();

        System.out.print("Enter new password again : ");
        String repassword1 = UsScanner.SCANNER_STR.nextLine().trim();


        if (repassword.isEmpty()) {
            return "This password empty!";

        }
        if (!repassword.equals(repassword1)) {
            return "The passwords you entered are not compatible!";

        }
        for (int i = 0; i < Database.countOfUsers; i++) {
            if (Database.users[i].getPassword().equals(repassword)) {
                return "This password already taken";

            }
        }
        Application.currentUser.setPassword(repassword);
        return "Your passwor has been successfully changed ";
    }
}
