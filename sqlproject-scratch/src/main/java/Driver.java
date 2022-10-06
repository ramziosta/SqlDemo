import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Driver {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=flashcard";
        String username = "postgres";
        String password = "Ac1bd2ce3@212";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println(connection.toString());
            System.out.println(connection.getSchema());
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
            System.out.println(sqlException.getMessage());
        }
    }
}

