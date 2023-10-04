package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class TelaCadastroLanche {

    Input preco  = new Input();
    Input nome = new Input();

    public String getPreco() {
        return preco.getText();
    }

    public String getNome() {
        return nome.getText();
    }

    public String getSenha() {
        return senha.getSelectedText();
    }

    JPasswordField senha = new JPasswordField();
    Lanche lanche;
    Label mensagem = new Label();
    Tela telaP = new Tela();
    Panel panel = new Panel();

    Button btn = new Button();
    Label background = new Label();
    FuncaoBanco db;

    TelaCadastroLanche(){


            mensagem.setSize(350, 100);
            mensagem.setLocation(300,420);

            String casa = "/home/keven/Documentos/Delivery/Images/telaPrincipal.png";
            String senai = "C:/Users/53688621808/IdeaProjects/AplicativoTeste/src/main/java/org/example/Images/TelaLanches.png";
            background.setIcon(new ImageIcon(senai));
            background.setSize(650, 1000);
            background.setLocation(0, 0);

            nome.setLocation(199, 522);
            preco.setLocation(199, 622);
            senha.setLocation(199, 732);
            senha.setSize(205, 50);
            btn.setSize(60, 50);
            btn.setLocation(417,730);
            btn.setText(">");

            btn.addActionListener(new ActionListener(){
                public void actionPerformed( ActionEvent evt) {
                        mensagem.setText("aaaaaaaa");

                        System.out.println("aaaaaaa");
                }
            });



            telaP.add(nome);
            telaP.add(mensagem);
            telaP.add(senha);
            telaP.add(preco);
            telaP.add(btn);
            telaP.add(background);
            telaP.setVisible(true);
        }
            public void inserindoLanche() throws SQLException{
                db = new FuncaoBanco();
                if (verificaSenha() == true){
                    lanche = new Lanche(getNome(), getPreco());
                    db.adicionarlanche(lanche);

                }
            }

            public boolean verificaSenha() throws SQLException{
            db = new FuncaoBanco();
            ArrayList<String> senha = new ArrayList<>();
            db.selecionar(2, senha, true);
            String[] senhas = new String[senha.size()];
            int i =0;
                for (String e:senha) {
                    System.out.println(e);
                    senhas[i] = e;
                    i++;
                    if(getSenha().length() < 8 && senhas[i].equals(getSenha() )){
                        mensagem.setText("O minimo da senha é 8 digitos");
                        return false;
                    }
                    else if(getSenha().length() > 8 && getSenha().length() < 60){
                        mensagem.setText("Deu certo");
                        return true;
                    }

                }
              return true;
            }

            public static void main(String[] args) throws SQLException {
                new TelaCadastroLanche();
            }
        }



