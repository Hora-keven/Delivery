package org.example;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class CheckBox extends JPanel {

     JComboBox<String> selecao;
    int opcao;
    int id;
    FuncaoBanco db;
    int escolha;
    String selecionado;

    public int getOpcao() {
        return opcao;
    }

    public String getSelecionado() {
        return selecionado;
    }

    CheckBox(int opcao) throws SQLException {
        this.opcao = opcao;
        checkBoxes(getOpcao());
        setSize(270, 55);
        add(selecao);


    }
    CheckBox(){

    }
    public int getId() {
        return id;
    }

    public void checkBoxes(int opcao) throws SQLException {
        db = new FuncaoBanco();
        ArrayList<String> lista = new ArrayList<>();

        String [] arraylistToList;
        switch (opcao){
            case 1:
                lista.add("Restaurantes");
                db.selecionar(2,lista, false);
                escolha = 1;
                break;
            case 2:
                lista.add("Lanches");
                db.selecionar(4,lista, false);
                escolha = 2;
                break;
            case 3:
                lista.add("Usuários");
                db.selecionar(1,lista, false);
                escolha = 3;
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
        selecao.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED)
                    selecionado = (String) e.getItem();
                    System.out.println(e.getItem());
                try {
                    switch (escolha){
                        case 1:
                            id = db.getId(2, selecionado);
                            break;
                        case 2:
                            id = db.getId(3, selecionado);
                            break;
                        case 3:
                            id = db.getId(1, selecionado);
                            break;
                        default:
                            break;
                    }

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        System.out.println(id);
        selecao.setSelectedIndex(0);

    }

    public static void main(String[] args) throws SQLException{
        Tela t = new Tela();
        t.add(new CheckBox(1));
        t.setVisible(true);
    }
}

