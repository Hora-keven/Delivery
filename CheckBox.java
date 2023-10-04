package org.example;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class CheckBox extends JPanel {

     JComboBox<String> selecao;
    int opcao;
    FuncaoBanco db;

    public int getOpcao() {
        return opcao;
    }

    CheckBox(int opcao) throws SQLException {
        this.opcao = opcao;
        checkBoxes(getOpcao());
        setSize(270, 55);
        add(selecao);


    }
    public void checkBoxes(int opcao) throws SQLException {
        db = new FuncaoBanco();
        ArrayList<String> lista = new ArrayList<>();

        String [] arraylistToList;
        switch (opcao){
            case 1:
                lista.add("Restaurantes");
                db.selecionar(2,lista, false);
                break;
            case 2:
                lista.add("Lanches");
                db.selecionar(4,lista, false);
                break;
            case 3:
                lista.add("Usuários");
                db.selecionar(1,lista, false);
                break;
            default:
                break;
        }

        arraylistToList = new String[lista.size()];
        int i = 0;
        for (String e:lista) {
            System.out.println(e);
            arraylistToList[i] = e;
            i++;
        }
        selecao = new JComboBox<>(arraylistToList);
        selecao.setSelectedIndex(0);

    }

    public static void main(String[] args) throws SQLException{
        Tela t = new Tela();
        t.add(new CheckBox(1));
        t.setVisible(true);
    }
}

