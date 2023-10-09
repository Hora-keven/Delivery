// package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;
import java.util.ArrayList;

public class TelaPedido {

      
        CheckBox restaurantes = new CheckBox(2);
        CheckBox lanches;
   
        public String getCPF() {
            return CPF;
        }



        Pedidos pedido;

        FuncaoBanco db = new FuncaoBanco();;
        String selecionado;
        String CPF;

        Tela tela = new Tela();
        Panel panel = new Panel();
        Button btn = new Button();
        Button btnProximo = new Button();
        Label mensagem = new Label();
        ArrayList<String> cardapios = new ArrayList<String>();
        String [] cardapioRestauranteId = new String[20];


        TelaPedido(String cpf) throws SQLException {
            this.CPF = cpf;
            restaurantes.setOpaque(false);

            Label background = new Label();
            String casa = "/home/keven/Documentos/MavenAplicativo/demo/projects/logging/src/main/java/Images/telaedido.png";
            String senai = "C:/Users/53688621808/IdeaProjects/AplicativoTeste/src/main/java/org/example/Images/telaedido.png";
            String bosch = "C:\\Users\\ct67ca\\Documents\\AplicativoTeste\\src\\main\\java\\org\\example\\Images\\telaedido.png";
            String bosch2 = "projects/logging/src/main/java/Images/telaedido.png";

            background.setIcon(new ImageIcon(casa));
            background.setSize(650, 1000);
            background.setLocation(0, 0);
            restaurantes.setLocation(170, 522);
          
            btnProximo.setLocation(275,722);
            btn.setLocation(414,520);
            btnProximo.setText(">");
            btnProximo.setSize(120, 50);
            btn.setSize(60, 50);
            
            btn.addActionListener(new ActionListener(){
                public void actionPerformed( ActionEvent evt) {

                            try {
                             
                                cardapioDoRestaurante();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        
                   
                        }
                      
                
            });
                
            btnProximo.addActionListener(new ActionListener(){
                public void actionPerformed( ActionEvent evt) {
                                try {
                                    inserirPedido();
                                } catch (SQLException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                               
                        }
                      
                
            });
        

              
            tela.add(restaurantes);
     
            tela.add(btn);
            tela.add(btnProximo);
            panel.add(background);
            tela.add(panel);
            tela.add(mensagem);
            tela.setVisible(true);
        
        }
        public String[] inserirPedido() throws SQLException{

                int fkU = db.getById(1, getCPF());
               
                int fkR = db.getById(5, restaurantes.getSelecionado());
                System.out.println(restaurantes.getSelecionado());

                int fkL = db.getById(3, lanches.getClicado());
                float preco = db.selecionarPreco(lanches.getId());

                float precoTotal = preco*lanches.getQuantidade();
           
                pedido = new Pedidos(precoTotal,fkU,fkL,fkR);
                db.adicionarPedido(pedido);

           return cardapioRestauranteId;
        }
      
        public void cardapioDoRestaurante() throws SQLException{

            
            int fkR = db.getById(5, restaurantes.getSelecionado());
            db.selecionarFk(1, cardapios, fkR);
            int index =0;
            for (String c : cardapios) {
               
                this.cardapioRestauranteId[index] = c;
                index++;
            }

            lanches = new CheckBox(cardapioRestauranteId);
            lanches.setLocation(199, 620);
            lanches.setOpaque(false);
            tela.add(lanches);
            
            
        }
      


        public static void main(String[] args) throws SQLException {
            new TelaPedido("53688621808");
        }
    }
    
    


