// package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class TelaCadastroUsuario{
   
    Senha confirmaSenha = new Senha();
    Input cpf  = new Input();
    Input nomeUsuario = new Input();
    Senha senha = new Senha();
    Usuarios usuario;
    FuncaoBanco db;
   
    public String getNome() {
            return nomeUsuario.getText();
    }

    public String getSenha() {
            return senha.getText();
    }

    public String getCPF() {
            return cpf.getText();
    }


    Tela tela = new Tela();
    Panel panel = new Panel();
    Button btn = new Button();

    boolean open;

    Label mensagem = new Label();
    Label background = new Label();

     TelaCadastroUsuario() throws SQLException{
     


        String casa = "/home/keven/Documentos/MavenAplicativo/demo/projects/logging/src/main/java/Images/telaUsuario.png";
        String senai = "C:/Users/53688621808/IdeaProjects/AplicativoTeste/src/main/java/org/example/Images/telaUsuario.png";
        String bosch = "C:\\Users\\ct67ca\\Documents\\AplicativoTeste\\src\\main\\java\\org\\example\\Images\\telaUsuario.png";
        String bosch2 = "projects/logging/src/main/java/Images/telaUsuario.png";

        background.setIcon(new ImageIcon(casa));
        background.setSize(650, 1000);
        background.setLocation(0, 0);

   
        nomeUsuario.setLocation(190, 520);
        cpf.setLocation(190, 590);
        senha.setLocation(190, 665);
        confirmaSenha.setLocation(190, 736);
        mensagem.setLocation(300, 200);
        btn.setText("Próximo >");
        mensagem.setForeground(Color.WHITE);

        btn.addActionListener(new ActionListener(){
            public void actionPerformed( ActionEvent evt) {
                if(getSenha().equals(confirmaSenha.getText()) && (!getSenha().equals(null))==(!confirmaSenha.getText().equals(null))){
                        try {
                            inserindoUsuarios();
                         
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        System.out.println(getNome());
                }else if(!senha.getText().equals(confirmaSenha.getText())&& (!getSenha().equals(null))==(!confirmaSenha.getText().equals(null)) ){
                    mensagem.setText("Coloque uma senha correta!");
                }


            }
        });
        mensagem.setSize(350, 100);
        mensagem.setLocation(178,420);
        mensagem.setForeground(Color.WHITE);

        btn.setSize(270, 50);
        btn.setLocation(190,809);

         tela.add(nomeUsuario);
         tela.add(mensagem);
         tela.add(cpf);
         tela.add(btn);
         tela.add(confirmaSenha);
         tela.add(senha);
         tela.add(background);
         tela.setVisible(true);
    }
    public void inserindoUsuarios() throws SQLException{
        db = new FuncaoBanco();
        if (verificaCpf()==true && verificaSenha() == true){
            usuario = new Usuarios(getNome(), getSenha(), getCPF());
            db.adicionarUsuario(usuario);
            new TelaCadastroEndereco(getCPF(), 1);
            tela.dispose();
        }

    }
    public boolean verificaCpf(){
        if(getCPF().length() < 11){
            mensagem.setText("Faltam alguns digitos");
            return false;
        }
        else if(getCPF().length() > 11){
            mensagem.setText("Digitos a mais, digite um CPF correto");
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
}
