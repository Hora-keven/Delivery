package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class TelaLoginUsuario  extends Tela { 
    ArrayList<String> senhacadastrada= new ArrayList<String>();
    ArrayList<String> cpfCadastrado = new ArrayList<String>();

    Input cpf  = new Input();
    Senha senha = new Senha();
    Button btn = new Button();
    
    Label mensagem = new Label();
    public String getCPF() {
        return cpf.getText();
    }
    public String getSenha() {
        return senha.getText();
    }

    Label background = new Label();
    TelaLoginUsuario() throws SQLException{

        String casa = "/home/keven/Documentos/MavenAplicativo/demo/projects/logging/src/main/java/Images/TelaLogin.png";
        String senai = "C:/Users/53688621808/IdeaProjects/AplicativoTeste/src/main/java/org/example/Images/TelaLogin.png";
        String bosch = "C:\\Users\\ct67ca\\Documents\\AplicativoTeste\\src\\main\\java\\org\\example\\Images\\TelaLogin.png";
        String bosch2 = "projects/logging/src/main/java/Images/telaedido.png";
   
        background.setIcon(new ImageIcon(senai));
        background.setSize(650, 1000);
        background.setLocation(0, 0);
        mensagem.setLocation(300, 200);

        btn.addActionListener(new ActionListener(){
            public void actionPerformed( ActionEvent evt) {
                        try {
                            if (verificaCpf() == verificaSenha()){
                                new TelaPedido(getCPF());
                                dispose();
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
            }
        });
        
        
        cpf.setSize(270, 50);
        cpf.setLocation(190, 520);
        senha.setLocation(190, 590);
        btn.setSize(150, 50);
        btn.setLocation(254,665);
        add(mensagem);
        add(senha);
        add(cpf);
        add(btn);
        add(background);
        setVisible(true);
    }
    public boolean verificaCpf() throws SQLException{
        if(getCPF().length() < 11){
            mensagem.setText("Faltam alguns digitos");
            return false;
        }

        else if(getCPF().length() > 11){
            mensagem.setText("Digitos a mais, digite um CPF correto");
            return false;

        }else{
            FuncaoBanco db = new FuncaoBanco();
            db.selecionar(1, cpfCadastrado, true);
         
            for (String cpf : cpfCadastrado) {
               if(getCPF().equals(cpf));{
                System.out.println("cadastrado");
                return true;
               } 
            }
            return false;
        }
    }
    public boolean verificaSenha() throws SQLException {
        if(getSenha().length() < 8){
            mensagem.setText("O minimo da senha é 8 digitos");
            return false;
        }
        else if(getSenha().length() > 8 && getSenha().length() < 60){
            mensagem.setText("Deu certo");
            FuncaoBanco db = new FuncaoBanco();
            db.selecionar(1, senhacadastrada, false);

            for (String senha : cpfCadastrado) {
                if(getSenha().equals(senha));{
                    System.out.println("cadastrado");
                    return true;
                }
            }
            return true;
        }else
            return true;
    }
    

    public static void main(String[] args) throws SQLException {
        new TelaLoginUsuario();
    }
}

