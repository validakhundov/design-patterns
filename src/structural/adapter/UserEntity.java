package structural.adapter;

public class UserEntity {
    Integer id;
    String username;
    String name;
    String surname;
    String password;


    public UserEntity(Integer id, String username, String name, String surname, String password) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
