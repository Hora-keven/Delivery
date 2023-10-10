package org.example;

import javax.swing.*;
import java.sql.SQLException;

public class TelaFinal extends  Tela{
    Panel janelaTabela = new Panel();
    Label background = new Label();
    FuncaoBanco db = new FuncaoBanco();
    String [] coluna = {"Nome", "lanche", "preçoTotal"};

    Demanda[] demanda = new Demanda[db.quantidadeRow("Pedido")+1];
    TelaFinal() throws SQLException {
        String casa = "/home/keven/Documentos/MavenAplicativo/demo/projects/logging/src/main/java/Images/TelaLanche.png";
        String senai = "C:/Users/53688621808/IdeaProjects/AplicativoTeste/src/main/java/org/example/Images/TelaLanche.png";
        String bosch = "C:\\Users\\ct67ca\\Documents\\AplicativoTeste\\src\\main\\java\\org\\example\\Images\\TelaLanche.png";
        String bosch2 = "projects/logging/src/main/java/Images/TelaLanches.png";

        background.setIcon(new ImageIcon(senai));
        background.setSize(650, 1000);
        background.setLocation(0, 0);

        db.demandaUsuario(demanda);
        JTable tabela = new JTable();

        add(background);
        add(janelaTabela);
        setVisible(true);
    }

    public static void main(String[] args) throws SQLException {
        new TelaFinal();
    }
}
