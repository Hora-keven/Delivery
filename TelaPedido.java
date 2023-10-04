package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TelaPedido {


        JPasswordField senha = new JPasswordField();
        CheckBox lanches  = new CheckBox(2);
        CheckBox nomeRestaurante = new CheckBox(1);
        CheckBox usuarios = new CheckBox(3);
        Restaurante restaurante;
        FuncaoBanco db;

        Tela telaP = new Tela();
        Panel panel = new Panel();
        Button btn = new Button();
        Label mensagem = new Label();


        TelaPedido() throws SQLException {
            Label background = new Label();
            String casa = "/home/keven/Documentos/Delivery/Images/telaPrincipal.png";
            String senai = "C:/Users/53688621808/IdeaProjects/AplicativoTeste/src/main/java/org/example/Images/TelaPedido.png";
            String bosch = "C:\\Users\\ct67ca\\Documents\\AplicativoTeste\\src\\main\\java\\org\\example\\Images\\TelaPedido.png";
            background.setIcon(new ImageIcon(bosch));
            background.setSize(650, 1000);
            background.setLocation(0, 0);

            nomeRestaurante.setLocation(199, 522);
            lanches.setLocation(199, 620);
            usuarios.setLocation(199, 720);
            senha.setLocation(190, 824);
            btn.setLocation(417,824);
            btn.setText(">");


            btn.addActionListener(new ActionListener(){
                public void actionPerformed( ActionEvent evt) {



                }
            });

            btn.setSize(60, 50);
            senha.setSize(215, 50);
            panel.add(background);
            telaP.add(nomeRestaurante);
            telaP.add(mensagem);
            telaP.add(senha);
            telaP.add(usuarios);
            telaP.add(lanches);
            telaP.add(btn);
            telaP.add(panel);
            telaP.setVisible(true);
        }


        public static void main(String[] args) throws SQLException {
            new org.example.TelaPedido();
        }
    }


