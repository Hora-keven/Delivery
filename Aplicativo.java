package org.example;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

import java.awt.event.ActionListener;


public class Aplicativo extends Tela {
  Label background = new Label();
  Button btnCadastroUsuario = new Button();
  Button btnCadastroRestaurante = new Button();
  Button btnLogar = new Button();


  Aplicativo() {
    String casa = "/home/keven/Documentos/MavenAplicativo/demo/projects/logging/src/main/java/Images/telaPrincipal.png";
    String senai = "C:/Users/53688621808/IdeaProjects/AplicativoTeste/src/main/java/org/example/Images/telaPrincipal.png";
    String bosch = "C:\\Users\\ct67ca\\Documents\\AplicativoTeste\\src\\main\\java\\org\\example\\Images\\telaPrincipal.png";
    String bosch2 = "projects/logging/src/main/java/Images/telaPrincipal.png";

    btnCadastroRestaurante.setSize(270, 50);
    btnCadastroRestaurante.setLocation(190,600);
    btnCadastroUsuario.setSize(270, 50);
    btnCadastroUsuario.setLocation(190,720);
    btnLogar.setLocation(190,840);
    btnLogar.setSize(270, 50);

    background.setIcon(new ImageIcon(senai));
    background.setSize(650, 1000);
    background.setLocation(0, 0);

    btnCadastroUsuario.setText("Cadastro Usuário");
    btnCadastroUsuario.addActionListener(new ActionListener(){
      public void actionPerformed( ActionEvent evt) {
        
        try {
          new TelaCadastroUsuario();
          dispose();
        } catch (SQLException e) {
          e.printStackTrace();
        }
        }});

        btnLogar.setText("Acessar conta");
        btnLogar.addActionListener(new ActionListener(){
          public void actionPerformed( ActionEvent evt) {
          try {
            new TelaLoginUsuario();
            dispose();
          } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }

        } });
     
    
    btnCadastroRestaurante.setText("Cadastro Restaurante");
    btnCadastroRestaurante.addActionListener(new ActionListener(){
      public void actionPerformed( ActionEvent evt) {
        
        try {
          new TelaCadastroRestaurante();
          dispose();
        } catch (SQLException e) {
   
          e.printStackTrace();
        }
 }});
    add(btnLogar);
    add(btnCadastroRestaurante);
    add(btnCadastroUsuario);
    add(background);
    setVisible(true);
  }

  public static void main(String[] args) {
      new Aplicativo();
  }

}
