package org.example;
import javax.swing.ImageIcon;
import java.awt.event.*;
import java.sql.SQLException;

public class CadastroRestaurante{

    Input confirmaSenha = new Input();
    Input cnpj  = new Input();
    Input nomeRestaurante = new Input();
    Input senha = new Input();
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
    Panel panel = new Panel();
    Button btn = new Button();
    Label mensagem = new Label();


    CadastroRestaurante() throws SQLException{
        Label background = new Label();
        String casa = "/home/keven/Documentos/Delivery/Images/telaPrincipal.png";
        String senai = "C:/Users/53688621808/IdeaProjects/AplicativoTeste/src/main/java/org/example/Images/telaRestaurante.png";
        String bosch = "C:\\Users\\ct67ca\\Documents\\AplicativoTeste\\src\\main\\java\\org\\example\\Images\\telaRestaurante.png";
        background.setIcon(new ImageIcon(senai));
        background.setSize(650, 1000);
        background.setLocation(0, 0);

        nomeRestaurante.setLocation(190, 522);
        cnpj.setLocation(190, 592);
        senha.setLocation(190, 665);
        confirmaSenha.setLocation(190, 736);

        btn.setText("Próximo >");


        btn.addActionListener(new ActionListener(){
            public void actionPerformed( ActionEvent evt) {
                if(getSenha().equals(confirmaSenha.getText()) && (!getSenha().equals(null))==(!confirmaSenha.getText().equals(null))){
                    try {
                        inserindoRestaurante();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getNomeRestaurante());
                }else if(!senha.getText().equals(confirmaSenha.getText())&& (!getSenha().equals(null))==(!confirmaSenha.getText().equals(null)) ){
                    mensagem.setText("Coloque uma senha correta!");
                }



            }
        });

        btn.setSize(270, 50);
        btn.setLocation(190,808);
        panel.add(background);
        telaP.add(nomeRestaurante);
        telaP.add(mensagem);
        telaP.add(confirmaSenha);
        telaP.add(senha);
        telaP.add(cnpj);
        telaP.add(btn);
        telaP.add(panel);
        telaP.setVisible(true);
    }
    public void inserindoRestaurante() throws SQLException{
        db = new FuncaoBanco();
        if (verificaCnpj()==true && verificaSenha() == true){
            restaurante = new Restaurante(getNomeRestaurante(), getCnpj(), getSenha());
            db.adicionaRestaurante(restaurante);
            new CadastroEndereco(getCnpj(), 2);
        }
    }
    public boolean verificaCnpj(){
        if(getCnpj().length() < 14){
            System.out.println("Faltam alguns digitos");
            return false;
        }
        else if(getCnpj().length() > 14){
            System.out.println("Digitos a mais, digite um CNPJ correto");
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

    public static void main(String[] args) throws SQLException {
        new CadastroRestaurante();
    }
}
