// package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;
import java.util.ArrayList;

public class TelaPedido {

        JPasswordField senha = new JPasswordField();
        CheckBox restaurantes = new CheckBox(2);
     
       
        CheckBox usuarios = new CheckBox(1);
        Pedidos pedido;
       
        CheckBox lanches;
        
        public String getSenha() {
            return senha.getText();
        }

        FuncaoBanco db;
        String selecionado;

        Tela telaP = new Tela();
        Panel panel = new Panel();
        Button btn = new Button();
        Label mensagem = new Label();


        TelaPedido() throws SQLException {
         
            
            usuarios.setOpaque(false);
            restaurantes.setOpaque(false);

            Label background = new Label();
            String casa = "/home/keven/Documentos/Delivery/Images/TelaPedido.png";
            String senai = "C:/Users/53688621808/IdeaProjects/AplicativoTeste/src/main/java/org/example/Images/TelaPedido.png";
            String bosch = "C:\\Users\\ct67ca\\Documents\\AplicativoTeste\\src\\main\\java\\org\\example\\Images\\TelaPedido.png";
            String bosch2 = "projects/logging/src/main/java/Images/TelaPedido.png";

            background.setIcon(new ImageIcon(bosch2));
            background.setSize(650, 1000);
            background.setLocation(0, 0);

            restaurantes.setLocation(199, 522);
          
            usuarios.setLocation(199, 720);
            senha.setLocation(190, 824);
            btn.setLocation(417,824);
            btn.setText(">");


            btn.addActionListener(new ActionListener(){
                public void actionPerformed( ActionEvent evt) {
                        try {
                            inserirPedido();
                            ArrayList<String> cardapio = new ArrayList<String>();
                            db.selecionarFk(1, cardapio, 1);
                        
                            String [] cardapioRestauranteId = new String[cardapio.size()];
                        
                            int index =0;
                            for (String c : cardapio) {
                                cardapioRestauranteId[index] = c;
                                index++;
                            }

                            lanches = new CheckBox(cardapioRestauranteId);
                            lanches.setLocation(199, 620);
                            lanches.setOpaque(false);
                            telaP.add(lanches);
            
                            System.out.println(lanches.getClicado()+" aaaa");
                            
                            mensagem.setText("Clique no retangulo o lanche");
                        } catch (SQLException e) {
                       
                            e.printStackTrace();
                        }


                }
            });
            
            btn.setSize(60, 50);
            senha.setSize(215, 50);
          
            telaP.add(restaurantes);
            telaP.add(mensagem);
            telaP.add(senha);
            telaP.add(usuarios);
            telaP.add(btn);
            panel.add(background);
            telaP.add(panel);
          
            telaP.setVisible(true);
            
        }
    
        public void inserirPedido() throws SQLException{
            System.out.println(restaurantes.getSelecionado());
            db = new FuncaoBanco();
            if(verificaSenha()){
                int fkU = db.getId(1, usuarios.getSelecionado());
                int fkR = db.getId(2, restaurantes.getSelecionado());
              
                int fkL = 1;

                ArrayList<String> precos = new ArrayList<String>();
                db.selecionar(1, precos, false);

                String [] arrayToList = new String[precos.size()];
                Float [] precosFormatados = new Float[precos.size()];

                int i =0;
                for (String p : precos) {
                    System.out.println(p);
                    arrayToList[i] = p;

                    precosFormatados[i] = Float.valueOf(arrayToList[i]);
                    i++;
                    }

                String preco = Float.toString(1);

                pedido = new Pedidos(preco,fkU,fkL,fkR);
                db.adicionarPedido(pedido);
            }
           else mensagem.setText("Senha incorreta");
        }
        public boolean verificaSenha() throws SQLException{
            boolean verifica = false;
            ArrayList<String> senhas = new ArrayList<String>();
            db = new FuncaoBanco();
            db.selecionar(1, senhas, false);

            String [] senha = new String[senhas.size()];
            int i =0;
            for (String s : senhas) {
                senha[i]=s;
            
                if(!getSenha().equals(senha[i])){
                    mensagem.setText("DIgite a senha cadastrada");
                    verifica = true;
                    continue;
                   
            }
                else if(getSenha().equals(senha[i])){
                    verifica = false;
                    continue;
                }
            i++;
                
            }
          
            return verifica;
            }
         


        public static void main(String[] args) throws SQLException {
            new TelaPedido();
        }
    }
    
    


