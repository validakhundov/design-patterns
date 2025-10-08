package creational.builder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        Account a1 = new Account();
        a1.setIban("123AZN456");
        a1.setAmount(100.0);
        a1.setCurrency("AZN");

        List<Card> cards = new ArrayList<>();
        Card c1 = new Card();
        c1.setCvv("123");
        c1.setPan("324243543654754");
        c1.setExpireDate("12/34");

        Card c2 = new Card();
        c1.setCvv("456");
        c1.setPan("3243245123542534");
        c1.setExpireDate("01/32");

        cards.add(c1);
        cards.add(c2);

        a1.setCards(cards);

        Account a2 = new Account();
        a1.setIban("123USD456");
        a1.setAmount(0.0);
        a1.setCurrency("USD");

        accounts.add(a1);
        accounts.add(a2);

        User user = new User(1, "Valid" ,"Akhundov","Baku",null,accounts);
        user.setId(1);
        user.setName("Valid");
        user.setSurname("Akhundov");
        user.setAddress("Baku");
        user.setEmail("valid@gmail.com");
        user.setAccounts(accounts);




        System.out.println(user);

        User user2= user.clone();

        System.out.println(user2);
    }
}
