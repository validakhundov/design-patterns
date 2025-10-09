package structural.adapter;

import creational.builder.User;

public class UserMapper {
    public static UserDto mapToDto(UserEntity userEntity) {
        return new UserDto(userEntity.username, userEntity.name + " " + userEntity.surname);
    }
}
