package org.example.Telas;
import org.example.Aplicativo;
import org.example.Banco.FuncaoBanco;
import org.example.Componentes.*;

import org.example.Classes.*;
// 
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class TelaCadastroLanche extends Tela {

    Input preco = new Input();
    Input nome = new Input();

    public String getPreco() {
        return preco.getText();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome.getText();
    }

    Button btn = new Button();
    Button btnApagar = new Button();
    Lanche lanche;
    Label mensagem = new Label();
    Label background = new Label();
    FuncaoBanco db = new FuncaoBanco();;
    int id;

    TelaCadastroLanche(int id) throws SQLException {
        this.id = id;
        mensagem.setSize(350, 100);
        mensagem.setLocation(300, 420);

        String bosch = "C:\\Users\\ct67ca\\Documents\\AplicativoTeste\\src\\main\\java\\org\\example\\Images\\TelaLanche.png";

        background.setIcon(new ImageIcon(bosch));
        background.setSize(650, 1000);
        background.setLocation(0, 0);
        nome.setLocation(199, 522);
        preco.setLocation(199, 590);
        btnApagar.setText("Apagar");
        btn.setText("Ok");

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    inserindoLanche();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        btnApagar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               System.out.println("Apagando");
               try {
                new TelaApagar(getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            }
        });
        btn.setSize(150, 50);
        btn.setLocation(249, 673);
        btnApagar.setSize(150, 50);
        btnApagar.setLocation(480, 883);
       
        add(btnApagar);
        add(nome);
        add(mensagem);
        add(preco);
        add(btn);
        add(background);
        setVisible(true);
    }

    public void inserindoLanche() throws SQLException {
      
        if (verificaPreco() == true) {
            float preco = Float.parseFloat(getPreco());
            lanche = new Lanche(getNome(), preco, getId());
            db.adicionarlanche(lanche);
            dispose();
            new Aplicativo();
        }

    }

    public boolean verificaPreco() throws SQLException {
    
        if (getPreco().substring(0, getPreco().length() - 1).matches("[A-Z]*")
                || getPreco().substring(0, getPreco().length() - 1).matches("[a-z]*")) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws SQLException {
        new TelaCadastroLanche(0);
    }
}
