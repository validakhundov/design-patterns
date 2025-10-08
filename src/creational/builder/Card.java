package creational.builder;

public class Card {
    String pan;
    String cvv;
    String expireDate;


    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return "Card{" +
                "pan='" + pan + '\'' +
                ", cvv='" + cvv + '\'' +
                ", expireDate='" + expireDate + '\'' +
                '}';
    }
}
