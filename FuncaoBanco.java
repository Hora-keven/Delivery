
package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FuncaoBanco {
    static Connection connection = null;
    public String path(int op){
        String casa = " /home/keven/Documentos/Delivery/Aplicativo.db";
        String senai = "C:\\Users\\53688621808\\Documents\\Delivery\\Aplicativo.db";
        switch (op){
            case 1:
                return senai;
            case 2:
                return casa;
            default:
                break;
        }
        return "";
    }
    public void selecionar(int opcao) throws SQLException {


        connection = DriverManager.getConnection("jdbc:sqlite:"+path(1));
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = "";

        switch (opcao) {
            case 1:
                sql = "Cadastra_Usuario";

                break;
            case 2:
                sql = "Cadastro_restaurante";

                break;
            case 3:
                sql = "Pedido";
                break;
            case 4:
                sql = "Lanche";
                break;
            case 5:
                sql = "Endereco";
                break;
            default:
                break;
        }
        String sqlFormatado = String.format("select * from %s", sql);
        ResultSet respostaDB = statement.executeQuery(sqlFormatado);

        while (respostaDB.next()) {
            if (sql.equals("Endereco")) {
                System.out.println(respostaDB.getInt("posicao_x"));
                System.out.println(respostaDB.getInt("posicao_y"));
                System.out.println(respostaDB.getInt("fk_usuario"));
                System.out.println(respostaDB.getInt("fk_restaurante"));

            } else if (sql.equals("Lanche")) {
                System.out.println(respostaDB.getInt("id_lanche"));
                System.out.println(respostaDB.getString("nome"));
                System.out.println(respostaDB.getString("preço"));

            } else if (sql.equals("Pedido")) {
                System.out.println(respostaDB.getInt("id_pedido"));
                System.out.println(respostaDB.getString("preço_total"));
                System.out.println(respostaDB.getInt("fk_usuario"));
                System.out.println(respostaDB.getInt("fk_restaurante"));
                System.out.println(respostaDB.getInt(" fk_lanche"));

            } else if (sql.equals("Cadastra_Usuario")) {
                System.out.println("id_usuario: " + respostaDB.getInt("id_usuario"));
                System.out.println("nome: " + respostaDB.getString("nome"));
            } else if (sql.equals("Cadastro_restaurante")) {
                System.out.println("-=-=-=-=-=-=Restaurantes-=-=-=-=-");
                System.out.println("Numero: " + respostaDB.getInt("id_restaurante"));
                System.out.println("nome restaurante:" + respostaDB.getString("nome_restaurante"));
            }

        }
    }

    public int getId(int opcao, String nome) throws SQLException {
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = "";
        String id_escolhido = "";

        switch (opcao) {
            case 1:
                sql = "select id_usuario from Cadastra_Usuario where cpf = " + nome;
                id_escolhido = "id_usuario";
                break;

            case 2:
                sql = "select id_restaurante from Cadastro_restaurante where nome_restaurante= " + nome;
                id_escolhido = "id_restaurante";

            case 3:
                sql = "select id_lacnhe from Lanche where nome = " + nome;
                id_escolhido = "id_lanche";
            default:
                break;
        }
        ResultSet respostaDB = statement.executeQuery(sql);

        int id = respostaDB.getInt(id_escolhido);
        return id;

    }

    public void adicionaRestaurante(Restaurante r) throws SQLException {

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = String.format("INSERT INTO Cadastro_restaurante VALUES (null, '%s', '%s')", r.getNome(),
                r.getCnpj());
        statement.executeUpdate(sql);

    }

    public void adicionarUsuario(Usuarios u) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:"+path(1));
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = String.format("INSERT INTO Cadastra_Usuario VALUES (null, '%s', '%s','%s')", u.getNome(),
                u.getSenha(), u.getCPF());
        statement.executeUpdate(sql);

    }

    public void endereco(Endereco e) throws SQLException {

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = String.format("INSERT INTO Endereco VALUES (null, %s, %s, %s, %s)", e.getEixoX(), e.getEixoY(),
                e.getFkU(), e.getFkR());
        statement.executeUpdate(sql);

    }

    public void lanche(Lanche l) throws SQLException {

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = String.format("INSERT INTO Lanche VALUES (null, %s, %s, %s)", l.getNome(), l.getPreco(),
                l.getFk_restaurante());
        statement.executeUpdate(sql);

    }

    public void pedido(int fkU, float preco_total, int fkR) throws SQLException {

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = String.format("INSERT INTO Pedido VALUES (null, %s, %s, %s)", fkU, preco_total, fkR);
        statement.executeUpdate(sql);

    }

    public boolean Deletar() {

        return true;
    }

    // public static void main(String[] args)throws SQLException {

    // FuncaoBanco db = new FuncaoBanco();
    // db.selecionar(1);
    // db.getId(1," Keven")
    // ;
    // }

}
