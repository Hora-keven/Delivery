package org.example.Telas;
import org.example.Aplicativo;
import org.example.Banco.FuncaoBanco;
import org.example.Componentes.*;
import org.example.Componentes.Button;
import org.example.Componentes.Label;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class TelaLoginUsuario  extends Tela {
    ArrayList<String> senhacadastrada= new ArrayList<String>();
    ArrayList<String> loginUsuarioCadastrado = new ArrayList<String>();
    ArrayList<String> loginRestauranteCadastrado = new ArrayList<String>();

    Input login  = new Input();
    Senha senha = new Senha();
    Button btn = new Button();
    Button btnVoltar = new Button();
    Label mensagem = new Label();
    public String getLogin() {
        return login.getText();
    }
    public String getSenha() {
        return senha.getText();
    }

    Label background = new Label();
    public TelaLoginUsuario() throws SQLException{
        String bosch = "C:\\Users\\53688621808\\IdeaProjects\\AplicativoTeste\\src\\main\\java\\org\\example\\Images\\TelaLogin.png";

        background.setIcon(new ImageIcon(bosch));
        background.setSize(650, 1000);
        background.setLocation(0, 0);
        mensagem.setLocation(300, 200);

        btn.addActionListener(new ActionListener(){
            public void actionPerformed( ActionEvent evt) {
                        try {
                            if (verificaUsuario() == verificaSenha() && verificaUsuario()==true && verificaSenha()==true){

                            }
                            else if(verificaUsuario() == false){
                                mensagem.setText("Usuario errado!");
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
            }
        });

        btnVoltar.addActionListener(new ActionListener(){
            public void actionPerformed( ActionEvent evt) {
                new Aplicativo();
                dispose();
            }
        });


        login.setSize(270, 50);
        login.setLocation(190, 520);
        senha.setLocation(190, 590);
        btn.setSize(150, 50);
        btn.setLocation(254,665);

        btnVoltar.setSize(80, 50);
        btnVoltar.setText("<");
        btnVoltar.setBackground(Color.white);

        add(senha);
        add(btnVoltar);
        add(login);
        add(btn);
        add(mensagem);
        add(background);
        setVisible(true);
    }
    public boolean verificaUsuario() throws SQLException{
        if(getLogin().length()==11){
            FuncaoBanco db = new FuncaoBanco();
            db.selecionar(1, loginUsuarioCadastrado, true);

            for (String login : loginUsuarioCadastrado) {
               if(getLogin().equals(login));{
                new TelaPedido(getLogin());
                dispose();
                return true;
               }
            }
            return true;
        }if(getLogin().length()==18){
            FuncaoBanco db = new FuncaoBanco();
            db.selecionar(2, loginRestauranteCadastrado, false);

            int id = db.selecionarPorId(2, getLogin());
            for (String login : loginRestauranteCadastrado) {
               if(getLogin().equals(login));{
                new TelaCadastroLanche(id);
                dispose();
                return true;
               }
            }
            return true;
        }
        if(getLogin().length() < 11){
            return false;
        }
        else if(getLogin().length() > 11 && getLogin().length() < 17){
            return false;

        }else if(getLogin().length() > 18){
            return false;

        }else if(getLogin().length() < 18){

            return false;
        }

        return false;
    }
    public boolean verificaSenha() throws SQLException {
        if(getSenha().length() < 8){
            mensagem.setText("O minimo da senha é 8 digitos");
            return false;
        }
        else if(getSenha().length() > 8 && getSenha().length() < 60){
            mensagem.setText("Deu certo");
            FuncaoBanco db = new FuncaoBanco();
            db.selecionar(1, senhacadastrada, false);

            for (String senha : senhacadastrada) {
                if(getSenha().equals(senha));{
                    System.out.println("cadastrado");
                    return true;
                }
            }
            return true;
        }else
            return true;
    }

    public static void main(String[] args) throws SQLException {
        new TelaLoginUsuario();
    }
}

