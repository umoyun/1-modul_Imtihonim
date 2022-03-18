package uz.pdp.appbankcard;


import uz.pdp.appbankcard.controller.UserController;
import uz.pdp.appbankcard.database.Database;
import uz.pdp.appbankcard.models.User;
import uz.pdp.appbankcard.utils.UsScanner;

public class Application {

    public static User currentUser = null;

    public static void main(String[] args) {

        Database.complete();

        System.out.println("\n ONLINE BANK SYSTEM \n");

        int operation = 0;
        do {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Exit");

            System.out.print("Enter operation number: ");
            operation = UsScanner.SCANNER_NUM.nextInt();
            System.out.println();


            String response ="";
            switch (operation) {
                case 1:  UserController.login();
                case 2 : UserController.register();
                default :System.out.println("Default operation ");
            };

            System.out.println(response);
            System.out.println("************************\n");

        }while (operation != 0);

        System.out.println("FINISHED");
    }
}
