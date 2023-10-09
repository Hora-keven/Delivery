// package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class TelaCadastroRestaurante {

    Senha confirmaSenha = new Senha();
    Input cnpj  = new Input();
    Input nomeRestaurante = new Input();
    Senha senha = new Senha();
    Restaurante restaurante;
    FuncaoBanco db;

    public String getNomeRestaurante() {
        return nomeRestaurante.getText();
    }

    public String getSenha() {
        return senha.getText();
    }

    public String getCnpj() {
        return cnpj.getText();
    }

    Tela telaP = new Tela();

    Button btn = new Button();
    Label mensagem = new Label();

    public String getConfirmaSenha() {
        return confirmaSenha.getText();
    }

    Label background = new Label();

    TelaCadastroRestaurante() throws SQLException{

        String casa = "/home/keven/Documentos/MavenAplicativo/demo/projects/logging/src/main/java/Images/telaRestaurante.png";
        String senai = "C:/Users/53688621808/IdeaProjects/AplicativoTeste/src/main/java/org/example/Images/telaRestaurante.png";
        String bosch = "C:\\Users\\ct67ca\\Documents\\AplicativoTeste\\src\\main\\java\\org\\example\\Images\\telaRestaurante.png";
        String bosch2 = "projects/logging/src/main/java/Images/telaRestaurante.png";
        
        mensagem.setSize(350, 100);
        mensagem.setLocation(180,420);
        mensagem.setForeground(Color.WHITE);
        background.setIcon(new ImageIcon(casa));
        background.setSize(650, 1000);
        background.setLocation(0, 0);

        nomeRestaurante.setLocation(190, 522);
        cnpj.setLocation(190, 592);
        senha.setLocation(190, 665);
        confirmaSenha.setLocation(190, 736);

        btn.setText("Próximo >");


        btn.addActionListener(new ActionListener(){
            public void actionPerformed( ActionEvent evt) {
                if(getSenha().equals(getConfirmaSenha()) && (!getSenha().equals(null))==(!getConfirmaSenha().equals(null))){
                    try {
                        inserindoRestaurante();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getNomeRestaurante());
                }else if(!senha.getText().equals(getConfirmaSenha())&& (!getSenha().equals(null))==(!getConfirmaSenha().equals(null)) ){
                    mensagem.setText("Coloque uma senha correta!");
                }
            }
        });

        btn.setSize(270, 50);
        btn.setLocation(190,808);
        telaP.add(nomeRestaurante);
        telaP.add(mensagem);
        telaP.add(confirmaSenha);
        telaP.add(senha);
        telaP.add(cnpj);
        telaP.add(btn);
        telaP.add(background);
        telaP.setVisible(true);

    }
    public void inserindoRestaurante() throws SQLException{
        db = new FuncaoBanco();
        if (verificaCnpj()==true && verificaSenha() == true){
            restaurante = new Restaurante(getNomeRestaurante(), getCnpj(), getSenha());
            db.adicionaRestaurante(restaurante);
            new TelaCadastroEndereco(getCnpj(), 2);
        }
    }
    public boolean verificaCnpj(){
        if(getCnpj().length() < 18 ){
            mensagem.setText("Faltam alguns digitos");
            return false;
        }
        else if(getCnpj().length() > 18){
            mensagem.setText("Digitos a mais, digite um CNPJ correto");
            return false;
        }else
            return true;
    }
    public boolean verificaSenha(){
        if(getSenha().length() < 8){
            mensagem.setText("O minimo da senha é 8 digitos");
            return false;
        }
        else if(getSenha().length() > 8 && getSenha().length() < 60){
            mensagem.setText("Deu certo");
            return true;
        }else
            return true;
    }

    public static void main(String[] args) throws SQLException {
        new TelaCadastroRestaurante();
    }
}
