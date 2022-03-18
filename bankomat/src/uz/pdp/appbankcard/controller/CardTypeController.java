package uz.pdp.appbankcard.controller;

import uz.pdp.appbankcard.service.BankService;
import uz.pdp.appbankcard.service.CardTypeService;
import uz.pdp.appbankcard.utils.UsScanner;

public class CardTypeController {

    public static String main(){
        String response = "";
        int operation = 0;

        System.out.println("1. Create card type");
        System.out.println("2. Show card types");
        System.out.println("3. Update card type");
        System.out.println("4. Delete card type");
        System.out.println("0. Back");

        System.out.print("Enter operation number: ");
        operation = UsScanner.SCANNER_NUM.nextInt();

        switch (operation) {
            case 1:
                response = CardTypeService.create();
                break;
            case 2:
                CardTypeService.read();
                break;
            case 3:
                CardTypeService.update();
                break;
            case 4:
                response = CardTypeService.delete();
                break;
        }

        return response;
    }
}
