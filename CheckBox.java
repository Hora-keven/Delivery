// package org.example;
import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;


public class CheckBox extends JPanel {

    JComboBox<String> selecao;
    JComboBox<String> selecaoLanche;
    int opcao;
    static int id;
    String [] arraylistToList;

    public void setClicado(String clicado) {
        this.clicado = clicado;
    }
    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    int contador;
    public String getClicado() {

        return clicado;
    }

    FuncaoBanco db;
    private int escolha;
    String clicado;
    public int getQuantidade() {
        return quantidade;
    }

    String selecionado;

    int quantidade;
    public int getOpcao() {
        return opcao;
    }

    public int getId() {
        return id;
    }
    String []especifico;

    public String getSelecionado() {
        return selecionado;
    }

    CheckBox(int opcao) throws SQLException {
        this.opcao = opcao;
        checkBoxes(getOpcao());
        setSize(270, 55);
        add(selecao);


    }
    CheckBox(String []especifico){
        this.especifico = especifico;
        especifico();

        setSize(270, 55);
        add(selecao);
    }
  

    public void checkBoxes(int opcao) throws SQLException {
        db = new FuncaoBanco();
        ArrayList<String> lista = new ArrayList<String>();

        String [] arraylistToList;
        switch (opcao){
            case 1:
                lista.add("Usuarios");
                db.selecionar(1,lista, false);
                escolha = 1;
                break;
            case 2:
                lista.add("Restaurantes");
                db.selecionar(2,lista, true);
                escolha = 2;
                break;
            case 3:
                lista.add("Lanches");
                db.selecionar(3,lista, true);
                escolha = 3;
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
                            id = db.getId(1, selecionado);
                           
                            break;

                        case 2:
                            id = db.getId(2, selecionado);
                            break;
                        case 3:
                         
                            id = db.getId(3, selecionado);
                            quantidade++;
                            break;
                     
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

   
    public String especifico(){
        especifico[0]="Lanches";
        selecaoLanche =  new JComboBox<String>(especifico);
        contador++;
     
        clicado = selecaoLanche.getSelectedItem().toString(); 
       
        
        selecao.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                        clicado =(String) e.getItem();
                            
            }
        }
        });
        
          
        return clicado;
    }

    public static void main(String[] args) throws SQLException{
        Tela t = new Tela();
       
        
        String[] cardapioRestauranteId = new String[2];
        cardapioRestauranteId[0]="keven";
        cardapioRestauranteId[1]="maria";       
        CheckBox c = new CheckBox(cardapioRestauranteId);
       
        t.add(c);
        t.setVisible(true);
    }
}

