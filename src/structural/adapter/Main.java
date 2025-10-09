package structural.adapter;

public class Main {
    public static void main(String[] args) {
        UserEntity userEntity = new UserEntity(1,
                "validakhundov",
                "Valid",
                "Akhundoc",
                "valid123");


        System.out.println(userEntity);



        //username
        //fullName

        System.out.println(UserMapper.mapToDto(userEntity));
    }
}
