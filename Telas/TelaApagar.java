package org.example.Telas;


import org.example.Aplicativo;
import org.example.Banco.FuncaoBanco;
import org.example.Componentes.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;
import java.util.ArrayList;
 
 public class TelaApagar extends Tela{
 
    
     CheckBox lanches;
 

     FuncaoBanco db = new FuncaoBanco();;
   
     int id;
     Panel panel = new Panel();
     Button btn = new Button();

     Button btnProximo = new Button();
     Label mensagem = new Label();
     ArrayList<String> lanchesRestaurante = new ArrayList<String>();
     String[] lancheRestauranteId = new String[20];
    
 
     TelaApagar(int id) throws SQLException {
         this.id = id;

         db.selecionarFk(1, lanchesRestaurante, id);
         int index = 1;
         lancheRestauranteId[0]="Lanches";
         for (String item : lanchesRestaurante) {
             lancheRestauranteId[index] = item;
             index++;
         }
         lanches = new CheckBox(lancheRestauranteId);
         lanches.setLocation(185, 620);
         lanches.setOpaque(false);

         Label background = new Label();
         String bosch = "C:\\Users\\53688621808\\IdeaProjects\\AplicativoTeste\\src\\main\\java\\org\\example\\Images\\TelaApagar.png";
 
         background.setIcon(new ImageIcon(bosch));
         background.setSize(650, 1000);
         background.setLocation(0, 0);
         lanches.setLocation(170, 522);
         btnProximo.setLocation(275, 603);
         btn.setLocation(428, 514);
         btnProximo.setText(">");
         btnProximo.setSize(120, 50);
         btn.setSize(60, 50);

         btn.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent evt) {
                try {
                    System.out.println(lanches.getId());
                    db.deletarPorId(lanches.getId());
                    mensagem.setText("Lanche "+lanches.getClicado()+"deletado");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
               
             }
         });
     
         btnProximo.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent evt) {
                new Aplicativo();
                dispose();
             }
         });
         add(lanches);
         add(mensagem);
         add(btn);
         add(btnProximo);
         panel.add(background);
         add(panel);
         setVisible(true);
 
     }
     public static void main(String[] args) throws SQLException {
         new TelaApagar(1);
     }
 }
 