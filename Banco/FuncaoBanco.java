package org.example.Banco;
import org.example.Classes.*;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class FuncaoBanco {

    static Connection connection = null;

    public String path(int op) {
        String casa = "/home/keven/Documentos/Delivery/Aplicativo.db";
        String senai = "C:\\Users\\53688621808\\Documents\\Delivery\\Aplicativo.db";
        String bosch = "C:/Users/ct67ca/Documents/Delivery/Aplicativo.db";

        switch (op) {
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

    public ArrayList selecionar(int opcao, ArrayList<String> nomes, boolean t) throws SQLException {

        connection = DriverManager.getConnection("jdbc:sqlite:" + path(3));

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
            default:
                break;
        }
        sqlFormatado = String.format("select * from %s ", sql);
        ResultSet respostaDB = statement.executeQuery(sqlFormatado);

        while (respostaDB.next()) {

            if (sql.equals("Lanche")) {
                if (t == false) {
                    nomes.add(respostaDB.getString("preço"));
                    continue;

                } else
                    nomes.add(respostaDB.getString("nome"));
                continue;

            }

            if (sql.equals("Cadastra_Usuario")) {

                if (t == false) {
                    nomes.add(respostaDB.getString("senha"));
                    continue;
                } else
                    nomes.add(respostaDB.getString("cpf"));
                continue;

            }
            if (sql.equals("Cadastro_restaurante")) {

                if (t == true) {
                    nomes.add(respostaDB.getString("nome_restaurante"));
                    continue;
                } else
                    nomes.add(respostaDB.getString("cnpj"));

                continue;

            }

            return nomes;
        }
        connection.close();
        return nomes;
    }

    public int quantidadeRow(String tabela) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:" + path(3));

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sqlFormatado = String.format("select count(*) AS results from %s", tabela);
        ResultSet respostaDB = statement.executeQuery(sqlFormatado);

        int row = respostaDB.getInt("results");
        connection.close();
        return row;
    }

    public String selecionarPorNome(int id, String nome_id, String tabela) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:" + path(3));
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = String.format("select * from %s where %s = %s", tabela, nome_id, id);
        ResultSet respostaDB = statement.executeQuery(sql);
        String nome;
        if(tabela.equals("Lanche")){
            nome = respostaDB.getString("nome_lanche");
        }else{
            nome = respostaDB.getString("nome");
        }
      
        connection.close();
        return nome;
    }

    public ArrayList selecionarFk(int opcao, ArrayList<String> escolha, int fk) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:" + path(3));
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = "";

        switch (opcao) {
            case 1:
                sql = "Lanche where fk_restaurante = " + fk;
                break;
            case 2:
                sql = "Endereco where fk_usuario = " + fk;
                break;
            case 3:
                sql = "Endereco where fk_restaurante = " + fk;
                break;
            default:
                break;
        }

        String sqlFormatado = String.format("select * from %s", sql);
        ResultSet respostaDB = statement.executeQuery(sqlFormatado);
        int i = 0;
        while (respostaDB.next()) {
            escolha.add(respostaDB.getString("nome_lanche"));
            i++;
            continue;
        }

        connection.close();

        return escolha;
    }

    public int selecionarPorId(int opcao, String nome) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:" + path(3));
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
                sql = String.format("select id_lanche from Lanche where nome_lanche = '%s'", nome);
                id_escolhido = "id_lanche";
                break;
            case 4:
                sql = String.format("select nome from Lanche where fk_restaurante = %s", Integer.parseInt(nome));
                id_escolhido = "id_lanche";
                break;
            case 5:
                sql = String.format("select id_restaurante from Cadastro_restaurante where nome_restaurante ='%s' ",
                        nome);
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
    public void adicionaRestaurante(Restaurante restaurante) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:" + path(3));
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = String.format("INSERT INTO Cadastro_restaurante VALUES (null, '%s', '%s', '%s')", restaurante.getNome(),
                restaurante.getSenha(), restaurante.getCnpj());
        statement.executeUpdate(sql);
        connection.close();

    }
    public void adicionarUsuario(Usuarios usuario) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:" + path(3));
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = String.format("INSERT INTO Cadastra_Usuario VALUES (null, '%s', '%s','%s')", usuario.getNome(),
                usuario.getSenha(), usuario.getCPF());
        statement.executeUpdate(sql);
        connection.close();

    }
    public void endereco(Endereco endereco) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:" + path(3));
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        System.out.println(endereco.getFkR());

        String sql = String.format("INSERT INTO Endereco VALUES (null, %s, %s, %s, %s)", endereco.getEixoX(), endereco.getEixoY(),
                endereco.getFkU(), endereco.getFkR());

        statement.executeUpdate(sql);
        connection.close();
    }
    public void adicionarlanche(Lanche lanche) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:" + path(3));
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = String.format("INSERT INTO Lanche VALUES (null, '%s', %s, %s)", lanche.getNome(), lanche.getPreco(),
                lanche.getFk_restaurante());
        statement.executeUpdate(sql);
        connection.close();
    }
    public void adicionarPedido(Pedidos pedido) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:" + path(3));
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = String.format("INSERT INTO Pedido VALUES (null, %s, %s, %s, %s)", pedido.getPrecoTotal(), pedido.getFkU(),
                pedido.getFkR(), pedido.getFkL());
        statement.executeUpdate(sql);
        connection.close();
    }

    public float selecionarPreco(int id) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:" + path(3));
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = String.format("select * from Lanche where id_lanche = %s", id);
        ResultSet respostaDB = statement.executeQuery(sql);
        String preco = respostaDB.getString("preço");
        float precoF = Float.parseFloat(preco);
        connection.close();
        return precoF;
    }

    public JTable demandaUsuario(JTable tabela, int id) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:" + path(3));
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = String.format("select  Cadastra_Usuario.nome, Lanche.nome_lanche, Pedido.preço_total from Pedido INNER JOIN  Cadastra_Usuario on id_usuario = Pedido.fk_usuario INNER JOIN Lanche on Lanche.id_lanche = Pedido.fk_lanche where %s = fk_usuario", id);
        ResultSet respostaDB = statement.executeQuery(sql);

        Object[] colunas = {"Nome", "Lanche", "Preço total"};

        Object[][] dados = new Object[quantidadeRow("Pedido")][quantidadeRow("Pedido")+1];



            for (int i = 0; i < quantidadeRow("Pedido") ; i++) {
                respostaDB.next();
                 dados[i][0] = respostaDB.getString("nome");
                 dados[i][1]=respostaDB.getString("nome_lanche");
                 dados[i][2] = respostaDB.getString("preço_total");

                }

        tabela = new JTable(dados, colunas);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.setForeground(Color.WHITE);
        tabela.setSize(650, 600);
        tabela.setBackground(Color.decode("#972A2A"));
        tabela.setLocation(0,400);

        connection.close();
        return tabela;
    }

    public void deletarPorId(int id) throws SQLException{
        connection = DriverManager.getConnection("jdbc:sqlite:" + path(3));
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        String sql = String.format("Delete from Lanche where id_lanche= %s", id);
        statement.executeUpdate(sql);
        String sqll = String.format("Delete from Pedido where fk_lanche= %s", id);
        statement.executeUpdate(sqll);
        connection.close();
    }

}
