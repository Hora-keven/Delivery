package org.example;
import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;


public class CheckBox extends JPanel {

    JComboBox<String> selecao;
    int opcao;
    static int id;
    FuncaoBanco db;
    private int escolha;

    public int getQuantidade() {
        return quantidade;
    }

    String selecionado;

    int quantidade;
    public int getOpcao() {
        return opcao;
    }

    public String getSelecionado() {
        return selecionado;
    }

    CheckBox(int opcao, int id) throws SQLException {
        this.opcao = opcao;
        this.id = id;
        checkBoxes(getOpcao());
        setSize(270, 55);
        add(selecao);


    }
    CheckBox(){

    }
    public int getId() {
        return id;
    }

    public int checkBoxes(int opcao) throws SQLException {
        db = new FuncaoBanco();
        ArrayList<String> lista = new ArrayList<String>();

        String [] arraylistToList;
        switch (opcao){
            case 1:
                lista.add("Restaurantes");
                db.selecionar(2,lista, false);
                escolha = 1;
                break;
            case 2:
                lista.add("Lanches");
                db.selecionar(4,lista, true);
                escolha = 2;
                break;
            case 3:
                lista.add("Usuários");
                db.selecionar(1,lista, true);
                escolha = 3;
                break;

            case 4:
                lista.add("Lanches");
                db.selecionarFk(1,lista, id);
                escolha = 4;
                break;
            default:
                break;
        }

        arraylistToList = new String[lista.size()];
        int i = 0;
        for (String e:lista) {
            arraylistToList[i] = e;
            i++;
        }
        
        selecao = new JComboBox<String>(arraylistToList);
        selecao.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED)
                    selecionado = (String) e.getItem();

                try {
                    switch (escolha){
                        case 1:
                            id = db.getId(2, selecionado);
                            return id;

                        case 2:
                            id = db.getId(3, selecionado);
                            quantidade++;
                            return id;
                        case 3:
                            id = db.getId(1, selecionado);
                            break;
                        case 4:
                            id = db.getId(4, selecionado);
                        default:
                            break;
                    }

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        selecao.setSelectedIndex(0);

    }

    public static void main(String[] args) throws SQLException{
        Tela t = new Tela();
        CheckBox c = new CheckBox();
        t.add(new CheckBox(1, 1));
        t.setVisible(true);
    }
}

