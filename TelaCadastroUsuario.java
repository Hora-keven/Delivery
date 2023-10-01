
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
    Button btnConfirmar = new Button();
    boolean open;
    boolean dbInsert = false;
    Label mensagem = new Label();

  

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isDbInsert() {
        return dbInsert;
    }


    public void setDbInsert(boolean dbInsert) {
        this.dbInsert = dbInsert;
    }


    public boolean isOpen() {
        return open;
    }

  
     TelaCadastroUsuario() throws SQLException{
     
       
        setOpen(true);
        Label background = new Label();
        background.setIcon(new ImageIcon("/home/keven/Documentos/MavenAplicativo/demo/projects/logging/src/main/java/Images/telaPrincipal.png"));
        background.setSize(650, 1000);
        background.setLocation(0, 0);

   
        nomeUsuario.setLocation(200, 520);
       
    
        cpf.setLocation(200, 590);

        senhaI.setLocation(200, 665);
       
        confirmaSenha.setLocation(200, 740);
        mensagem.setLocation(300, 500);

        btnConfirmar.addActionListener(new ActionListener(){
         

            public void actionPerformed( ActionEvent evt) {
        
                if(getSenha().equals(confirmaSenha.getText())&& (!getSenha().equals(null))==(!confirmaSenha.getText().equals(null))){
                        setDbInsert(true);
                      
                        try {
                            inserindoUsuarios();
                        } catch (SQLException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                        System.out.println(getNome());
                }else if(!senhaI.getText().equals(confirmaSenha.getText()) ){
                    mensagem.setText("Coloque uma senha correta!");
                } 
        
              
               
            }
        });
      
       

        btn.setSize(130, 50);
        btn.setLocation(200,815);

        btnConfirmar.setSize(130, 50);
        btnConfirmar.setLocation(347,815);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed( ActionEvent evt)  {
                setOpen(false);
                btn.setEnabled(open);
                new CadastroEndereco(getCPF());
              
               
            }
        });
        
      
        panel.add(background);
        telaP.add(nomeUsuario);
        telaP.add(mensagem);
        telaP.add(confirmaSenha);
        telaP.add(senhaI);
        telaP.add(cpf);
        telaP.add(btn);
        telaP.add(btnConfirmar);
        telaP.add(panel);
        
        telaP.setVisible(isOpen());
       

      
    }
    public void inserindoUsuarios() throws SQLException{
        db = new FuncaoBanco();
        usuario = new Usuarios(getNome(), getSenha(), getCPF());
        db.adicionarUsuario(usuario);
    }

   
}
