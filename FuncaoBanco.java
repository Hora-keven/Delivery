
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FuncaoBanco {
    Connection connection = null;

    FuncaoBanco() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/ct67ca/Documents/Delivery/Aplicativo.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);

        ResultSet rs = statement.executeQuery("select * from Cadastra_Usuario");
        while (rs.next()) {
            System.out.println("cpf = " + rs.getString("cpf"));
            System.out.println("id = " + rs.getInt("id_usuario"));
        }
    }
    public void Adicionar_restaurante( String nome, String cnpj) throws SQLException{

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = String.format("INSERT INTO Cadastro_restaurante VALUES (null, '%s', '%s')", nome, cnpj);
        statement.executeUpdate(sql);


    }
    public void Adicionar_usuario( String nome, String senha, String cpf) throws SQLException{

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = String.format("INSERT INTO Cadastra_Usuario VALUES (null, '%s', '%s','%s')", nome, senha, cpf);
        statement.executeUpdate(sql);

    }
    public void Endereco( int x, int y, int fkU, int fkR) throws SQLException{

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = String.format("INSERT INTO Endereco VALUES (null, %s, %s, %s, %s)", x, y, fkU, fkR);
        statement.executeUpdate(sql);

    }
    public void Lanche(String nome, float preco, int fk) throws SQLException{

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = String.format("INSERT INTO Lanche VALUES (null, %s, %s, %s)", nome, preco, fk);
        statement.executeUpdate(sql);
    }
    public void Pedido(int fkU, float preco_total, int fkR) throws SQLException{

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = String.format("INSERT INTO Pedido VALUES (null, %s, %s, %s)", fkU, preco_total, fkR);
        statement.executeUpdate(sql);
    }

    
    public boolean Deletar(){

        return true;
    }



    public static void main(String[] args) throws SQLException {
//        FuncaoBanco f = new FuncaoBanco();
//        f.Adicionar_restaurante("bOLO DA Ana","55.266.143/0001-31");

    }


}
