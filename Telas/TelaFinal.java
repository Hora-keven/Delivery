package org.example.Telas;
import org.example.Aplicativo;
import org.example.Banco.FuncaoBanco;
import org.example.Componentes.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TelaFinal extends Tela {

    JTable tabela;
    Label background = new Label();
    FuncaoBanco db = new FuncaoBanco();

    Button btn = new Button();
    int fkU;


    TelaFinal(int fkU) throws SQLException {
        this.fkU = fkU;
        String bosch = "C:\\Users\\ct67ca\\Documents\\AplicativoTeste\\src\\main\\java\\org\\example\\Images\\TelaLanche.png";

        background.setIcon(new ImageIcon(bosch));
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
