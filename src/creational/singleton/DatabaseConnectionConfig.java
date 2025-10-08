package creational.singleton;

public class DatabaseConnectionConfig {

    private static DatabaseConnectionConfig config;


    public static DatabaseConnectionConfig getConfig() {
        if(config==null){
            config = new DatabaseConnectionConfig();
        }
        return config;
    }

    private DatabaseConnectionConfig() {
        System.out.println("New DB connection created...");
    }

    public void testConnection() {
        System.out.println("Connection is success!");
    }
}
