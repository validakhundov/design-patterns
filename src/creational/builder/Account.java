package creational.builder;

import java.util.List;

public class Account {
    String iban;
    Double amount;
    String currency;

    List<Card> cards;

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "AccountService{" +
                "iban='" + iban + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", cards=" + cards +
                '}';
    }
}
