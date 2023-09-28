import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Banco {

    Banco() {

        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/ct67ca/Documents/Delivery/Aplicativo.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // set timeout to 30 sec.

            ResultSet rs = statement.executeQuery("select * from Cadastra_Usuario");
            while (rs.next()) {
                System.out.println("name = " + rs.getString("cpf"));
                System.out.println("id = " + rs.getInt("id_usuario"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
            
                System.err.println(e.getMessage());
            }
        }
    }

}
