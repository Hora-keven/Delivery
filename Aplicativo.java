package org.example;

import javax.swing.ImageIcon;
import java.sql.SQLException;

public class Aplicativo extends Tela {
  Label background = new Label();
  Button btnCadastroUsuario = new Button();
  Button btnCadastroRestaurante = new Button();


  Aplicativo() {
    String casa = "/home/keven/Documentos/MavenAplicativo/demo/projects/logging/src/main/java/Images/telaPrincipal.png";
    String senai = "C:/Users/53688621808/IdeaProjects/AplicativoTeste/src/main/java/org/example/Images/telaPrincipal.png";
    String bosch = "C:\\Users\\ct67ca\\Documents\\AplicativoTeste\\src\\main\\java\\org\\example\\Images\\telaPrincipal.png";
    String bosch2 = "projects/logging/src/main/java/Images/telaPrincipal.png";

    btnCadastroRestaurante.setSize(270, 50);
    btnCadastroRestaurante.setLocation(190,600);
    btnCadastroUsuario.setSize(270, 50);
    btnCadastroUsuario.setLocation(190,720);

    background.setIcon(new ImageIcon(senai));
    background.setSize(650, 1000);
    background.setLocation(0, 0);

    btnCadastroUsuario.setText("Usuário");
    btnCadastroUsuario.addActionListener(e->{
      try {
        TelaCadastroUsuario telaCadastroUsuario = new TelaCadastroUsuario();
        dispose();
      } catch (SQLException ex) {
        throw new RuntimeException(ex);
      }
    });
    btnCadastroRestaurante.setText("Restaurante");
    btnCadastroRestaurante.addActionListener(e->{
      try {
        TelaCadastroRestaurante telaCadastroRestaurante = new TelaCadastroRestaurante();
        dispose();
      } catch (SQLException ex) {
        throw new RuntimeException(ex);
      }
    });
    add(btnCadastroRestaurante);
    add(btnCadastroUsuario);
    add(background);
    setVisible(true);
  }

  public static void main(String[] args) {
    new Aplicativo();
  }

}
