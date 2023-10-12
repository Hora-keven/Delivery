 

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TelaFinal extends Tela {
 
    public String getNome() {
        return nome;
    }

    public String getLanche() {
        return lanche;
    }

    public String getPreco() {
        return preco;
    }
    JTable tabela;
    Label background = new Label();
    FuncaoBanco db = new FuncaoBanco();
    String nome, lanche, preco;
    Button btn = new Button();
    int fkU;


    TelaFinal(int fkU) throws SQLException {
        this.fkU = fkU;

        String casa = "/home/keven/Documentos/MavenAplicativo/demo/projects/logging/src/main/java/Images/TelaLanche.png";
        String senai = "C:/Users/53688621808/IdeaProjects/AplicativoTeste/src/main/java/org/example/Images/TelaLanche.png";
        String bosch = "C:\\Users\\ct67ca\\Documents\\AplicativoTeste\\src\\main\\java\\org\\example\\Images\\TelaLanche.png";
        String bosch2 = "projects/logging/src/main/java/Images/TelaLanches.png";

        background.setIcon(new ImageIcon(casa));
        background.setSize(650, 1000);
        background.setLocation(0, 0);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new Aplicativo();
                dispose();

            }
        });
        btn.setText("<");
        btn.setSize(70, 50);
        btn.setLocation(50, 879);

        add(btn);
        add(db.demandaUsuario(tabela, fkU));
        add(background);
        setVisible(true);
    }


    public static void main(String[] args) throws SQLException {
        new TelaFinal(1);
    }
}
