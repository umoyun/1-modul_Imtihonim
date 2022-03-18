package uz.pdp.appbankcard.controller;

import uz.pdp.appbankcard.service.BankService;
import uz.pdp.appbankcard.utils.UsScanner;

public class BankController {

    public static String main() {
        String response = "";
        int operation = 0;

        System.out.println("1. Create bank");
        System.out.println("2. Show banks");
        System.out.println("3. Update bank");
        System.out.println("4. Delete bank");
        System.out.println("0. Back");

        System.out.print("Enter operation number: ");
        operation = UsScanner.SCANNER_NUM.nextInt();

        switch (operation) {
            case 1:
                response = BankService.create();
                break;
            case 2:
                BankService.read();
                break;
            case 3:
                response = BankService.update();
                break;
            case 4:
                response = BankService.delete();
                break;
        }

        return response;
    }
}
