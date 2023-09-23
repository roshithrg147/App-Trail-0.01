package com.example.scorecard;
public class Transaction {
    private String date;
    private String merchant;
    private String amount;

    public Transaction(String date, String merchant, String amount) {
        this.date = date;
        this.merchant = merchant;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
