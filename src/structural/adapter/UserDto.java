package structural.adapter;

public class UserDto {
    String username;
    String fullName;

    public UserDto(String username, String fullName) {
        this.username = username;
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
