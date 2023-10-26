package org.example.Telas;
import org.example.Banco.FuncaoBanco;
import org.example.Classes.Pedidos;
import org.example.Componentes.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.sql.SQLException;
import java.util.ArrayList;

public class TelaPedido extends Tela{


    public String getCPF() {
        return CPF;
    }
    Timer tempo = new Timer();

    public int getQuantidade() {
        return quantidade;
    }

    public int getFkU() {
        return fkU;
    }
    CheckBox restaurantes = new CheckBox(2);
    CheckBox lanches;

    int quantidade = 0;
    Pedidos pedido;
    FuncaoBanco db = new FuncaoBanco();;
    String CPF;
    Panel panel = new Panel();
    Button btn = new Button();
    Button btnQuantidade = new Button();
    Button btnProximo = new Button();
    Label mensagem = new Label();
    ArrayList<String> cardapios = new ArrayList<String>();
    String[] cardapioRestauranteId = new String[20];
    int fkU;

    TelaPedido(String cpf) throws SQLException {
        this.CPF = cpf;
        restaurantes.setOpaque(false);

        Label background = new Label();
        String bosch = "C:\\Users\\53688621808\\IdeaProjects\\AplicativoTeste\\src\\main\\java\\org\\example\\Images\\TelaPedido.png";

        background.setIcon(new ImageIcon(bosch));
        background.setSize(650, 1000);
        background.setLocation(0, 0);
        restaurantes.setLocation(170, 522);
        btnProximo.setLocation(275, 722);
        btn.setLocation(414, 520);
        btnProximo.setText(">");
        btnProximo.setSize(120, 50);
        btn.setSize(60, 50);
        btnQuantidade.setSize(60, 50);
        btnQuantidade.setLocation(414, 620);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    cardapioDoRestaurante();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        btnQuantidade.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                quantidade++;
                btnQuantidade.setText(String.format(String.valueOf(quantidade)));
            }
        });

        btnProximo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    inserirPedido();
                    new TelaFinal(getFkU());
                    dispose();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        add(restaurantes);
        add(btnQuantidade);
        add(btn);
        add(btnProximo);
        panel.add(background);
        add(panel);
        add(mensagem);
        setVisible(true);

    }

    public String[] inserirPedido() throws SQLException {
        fkU = db.selecionarPorId(1, getCPF());
        int fkR = db.selecionarPorId(5, restaurantes.getSelecionado());
        System.out.println(restaurantes.getSelecionado());
        int fkL = db.selecionarPorId(3, lanches.getClicado());
        float preco = db.selecionarPreco(fkL);
        float precoTotal = preco * getQuantidade();
        pedido = new Pedidos(precoTotal, fkU, fkL, fkR);
        db.adicionarPedido(pedido);

        return cardapioRestauranteId;
    }

    public void cardapioDoRestaurante() throws SQLException {
        int fkR = db.selecionarPorId(5, restaurantes.getSelecionado());
        db.selecionarFk(1, cardapios, fkR);
        int index = 0;
        for (String item : cardapios) {
            cardapioRestauranteId[index] = item;
            index++;
        }
        lanches = new CheckBox(cardapioRestauranteId);
        lanches.setLocation(185, 620);
        lanches.setOpaque(false);
        add(lanches);
    }


}
