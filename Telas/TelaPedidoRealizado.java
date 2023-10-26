package org.example.Telas;

import org.example.Aplicativo;
import org.example.Componentes.Label;
import org.example.Componentes.Panel;
import org.example.Componentes.Tela;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class TelaPedidoRealizado extends Tela {

    Panel panel = new Panel();
    Label background = new Label();
    public TelaPedidoRealizado(){
        String bosch = "C:\\Users\\53688621808\\IdeaProjects\\AplicativoTeste\\src\\main\\java\\org\\example\\Images\\TelaRealizado2.png";

        background.setIcon(new ImageIcon(bosch));
        background.setSize(650, 1000);
        background.setLocation(0, 0);


        Timer tempo = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new Aplicativo();
                dispose();
            }
        });
        tempo.setRepeats(false);
        tempo.start();

        panel.add(background);
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaPedidoRealizado();
    }
}
