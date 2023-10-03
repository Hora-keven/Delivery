package org.example;
import javax.swing.ImageIcon;
import java.awt.event.*;
import java.sql.SQLException;

public class TelaCadastroUsuario{
   
    Input confirmaSenha = new Input();
    Input cpf  = new Input();
    Input nomeUsuario = new Input();
    Input senhaI = new Input();
    Usuarios usuario;
    FuncaoBanco db;
   
    public String getNome() {
            return nomeUsuario.getText();
    }

    public String getSenha() {
            return senhaI.getText();
    }

    public String getCPF() {
            return cpf.getText();
    }


    Tela telaP = new Tela();
    Panel panel = new Panel();
    Button btn = new Button();

    boolean open;
    Label mensagem = new Label();
    Panel caixaMensagem  = new Panel();
    public void setOpen(boolean open) {
        this.open = open;
    }
    public boolean isOpen() {
        return open;
    }
     TelaCadastroUsuario() throws SQLException{
     
       
        setOpen(true);
        Label background = new Label();
        String casa = "/home/keven/Documentos/Delivery/Images/telaPrincipal.png";
        String senai = "C:/Users/53688621808/IdeaProjects/AplicativoTeste/src/main/java/org/example/Images/telaPrincipal.png";
        background.setIcon(new ImageIcon(senai));
        background.setSize(650, 1000);
        background.setLocation(0, 0);

   
        nomeUsuario.setLocation(190, 520);
        cpf.setLocation(190, 590);
        senhaI.setLocation(190, 665);
        confirmaSenha.setLocation(190, 736);
        mensagem.setLocation(300, 200);
        btn.setText("Próximo >");
        mensagem.setText("aaaaaaaaaaaaaaaaaaaaaaaa");

        btn.addActionListener(new ActionListener(){
            public void actionPerformed( ActionEvent evt) {
                if(getSenha().equals(confirmaSenha.getText()) && (!getSenha().equals(null))==(!confirmaSenha.getText().equals(null))){
                        try {
                            inserindoUsuarios();

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        System.out.println(getNome());
                }else if(!senhaI.getText().equals(confirmaSenha.getText())&& (!getSenha().equals(null))==(!confirmaSenha.getText().equals(null)) ){
                    mensagem.setText("Coloque uma senha correta!");
                }
                setOpen(false);


            }
        });

        btn.setSize(270, 50);
        btn.setLocation(190,809);
        panel.add(background);
        telaP.add(nomeUsuario);
        telaP.add(mensagem);
        telaP.add(confirmaSenha);
        telaP.add(senhaI);
        telaP.add(cpf);
        telaP.add(btn);
        telaP.add(panel);
        telaP.setVisible(isOpen());
    }
    public void inserindoUsuarios() throws SQLException{
        db = new FuncaoBanco();
        if (verificaCpf()==true && verificaSenha() == true){
            usuario = new Usuarios(getNome(), getSenha(), getCPF());
            db.adicionarUsuario(usuario);
            new CadastroEndereco(getCPF(), 1);
            telaP.dispose();
        }

    }
    public boolean verificaCpf(){
        if(getCPF().length() < 11){
            System.out.println("Faltam alguns digitos");
            return false;
        }
        else if(getCPF().length() > 11){
            System.out.println("Digitos a mais, digite um CPF correto");
            return false;
        }else
            return true;
    }
    public boolean verificaSenha(){
        if(getSenha().length() < 8){
            System.out.println("O minimo da senha é 8 digitos");
            return false;
        }
        else if(getSenha().length() > 8 && getSenha().length() < 60){
            System.out.println("Deu certo");
            return true;
        }else
            return true;
    }
}
