
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FuncaoBanco {
    Connection connection = null;

    FuncaoBanco() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:/home/keven/Documentos/Delivery/Aplicativo.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);

        ResultSet rs = statement.executeQuery("select * from Cadastra_Usuario");
        while (rs.next()) {
            System.out.println("cpf = " + rs.getString("cpf"));
            System.out.println("id = " + rs.getInt("id_usuario"));
        }
    }
    public int getId(int n, String nome) throws SQLException{
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = "";
        String id_escolhido = "";

        switch (n) {
            case 1:
                sql = "select id_usuario from Cadastra_Usuario ";
                id_escolhido = "id_usuario";
                break;

            case 2:
                sql = "select id_restaurante from Cadastro_restaurante where nome_restaurante= "+nome;
                id_escolhido = "id_restaurante";

            case 3:
                sql = "select id_restaurante from Cadastro_restaurante ";
                id_escolhido = "id_restaurante";
            default:
                break;
        }
        ResultSet rs = statement.executeQuery(sql);

        int id = rs.getInt(id_escolhido);
        return id;

    }
    public void adicionar_restaurante( Restaurante r) throws SQLException{

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = String.format("INSERT INTO Cadastro_restaurante VALUES (null, '%s', '%s')", r.getNome(), r.getCnpj());
        statement.executeUpdate(sql);


    }
    public void adicionar_usuario( Usuarios u) throws SQLException{

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = String.format("INSERT INTO Cadastra_Usuario VALUES (null, '%s', '%s','%s')", u.getNome(), u.getSenha(), u.getCPF());
        statement.executeUpdate(sql);

    }
    public void endereco(Endereco e) throws SQLException{

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = String.format("INSERT INTO Endereco VALUES (null, %s, %s, %s, %s)", e.getEixoX(), e.getEixoY(), e.getFkU(), e.getFkR());
        statement.executeUpdate(sql);

    }
    public void lanche(Lanche l ) throws SQLException{

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = String.format("INSERT INTO Lanche VALUES (null, %s, %s, %s)", l.getNome(), l.getPreco(), l.getFk_restaurante());
        statement.executeUpdate(sql);
    }
    public void pedido(int fkU, float preco_total, int fkR) throws SQLException{

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = String.format("INSERT INTO Pedido VALUES (null, %s, %s, %s)", fkU, preco_total, fkR);
        statement.executeUpdate(sql);
    }

    
    public boolean Deletar(){

        return true;
    }



    public static void main(String[] args) throws SQLException {
        FuncaoBanco f = new FuncaoBanco();
        System.out.println( f.getId(1, "bOLO DA Ana"));

    }


}
