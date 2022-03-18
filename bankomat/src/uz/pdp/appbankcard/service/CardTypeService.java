package uz.pdp.appbankcard.service;

import uz.pdp.appbankcard.Application;
import uz.pdp.appbankcard.database.Database;
import uz.pdp.appbankcard.models.CardType;
import uz.pdp.appbankcard.utils.UsScanner;

import javax.xml.crypto.Data;
import java.util.*;
import java.util.regex.Pattern;

public class CardTypeService {

    public static String create() {

        if (Database.countOfCardTypes == Database.cardTypes.length) {
            return "Card type list is full";
        }

        System.out.print("Enter card type name: ");
        String name = UsScanner.SCANNER_STR.nextLine().trim();

        System.out.print("Enter card type prefix 4 digits: ");
        String prefix4 = UsScanner.SCANNER_STR.nextLine().trim();

        if (name.isEmpty()) {
            return "Name card type is required";
        }

        for (int i = 0; i < Database.countOfCardTypes; i++) {
            if (Database.cardTypes[i].getName().equalsIgnoreCase(name)) {
                return "This type card already exists";
            }
        }

        if (!Pattern.matches("[0-9]{4}", prefix4)) {
            return "Prefix must be only 4 digits";
        }

        for (int i = 0; i < Database.countOfCardTypes; i++) {
            if (Database.cardTypes[i].getPrefix4().equalsIgnoreCase(prefix4)) {
                return "This prefix is exists in " + Database.cardTypes[i].getName();
            }
        }

        CardType cardType = new CardType(Database.countOfCardTypes + 1, name.toUpperCase(), prefix4);

        Database.cardTypes[Database.countOfCardTypes] = cardType;
        Database.countOfCardTypes++;

        return "New card type successfully created.";
    }

    public static void read() {

        if (Database.countOfCardTypes == 0) {
            System.out.println("No cardTypes");
            return;
        }
        for (int i = 0; i < Database.countOfCardTypes && !Database.cardTypes[i].isDeleted(); i++) {
            System.out.println(Database.cardTypes[i]);
        }

    }

    public static String update() {

          read();

        System.out.print("Enter card type ID: ");
        String cartType = UsScanner.SCANNER_STR.nextLine().trim();

        System.out.print("Enter card type name: ");
        String name = UsScanner.SCANNER_STR.nextLine().trim();


        System.out.print("Enter card type prefix 4 digits: ");
        String prefix4 = UsScanner.SCANNER_STR.nextLine().trim();

        if (name.isEmpty()) {
            return "Name card type is required";
        }

        for (int i = 0; i < Database.countOfCardTypes; i++) {
            if (Database.cardTypes[i].setName(name)) {
                return "Name of Card type successfully updated.";
            }
        }

        if (cartType.isEmpty()) {
            return "Name card types ID is required";
        }

        for (int i = 0; i < Database.countOfCardTypes; i++) {
            if (Database.cardTypes[i].getName().equalsIgnoreCase(cartType)) {
                return "Card type successfully updated.";
            }
        }

        if (!Pattern.matches("[0-9]{4}", prefix4)) {
            return "Prefix must be only 4 digits";
        }

        for (int i = 0; i < Database.countOfCardTypes; i++) {
            if (Database.cardTypes[i].setPrefix4(prefix4)) {
                return "This prefix is exists in " + Database.cardTypes[i].getName();
            }
        }

        CardType cardType =new CardType(Database.countOfCardTypes + 1, name.toUpperCase(), prefix4);

        Database.cardTypes[Database.countOfCardTypes] = cardType;
        Database.countOfCardTypes++;

        return "Card type successfully updated.";

    }

    public static String delete() {
        for (int i = 0; i < Database.cardTypes.length; i++) {
            System.out.println(i + 1 + ". " + Database.cardTypes[i]);
        }

        int operationNumber;
        do {
            System.out.println("Enter deleted number");
            operationNumber = UsScanner.SCANNER_NUM.nextInt();
        } while (operationNumber < 1 || operationNumber > Database.cardTypes.length);

        Database.cardTypes[operationNumber - 1].setDeleted(true);
        return "This bank successfully deleted";
    }
}
