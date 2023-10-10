// package org.example;
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
        String casa = "/home/keven/Documentos/Delivery/Aplicativo.db";
        String senai = "C:\\Users\\53688621808\\Documents\\Delivery\\Aplicativo.db";
        String bosch = "C:/Users/ct67ca/Documents/Delivery/Aplicativo.db";

        switch (op){
            case 1:
                return senai;
            case 2:
                return casa;
            case 3:
                return bosch;
            default:
                break;
        }

        return "";
    }
    public int quantidadeRow(String tabela) throws SQLException{
        connection = DriverManager.getConnection("jdbc:sqlite:"+path(2));

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sqlFormatado = String.format("select count(*) AS results from %s", tabela);
        ResultSet respostaDB = statement.executeQuery(sqlFormatado);

        int row = respostaDB.getInt("results");
        connection.close();
        return row;
    }
    public ArrayList selecionar(int opcao, ArrayList<String> nomes, boolean t) throws SQLException {


        connection = DriverManager.getConnection("jdbc:sqlite:"+path(2));
  
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = "";
        String sqlFormatado = "";

        switch (opcao) {
            case 1:
                sql = "Cadastra_Usuario";

                break;
            case 2:
                sql = "Cadastro_restaurante";

                break;
            case 3:
                sql = "Lanche";
                break;
            case 4:
                sql = "Endereco";

                break;
            case 5:
                sql = "Endereco";
                break;

            default:
                break;
        }
        sqlFormatado = String.format("select * from %s ", sql);
        ResultSet respostaDB = statement.executeQuery(sqlFormatado);



        while (respostaDB.next()) {
            if (sql.equals("Endereco")) {
                // System.out.println(respostaDB.getInt("posicao_x"));
                // System.out.println(respostaDB.getInt("posicao_y"));
                // System.out.println(respostaDB.getInt("fk_usuario"));
                // System.out.println(respostaDB.getInt("fk_restaurante"));

            }  if (sql.equals("Lanche")) {
                // System.out.println(respostaDB.getInt("id_lanche"));
                // System.out.println(respostaDB.getString("nome"));
                // System.out.println(respostaDB.getString("preço"));
                if(t == false){
                    nomes.add(respostaDB.getString("preço"));
                    continue;

                } else
                    nomes.add(respostaDB.getString("nome"));
                continue;


            }  if (sql.equals("Pedido")) {
                // System.out.println(respostaDB.getInt("id_pedido"));
                // System.out.println(respostaDB.getString("preço_total"));
                // System.out.println(respostaDB.getInt("fk_usuario"));
                // System.out.println(respostaDB.getInt("fk_restaurante"));
                // System.out.println(respostaDB.getInt(" fk_lanche"));


            }  if (sql.equals("Cadastra_Usuario")) {
             
                if(t == false){
                    nomes.add(respostaDB.getString("senha"));
                    continue;
                }
                else nomes.add(respostaDB.getString("cpf"));
                continue;

            }  if (sql.equals("Cadastro_restaurante")) {
                
                if(t == true){
                    nomes.add( respostaDB.getString("nome_restaurante"));
                    continue;
                }else nomes.add( respostaDB.getString("cnpj"));

                continue;

            }

            return nomes;
        }
        connection.close();
        return nomes;
    }
    public String selecionarPorNome(int id, String nome_id, String tabela) throws  SQLException{
        connection = DriverManager.getConnection("jdbc:sqlite:"+path(2));
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = String.format("select * from %s where %s = %s", tabela, nome_id, id);
        ResultSet respostaDB = statement.executeQuery(sql);
        String nome = respostaDB.getString("nome");
        connection.close();
        return nome;
    }
    public ArrayList selecionarFk(int opcao, ArrayList<String> escolha, int fk) throws  SQLException{
        connection = DriverManager.getConnection("jdbc:sqlite:"+path(2));
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = "";
      
        switch (opcao) {
            case 1:
                sql = "Lanche where fk_restaurante = "+fk ;
                break;
            case 2:
                sql = "Endereco where fk_usuario = "+fk;
                break;
            case 3:
                sql = "Endereco where fk_restaurante = "+fk;
                break;
            default:
                break;
        }

        String sqlFormatado = String.format("select * from %s", sql);
        ResultSet respostaDB = statement.executeQuery(sqlFormatado);
        int i = 0;
        while (respostaDB.next()){
            escolha.add(respostaDB.getString("nome"));
            i++;
            continue;
        }

        connection.close();

    return escolha;
    }
    public int selecionarPorId(int opcao, String nome) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:"+path(2));
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
                sql = String.format("select id_restaurante from Cadastro_restaurante where cnpj ='%s' ", nome);
                id_escolhido = "id_restaurante";
                break;

            case 3:
                sql = String.format("select id_lanche from Lanche where nome = '%s'", nome);
                id_escolhido = "id_lanche";
                break;
            case 4:
                sql = String.format("select nome from Lanche where fk_restaurante = %s", Integer.parseInt(nome));
                id_escolhido = "id_lanche";
                break;
            case 5:
                sql = String.format("select id_restaurante from Cadastro_restaurante where nome_restaurante ='%s' ", nome);
                id_escolhido = "id_restaurante";
                break;
      
            default:
                break;
        }
        ResultSet respostaDB = statement.executeQuery(sql);

        int id = respostaDB.getInt(id_escolhido);
        connection.close();
        return id;

    }
//    public String precoLanche(String nome) throws SQLException{
//        connection = DriverManager.getConnection("jdbc:sqlite:"+path(1));
//        Statement statement = connection.createStatement();
//        statement.setQueryTimeout(30);
//        String sql = String.format("select id_lanche from Lanche where nome = '%s'", nome);
//        String preco = "preço";
//        ResultSet respostaDB = statement.executeQuery(sql);
//
//        String precoCOnvertido = respostaDB.getString(preco);
//        System.out.println(precoCOnvertido);
//        return precoCOnvertido;
//    }

    public void adicionaRestaurante(Restaurante r) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:"+path(2));
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = String.format("INSERT INTO Cadastro_restaurante VALUES (null, '%s', '%s', '%s')", r.getNome(),
                r.getSenha(), r.getCnpj());
        statement.executeUpdate(sql);
        connection.close();

    }

    public void adicionarUsuario(Usuarios u) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:"+path(2));
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = String.format("INSERT INTO Cadastra_Usuario VALUES (null, '%s', '%s','%s')", u.getNome(),
                u.getSenha(), u.getCPF());
        statement.executeUpdate(sql);
        connection.close();


    }

    public void endereco(Endereco e) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:"+path(2));
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        System.out.println(e.getFkR());

        String sql = String.format("INSERT INTO Endereco VALUES (null, %s, %s, %s, %s)", e.getEixoX(), e.getEixoY(),
                e.getFkU(), e.getFkR());

        statement.executeUpdate(sql);
        connection.close();

    }

    public void adicionarlanche(Lanche l) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:"+path(2));
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = String.format("INSERT INTO Lanche VALUES (null, '%s', %s, %s)", l.getNome(), l.getPreco(), l.getFk_restaurante());
        statement.executeUpdate(sql);
        connection.close();

    }
    public void adicionarPedido(Pedidos p) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:"+path(2));
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = String.format("INSERT INTO Pedido VALUES (null, %s, %s, %s, %s)", p.getPrecoTotal(), p.getFkU(), p.getFkR(), p.getFkL());
        statement.executeUpdate(sql);
        connection.close();

    }
    public float selecionarPreco(int id) throws SQLException{
        connection = DriverManager.getConnection("jdbc:sqlite:"+path(2));
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = String.format("select * from Lanche where id_lanche = %s",id);
        ResultSet respostaDB = statement.executeQuery(sql);
        float nome = respostaDB.getInt("preço");
        connection.close();
        return nome;
    }

    public boolean Deletar() {

        return true;
    }

    public static void main(String[] args)throws SQLException {

    FuncaoBanco db = new FuncaoBanco();
        ArrayList<String> precos = new ArrayList<String>();
        db.selecionarFk(1, precos,2);
        for (int i = 0; i < precos.size(); i++) {
           System.out.println( precos.get(i));
        }
        db.selecionarPorId(2, "96.219.876/0001-00");

    ;
    }

}
