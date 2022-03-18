package uz.pdp.appbankcard.models;

public class BankCard {
    private User user;
    private Bank bank;
    private CardType cardType;
    private int id;
    private String number;
    private String pin;
    private UsDate expirationDate;
    private double balance;
    private boolean isDeleted;

    public BankCard(User user, Bank bank, CardType cardType, int id, String number, String pin, UsDate expirationDate, boolean isDeleted) {
        this.user = user;
        this.bank = bank;
        this.cardType = cardType;
        this.id = id;
        this.number = number;
        this.pin = pin;
        this.expirationDate = expirationDate;
        this.isDeleted = false;
    }

    public  User getString(){return user;}

    public void setUser(){this.user=user;}

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public UsDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(UsDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isDeleted(boolean isDeleted) {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "BankCard{" +
                ", user="+ user +
                ", bank=" + bank.getName() +
                ", cardType=" + cardType.getName() +
                ", id=" + id +
                ", number='" + number + '\'' +
                ", pin='" + pin + '\'' +
                ", expirationDate=" + expirationDate +
                ", balance=" + balance +
                ", isDeleted="+ isDeleted +
                '}';
    }
}
