
import javax.swing.ImageIcon;



public class Aplicativo extends Tela {
    Label background = new Label();
    
    Aplicativo(){
        String casa = "/home/keven/Documentos/MavenAplicativo/demo/projects/logging/src/main/java/Images/telaPrincipal.png";
        String senai = "C:/Users/53688621808/IdeaProjects/AplicativoTeste/src/main/java/org/example/Images/telaPrincipal.png";
        String bosch = "C:\\Users\\ct67ca\\Documents\\AplicativoTeste\\src\\main\\java\\org\\example\\Images\\telaPrincipal.png";
        String bosch2 = "projects/logging/src/main/java/Images/telaPrincipal.png";

        background.setIcon(new ImageIcon(casa));
        background.setSize(650, 1000);
        background.setLocation(0, 0);


      add(background);
      setVisible(true);
    }
      public static void main(String[] args) {
        new Aplicativo();
      }
    

}
