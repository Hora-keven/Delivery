package org.example;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class CheckBox extends JPanel {

     JComboBox petList;

    FuncaoBanco db;
    CheckBox() {

       
        setSize(270, 55);
        add(petList);

    }
    public void CheckBoxRestaurante() throws SQLException {
        db = new FuncaoBanco();

        ArrayList<String> restaurantes = new ArrayList<>();
        restaurantes.add("Restaurantes");

        db.selecionar(2,restaurantes);
        String [] restaurante = new String[restaurantes.size()];

        int i = 0;
        for (String e:restaurantes) {

            restaurante[i] = e;
            i++;
        }
        petList = new JComboBox(restaurante);
        petList.setSelectedIndex(0);
    }
    public void CheckBoxUsuario() throws SQLException {
        db = new FuncaoBanco();

        ArrayList<String> restaurantes = new ArrayList<>();
        restaurantes.add("Usuários");

        db.selecionar(2,restaurantes);
        String [] restaurante = new String[restaurantes.size()];

        int i = 0;
        for (String e:restaurantes) {

            restaurante[i] = e;
            i++;
        }
        petList = new JComboBox(restaurante);
        petList.setSelectedIndex(0);
    }
    public void CheckBoxLanche() throws SQLException {
        db = new FuncaoBanco();

        ArrayList<String> restaurantes = new ArrayList<>();
        restaurantes.add("Lanches");

        db.selecionar(2,restaurantes);
        String [] restaurante = new String[restaurantes.size()];

        int i = 0;
        for (String e:restaurantes) {

            restaurante[i] = e;
            i++;
        }
        petList = new JComboBox(restaurante);
        petList.setSelectedIndex(0);
    }

    public static void main(String[] args) throws SQLException{
        Tela t = new Tela();
        t.add(new CheckBox());
        t.setVisible(true);
    }
}

