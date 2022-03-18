package uz.pdp.appbankcard.models;
// User : HP
// Time : 17:37
// Date : 06.02.2022
// Month : февраль
// Project Name : TransAction

import java.time.LocalDateTime;

public class TransAction {
    private int id;
    private User user;
    private Bank bank;
    private double salePrice;
    private Integer amount;
    private LocalDateTime dateTime;
    private String payType;

    public TransAction(User user, Bank bank, double salePrice, Integer amount,  String payType) {
        this.user = user;
        this.bank = bank;
        this.salePrice = salePrice;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
        this.payType = payType;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Bank getBank() {
        return bank;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getPayType() {
        return payType;
    }

    @Override
    public String toString() {
        return "TransAction{" +
                "id=" + id +
                ", user=" + user +
                ", bank=" + bank +
                ", salePrice=" + salePrice +
                ", amount=" + amount +
                ", dateTime=" + dateTime +
                ", payType='" + payType + '\'' +
                '}';
    }
}
