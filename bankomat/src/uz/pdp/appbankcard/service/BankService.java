package uz.pdp.appbankcard.service;


import uz.pdp.appbankcard.database.Database;
import uz.pdp.appbankcard.models.Bank;
import uz.pdp.appbankcard.utils.UsScanner;


public class BankService {

        public static String create() {

        if (Database.countOfBanks == Database.banks.length) {
            return "Bank list is full";
        }

        System.out.print("Enter bank name: ");
        String name = UsScanner.SCANNER_STR.nextLine().trim();

        if (name.isEmpty()) {
            return "Bank name is required";
        }

        for (int i = 0; i < Database.countOfBanks; i++) {
            if (Database.banks[i].getName().equalsIgnoreCase(name)) {
                return "This bank already exists";
            }
        }

        Bank bank = new Bank(Database.countOfBanks + 1, name);
        Database.banks[Database.countOfBanks] = bank;
        Database.countOfBanks++;

        return "New bank successfully cretaed.";
    }

    public static void read() {

        if (Database.countOfBanks == 0) {
            System.out.println("No banks");
            return;
        }
        for (int i = 0; i < Database.countOfBanks && !Database.banks[i].isDelete(); i++) {
            System.out.println(Database.banks[i]);
        }

    }

    public static String update() {

            System.out.print("Enter bank name: ");
        String name = UsScanner.SCANNER_STR.nextLine().trim();

        if (name.isEmpty()) {
            return "Bank name is required";
        }

        for (int i = 0; i < Database.countOfBanks; i++) {
            if (Database.banks[i].getName().equalsIgnoreCase(name)) {
                return "This bank already exists";
            }
        }

        Bank bank = new Bank(Database.countOfBanks + 1, name);
        Database.banks[Database.countOfBanks] = bank;
        Database.countOfBanks++;

        return "New bank successfully cretaed.";
    }

    public static String delete() {

        for (int i = 0; i < Database.banks.length; i++) {
            System.out.println(i+1+". "+Database.banks[i]);
        }

        int operationNumber;
        do{
            System.out.println("Enter deleted number");
            operationNumber = UsScanner.SCANNER_NUM.nextInt();
        }while (operationNumber<1 || operationNumber>Database.banks.length);

        Database.banks[operationNumber-1].setDelete(true);
        return "This bank successfully deleted";
    }
}
