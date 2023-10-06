package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;
import java.util.ArrayList;

public class TelaPedido {

        JPasswordField senha = new JPasswordField();
        CheckBox restaurantes = new CheckBox(2);
        CheckBox lanches;
        boolean aberto;

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    CheckBox usuarios = new CheckBox(1);
        Pedidos pedido;

        
        public String getSenha() {
            return senha.getText();
        }

        FuncaoBanco db = new FuncaoBanco();;
        String selecionado;

        Tela telaP = new Tela();
        Panel panel = new Panel();
        Button btn = new Button();
        Button btnProximo = new Button();
        Label mensagem = new Label();
        ArrayList<String> cardapio = new ArrayList<String>();
        String [] cardapioRestauranteId = new String[db.quantidadeRow("Lanche")];


        TelaPedido() throws SQLException {


            usuarios.setOpaque(false);
            restaurantes.setOpaque(false);

            Label background = new Label();
            String casa = "/home/keven/Documentos/Delivery/Images/TelaPedido.png";
            String senai = "C:/Users/53688621808/IdeaProjects/AplicativoTeste/src/main/java/org/example/Images/TelaPedido.png";
            String bosch = "C:\\Users\\ct67ca\\Documents\\AplicativoTeste\\src\\main\\java\\org\\example\\Images\\TelaPedido.png";
            String bosch2 = "projects/logging/src/main/java/Images/TelaPedido.png";

            background.setIcon(new ImageIcon(senai));
            background.setSize(650, 1000);
            background.setLocation(0, 0);

            restaurantes.setLocation(199, 522);
          
            usuarios.setLocation(199, 620);
            senha.setLocation(199, 733);
            btn.setLocation(417,733);
            btn.setText("OK");

            btnProximo.setLocation(417,838);
            btnProximo.setText(">");
            btn.addActionListener(new ActionListener(){
                public void actionPerformed( ActionEvent evt) {
                        try {
                            if (verificaSenha()==true){
                                cardapioDoRestaurante();
                            }
                        } catch (SQLException e) {
                       
                            e.printStackTrace();
                        }
                }
            });
            btn.setSize(60, 50);
            btnProximo.setSize(60, 50);
            senha.setSize(203, 50);
            telaP.add(restaurantes);
            telaP.add(senha);
            telaP.add(usuarios);
            telaP.add(btn);
            telaP.add(btnProximo);
            panel.add(background);
            telaP.add(panel);
            telaP.add(mensagem);
            telaP.setVisible(true);
        }
    
        public String[] inserirPedido() throws SQLException{

                int fkU = db.getById(1, usuarios.getSelecionado());
                System.out.println(fkU);
                int fkR = db.getById(5, restaurantes.getSelecionado());
                System.out.println(restaurantes.getSelecionado());


                ArrayList<String> precos = new ArrayList<String>();
                db.selecionar(1, precos, false);
                String [] arrayToList = new String[precos.size()];
                Float [] precosFormatados = new Float[precos.size()];

                int i =0;
                for (String p : precos) {
                   System.out.println(p);
                   arrayToList[i] = p;
                   precosFormatados[i] = Float.valueOf(arrayToList[i]);
                }

                int fkL = db.getById(3, lanches.getClicado());

                String preco = Float.toString(precosFormatados[lanches.getId()* lanches.getQuantidade()]);
                pedido = new Pedidos(preco,fkU,fkL,fkR);
                db.adicionarPedido(pedido);



           return cardapioRestauranteId;
        }
        public boolean verificaSenha() throws SQLException{
            boolean verifica = false;
            ArrayList<String> senhas = new ArrayList<String>();

            db.selecionar(1, senhas, false);

            String [] senha = new String[senhas.size()];
            int i =0;
            for (String s : senhas) {
                senha[i] = s;
                System.out.println(s);
                if (getSenha().equals(senha[i])) {
                    verifica = true;
                    continue;
                }
                else if (!getSenha().equals(senha[i])){
                    verifica = false;
                    continue;
                }
                i++;
            }

            return verifica;
        }
        public void cardapioDoRestaurante() throws SQLException{

            int index =0;
            for (String c : cardapio) {
                System.out.println(c);
                this.cardapioRestauranteId[index] = c;
                index++;


            }
            lanches = new CheckBox(cardapioRestauranteId);
            lanches.setLocation(190, 834);
            lanches.setOpaque(false);
            telaP.add(lanches);
        }


        public static void main(String[] args) throws SQLException {
            new TelaPedido();
        }
    }
    
    


