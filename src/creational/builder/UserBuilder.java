package creational.builder;

import java.util.ArrayList;
import java.util.List;

public class UserBuilder {
    private int id = 0;
    private String name = "";
    private String surname = "";
    private String email = "";
    private String address = "";
    private List<Account> accounts=new ArrayList<>();


    public UserBuilder id(int id) {
        this.id = id;
        return this;
    }

    public UserBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder surname(String surname) {
        this.name = surname;
        return this;
    }

    public UserBuilder accounts(List<Account> accounts){
        this.accounts=accounts;
        return this;
    }


    public User build(){
        User u=new User(id, name,surname,email,null,null);

        return u;
    }

}
