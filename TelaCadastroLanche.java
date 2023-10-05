      

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

    Button btn = new Button();

    CheckBox restaurantes ;
    Lanche lanche;
    Label mensagem = new Label();
    Tela telaP = new Tela();
    Label background = new Label();
    FuncaoBanco db;

    TelaCadastroLanche() throws SQLException{


            mensagem.setSize(350, 100);
            mensagem.setLocation(300,420);

            String casa = "/home/keven/Documentos/Delivery/Images/TelaLanches.png";
            String senai = "C:/Users/53688621808/IdeaProjects/AplicativoTeste/src/main/java/org/example/Images/TelaLanches.png";
            String bosch = "C:\\Users\\ct67ca\\Documents\\AplicativoTeste\\src\\main\\java\\org\\example\\Images\\TelaLanches.png";
            background.setIcon(new ImageIcon(casa));
            background.setSize(650, 1000);
            background.setLocation(0, 0);

            nome.setLocation(199, 522);
            preco.setLocation(199, 622);
            restaurantes = new CheckBox(1);
            restaurantes.setLocation(199, 732);

            btn.addActionListener(new ActionListener(){
                public void actionPerformed( ActionEvent evt) {

                        try {
                            inserindoLanche(restaurantes.getId());
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        System.out.println(getNome());
                    }
            });

            btn.setSize(270, 50);
            btn.setLocation(199,808);

            telaP.add(nome);
            telaP.add(mensagem);
            telaP.add(restaurantes);
            telaP.add(preco);
            telaP.add(btn);
            telaP.add(background);
            telaP.setVisible(true);
        }
            public void inserindoLanche(int id) throws SQLException{
                db = new FuncaoBanco();

                if(verificaPreco()==true){

                    lanche = new Lanche(getNome(), getPreco(), id);
                    db.adicionarlanche(lanche);
                }

            }

            public boolean verificaPreco() throws SQLException{
            db = new FuncaoBanco();
                if(getPreco().substring(0,getPreco().length()-1).matches("[A-Z]*") || getPreco().substring(0,getPreco().length()-1).matches("[a-z]*") ){
                    return false;
                }
              return true;
            }

            public static void main(String[] args) throws SQLException {
                new TelaCadastroLanche();
            }
        }



