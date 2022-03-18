package uz.pdp.appbankcard.controller;

import uz.pdp.appbankcard.models.BankCard;
import uz.pdp.appbankcard.service.BankService;
import uz.pdp.appbankcard.service.TransActionServise;
import uz.pdp.appbankcard.service.UserService;
import uz.pdp.appbankcard.utils.UsScanner;

public class UserController {

    public static String login() {
        return UserService.login();
    }

    public static String register() {
        return UserService.register();
    }

    public static void adminPage() {
        int operation = 0;
        do {
            System.out.println("1. Bank CRUD");
            System.out.println("2. Card type CRUD");
            System.out.println("3. Show users list");
            System.out.println("4. GIVE ADMIN ROLE TO USER");
            System.out.println("5. SHOW TRANS ACTION HISTORY");
            System.out.println("0. Exit");

            System.out.print("Enter operation number: ");
            operation = UsScanner.SCANNER_NUM.nextInt();
            System.out.println();


            String response = "";
            switch (operation) {
                case 1:
                    response = BankController.main();
                    break;
                case 2:
                    response = CardTypeController.main();
                    break;
                case 3:
                    response = UserService.showUsers();
                    break;
                case 4:
                    response = UserService.giveAdminRoleToUser();
                    break;
                    case 5:
                    response = TransActionServise.showHistory();
                    break;
            }

            System.out.println(response);
            System.out.println("************************\n");

        } while (operation != 0);

    }

    public static void userPage() {
        int operation = 0;
        do {
            System.out.println("1. Bank card CRUD");
            System.out.println("2. CHANGED PASSWORD");
            System.out.println("0. Exit");

            System.out.print("Enter operation number: ");
            operation = UsScanner.SCANNER_NUM.nextInt();
            System.out.println();


            String response = "";
            switch (operation) {
                case 1:
                    response = BankCardController.main();
                    break;
                case 2: response = UserService.changePassword(); break;
            }

            System.out.println(response);
            System.out.println("************************\n");

        } while (operation != 0);

    }
}
