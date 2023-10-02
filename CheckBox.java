package org.example;

import javax.swing.*;
import java.awt.*;

public class CheckBox extends JPanel {
    int quantidade;
     JComboBox petList;
    CheckBox(){

        String[] petStrings = { "Keven", "Maria", "Paulo" };

        petList = new JComboBox(petStrings);
        petList.setSelectedIndex(2);
       
        setSize(400, 100);
        add(petList);

    }

    public int getQuantidade(){
        return quantidade;
    }
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public static void main(String[] args) {
        Tela t = new Tela();
        t.add(new CheckBox());
        t.setVisible(true);
    }
}

