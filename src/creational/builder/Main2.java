package creational.builder;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        User user = new UserBuilder()
                .name("")
                .id(1)
                .name("Valid")
                .surname("")
                .accounts(List.of(new AccountBuilder().iban("12321").build()))
                .build();

        System.out.println(user);
    }

}