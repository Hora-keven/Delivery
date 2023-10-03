package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TelaPedido {




        Input confirmaSenha = new Input();
        CheckBox cnpj  = new CheckBox();
        CheckBox nomeRestaurante = new CheckBox();
        CheckBox senha = new CheckBox();
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
            background.setIcon(new ImageIcon(senai));
            background.setSize(650, 1000);
            background.setLocation(0, 0);

            nomeRestaurante.setLocation(199, 522);
            cnpj.setLocation(199, 620);
            senha.setLocation(199, 720);
            confirmaSenha.setLocation(190, 824);
            btn.setLocation(417,824);
            btn.setText(">");


            btn.addActionListener(new ActionListener(){
                public void actionPerformed( ActionEvent evt) {



                }
            });

            btn.setSize(60, 50);
            confirmaSenha.setSize(215, 50);
            panel.add(background);
            telaP.add(nomeRestaurante);
            telaP.add(mensagem);
            telaP.add(confirmaSenha);
            telaP.add(senha);
            telaP.add(cnpj);
            telaP.add(btn);
            telaP.add(panel);
            telaP.setVisible(true);
        }


        public static void main(String[] args) throws SQLException {
            new org.example.TelaPedido();
        }
    }


