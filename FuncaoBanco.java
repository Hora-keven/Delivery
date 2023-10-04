
package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FuncaoBanco {
    int tamanho;

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
    public ArrayList selecionar(int opcao, ArrayList<String> nomes, boolean t) throws SQLException {


        connection = DriverManager.getConnection("jdbc:sqlite:"+path(1));
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(0);
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

            }  if (sql.equals("Lanche")) {
                System.out.println(respostaDB.getInt("id_lanche"));
                System.out.println(respostaDB.getString("nome"));
                System.out.println(respostaDB.getString("preço"));
                nomes.add(respostaDB.getString("nome"));
                continue;


            }  if (sql.equals("Pedido")) {
                System.out.println(respostaDB.getInt("id_pedido"));
                System.out.println(respostaDB.getString("preço_total"));
                System.out.println(respostaDB.getInt("fk_usuario"));
                System.out.println(respostaDB.getInt("fk_restaurante"));
                System.out.println(respostaDB.getInt(" fk_lanche"));


            }  if (sql.equals("Cadastra_Usuario")) {
                System.out.println("id_usuario: " + respostaDB.getInt("id_usuario"));
                System.out.println("nome: " + respostaDB.getString("nome"));
                if(t == true){
                    nomes.add( respostaDB.getString("senha"));
                }else nomes.add( respostaDB.getString("cpf"));

                continue;

            }  if (sql.equals("Cadastro_restaurante")) {
                System.out.println("-=-=-=-=-=-=Restaurantes-=-=-=-=-");
                System.out.println("Numero: " + respostaDB.getInt("id_restaurante"));
                System.out.println("nome restaurante:" + respostaDB.getString("nome_restaurante"));
                nomes.add(respostaDB.getString("nome_restaurante"));
                continue;

            }
            return nomes;
        }
        return nomes;
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
                sql = "select id_restaurante from Cadastro_restaurante where cnpj = " + nome;
                id_escolhido = "id_restaurante";
                break;

            case 3:
                sql = "select id_lanche from Lanche where nome = " + nome;
                id_escolhido = "id_lanche";

            default:
                break;
        }
        ResultSet respostaDB = statement.executeQuery(sql);

        int id = respostaDB.getInt(id_escolhido);
        return id;

    }

    public void adicionaRestaurante(Restaurante r) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:"+path(1));
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = String.format("INSERT INTO Cadastro_restaurante VALUES (null, '%s', '%s', '%s')", r.getNome(),
                r.getSenha(), r.getCnpj());
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
        System.out.println(e.getFkR());

        String sql = String.format("INSERT INTO Endereco VALUES (null, %s, %s, %s, %s)", e.getEixoX(), e.getEixoY(),
                e.getFkU(), e.getFkR());

        statement.executeUpdate(sql);

    }

    public void adicionarlanche(Lanche l) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:"+path(1));
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = String.format("INSERT INTO Lanche VALUES (null, %s, %s, %s)", l.getNome(), l.getPreco(),
                l.getFk_restaurante());
        statement.executeUpdate(sql);

    }

    public void adicionarPedido(int fkU, float preco_total, int fkR) throws SQLException {

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
