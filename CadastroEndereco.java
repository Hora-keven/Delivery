
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.sql.SQLException;

public class CadastroEndereco {
    Input eixoX = new Input();
    Tela telaP = new Tela();
    Panel panel = new Panel();
    Button btn = new Button();
    Label background = new Label();
    Input eixoY = new Input();
    FuncaoBanco db;
    Endereco endereco;
    String nome;

    public String getNome(){
        return nome;
    }
    public String getEixoX() {
        return eixoX.getText();
    }
    public String getEixoY() {
        return eixoY.getText();
    }

    CadastroEndereco(String nome){
      
        this.nome = nome;
      
        background.setIcon(new ImageIcon("/home/keven/Documentos/MavenAplicativo/demo/projects/logging/src/main/java/Images/CadastroEndereco.png"));
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
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
              
               
            }
        });
        
        panel.add(background);
        telaP.add(eixoX);
        telaP.add(eixoY);
       
        telaP.add(btn);
        telaP.add(panel);
      
        telaP.setVisible(true);
    }
    public void inserindoEndereco(String cpf) throws SQLException{
        db = new FuncaoBanco();
        int eixoX = Integer.parseInt(getEixoX());
        int eixoY = Integer.parseInt(getEixoY());
        endereco = new Endereco(eixoX, eixoY);
        int id = db.getId(1, cpf);
        endereco.setFkU(id);
        db.endereco(endereco);
    }
}


