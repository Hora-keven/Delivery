// package org.example;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.sql.SQLException;

public class TelaCadastroEndereco {
    Input eixoX = new Input();
    Tela tela = new Tela();
    Panel panel = new Panel();
    Button btn = new Button();
    Label background = new Label();
    Input eixoY = new Input();
    FuncaoBanco db;
    Endereco endereco;
    String nome;
    int id;
    
    public String getNome(){
        return nome;
    }
    public String getEixoX() {
        return eixoX.getText();
    }
    public String getEixoY() {
        return eixoY.getText();
    }
    int opcao;

    public int getOpcao() {
        return opcao;
    }

    TelaCadastroEndereco(String nome, int opcao){
        String casa = "/home/keven/Documentos/MavenAplicativo/demo/projects/logging/src/main/java/Images/CadastroEndereco.png";
        String senai = "C:/Users/53688621808/IdeaProjects/AplicativoTeste/src/main/java/org/example/Images/CadastroEndereco.png";
        String bosch = "C:\\Users\\ct67ca\\Documents\\AplicativoTeste\\src\\main\\java\\org\\example\\Images\\CadastroEndereco.png";
        String bosch2 = "projects/logging/src/main/java/Images/CadastroEndereco.png";
        
        this.nome = nome;
        this.opcao = opcao;
      
        background.setIcon(new ImageIcon(casa));
        background.setSize(650, 1000);
        background.setLocation(0, 0);

        eixoX.setLocation(200, 520);
      
        eixoY.setLocation(200, 590);
      
        btn.setSize(130, 50);
        btn.setLocation(272, 667);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed( ActionEvent evt)  {
                
                try {
                    inserindoEndereco(getNome());
                    if(getNome().length() == 18){
                        new TelaCadastroLanche(id);
                    }
                    else new TelaPedido(getNome());
                    
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                tela.dispose();
               
            }
        });
        panel.add(background);
        tela.add(eixoX);
        tela.add(eixoY);
        tela.add(btn);
        tela.add(panel);
        tela.setVisible(true);
    }
    public void inserindoEndereco(String formato) throws SQLException{
        db = new FuncaoBanco();
        if(verificaEixoX()==true){
            int eixoX = Integer.parseInt(getEixoX());
            int eixoY = Integer.parseInt(getEixoY());

          
            switch (getOpcao()){
               case 1:
                   id = db.selecionarPorId(getOpcao(), formato);
                   endereco = new Endereco(eixoX, eixoY);
                   endereco.setFkU(id);
                   db.endereco(endereco);
                   break;
                case 2:
                    id = db.selecionarPorId(getOpcao(), formato);
                    endereco = new Endereco(eixoX, eixoY, id);
                    db.endereco(endereco);
                    break;
                default:
                    break;

           }

            System.out.println(endereco.getFkR());


        }

    }
    public boolean verificaEixoX(){
        int tamanhoX = getEixoX().length();
        int tamanhoY = getEixoY().length();
        if(getEixoX().substring(0,tamanhoX).matches("[A-Z]*") || getEixoX().substring(0,tamanhoY).matches("[a-z]*") ){
            return false;
        }if(getEixoY().substring(0,tamanhoY).matches("[A-Z]*") ||getEixoY().substring(0,tamanhoY).matches("[a-z]*") ){
            return false;
        }
        return true;
    }
}


