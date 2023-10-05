 

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;
import java.util.ArrayList;

public class TelaPedido {


        JPasswordField senha = new JPasswordField();
        CheckBox lanches  = new CheckBox(2);
        CheckBox restaurantes = new CheckBox(1);
        CheckBox usuarios = new CheckBox(3);
        Pedidos pedido;

        public String getSenha() {
            return senha.getText();
        }

        Restaurante restaurante;
        FuncaoBanco db;

        Tela telaP = new Tela();
        Panel panel = new Panel();
        Button btn = new Button();
        Label mensagem = new Label();


        TelaPedido() throws SQLException {
            Label background = new Label();
            String casa = "/home/keven/Documentos/Delivery/Images/TelaPedido.png";
            String senai = "C:/Users/53688621808/IdeaProjects/AplicativoTeste/src/main/java/org/example/Images/TelaPedido.png";
            String bosch = "C:\\Users\\ct67ca\\Documents\\AplicativoTeste\\src\\main\\java\\org\\example\\Images\\TelaPedido.png";
            background.setIcon(new ImageIcon(casa));
            background.setSize(650, 1000);
            background.setLocation(0, 0);

            restaurantes.setLocation(199, 522);
            lanches.setLocation(199, 620);
            usuarios.setLocation(199, 720);
            senha.setLocation(190, 824);
            btn.setLocation(417,824);
            btn.setText(">");


            btn.addActionListener(new ActionListener(){
                public void actionPerformed( ActionEvent evt) {
                        try {
                            inserirPedido();
                        } catch (SQLException e) {
                       
                            e.printStackTrace();
                        }


                }
            });

            btn.setSize(60, 50);
            senha.setSize(215, 50);
            panel.add(background);
            telaP.add(restaurantes);
            telaP.add(mensagem);
            telaP.add(senha);
            telaP.add(usuarios);
            telaP.add(lanches);
            telaP.add(btn);
            telaP.add(panel);
            telaP.setVisible(true);
            
        }
    
        public void inserirPedido() throws SQLException{
            db = new FuncaoBanco();
            if(verificaSenha() == true){
                int fkU = db.getId(1, usuarios.getSelecionado());
                int fkR = db.getId(2, restaurantes.getSelecionado());
                int fkL = db.getId(3,lanches.getSelecionado());
         
    
                String preco = db.precoLanche(lanches.getSelecionado());
    
                pedido = new Pedidos(preco,fkU,fkL,fkR);
                db.adicionarPedido(pedido);
            }
           else mensagem.setText("Senha incorreta");
        }
        public boolean verificaSenha() throws SQLException{
            boolean verifica = true;
            ArrayList<String> senhas = new ArrayList<String>();
            db = new FuncaoBanco();
            db.selecionar(1, senhas, false);

            String [] senha = new String[senhas.size()];
            int i =0;
            for (String s : senhas) {
                System.out.println(s);
                senha[i]=s;
            
                if(!getSenha().equals(senha[i])){
                    mensagem.setText("DIgite a senha cadastrada");
                    verifica = false;
                    continue;
                   
            }
                else if(getSenha().equals(senha[i])){
                    verifica = true;
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
    
    


