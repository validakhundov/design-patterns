package creational.singleton;

public class Main {
    public static void main(String[] args) {
        DatabaseConnectionConfig dbConfig = DatabaseConnectionConfig.getConfig();

        dbConfig.testConnection();


        DatabaseConnectionConfig dbConfig2 = DatabaseConnectionConfig.getConfig();

        dbConfig2.testConnection();


        DatabaseConnectionConfig dbConfig3 =  DatabaseConnectionConfig.getConfig();

        dbConfig3.testConnection();


    }
}
