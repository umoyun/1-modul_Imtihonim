package uz.pdp.appbankcard.database;

import uz.pdp.appbankcard.models.*;

import java.util.*;


public class Database {
    public static int countOfBanks = 0;
    public static int countOfCardTypes = 0;


    public static Bank[] banks = new Bank[10];
    public static CardType[] cardTypes = new CardType[10];
    public static BankCard[] bankCards = new BankCard[50];
    public static ArrayList<BankCard> bankCardArrayList = new ArrayList<>();
    public static List<CardType> cardTypeList = new ArrayList<>();



    public static User[] users = new User[50];
    public static int countOfUsers = 0;

    public static void complete(){

        // create super user
        User superAdmin = new User(1, "Ali", "Odilov",
                "admin001", "admin001", true);
        Database.users[countOfUsers] = superAdmin;
        countOfUsers++;

        User user = new User(2, "Doston", "Abdullayev",
                "user0001", "user0001", false);
        Database.users[countOfUsers] = user;
        countOfUsers++;

        // banks
        Bank bank = new Bank(Database.countOfBanks+1, "Agro bank");
        Database.banks[Database.countOfBanks] = bank;
        Database.countOfBanks++;

        Bank bank1 = new Bank(Database.countOfBanks+1, "Ipoteka bank");
        Database.banks[Database.countOfBanks] = bank1;
        Database.countOfBanks++;

        Bank bank2 = new Bank(Database.countOfBanks+1, "Anor bank");
        Database.banks[Database.countOfBanks] = bank2;
        Database.countOfBanks++;


        CardType cardType = new CardType(Database.countOfCardTypes+1,"UZCARD", "8600");
        Database.cardTypes[Database.countOfCardTypes] = cardType;
        Database.countOfCardTypes++;

        CardType cardType2 = new CardType(Database.countOfCardTypes+1,"HUMO", "9860");
        Database.cardTypes[Database.countOfCardTypes] = cardType2;
        Database.countOfCardTypes++;

        cardTypeList.add(cardType);
        cardTypeList.add(cardType2);

    }
}
