// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;

// public class Aplicativo {
//     Connection connection = null;
//     FuncaoBanco db;
//     TelaPrincipal tela;
    
    // public void cadastrarRestaurante(Restaurante r, Endereco ed) throws SQLException {
      
    //     connection = DriverManager.getConnection("jdbc:sqlite:/home/keven/Documentos/Delivery/Aplicativo.db");
    //     try {
           
    //         db.adicionar_restaurante(r);
    //         db.endereco(ed);

    //     } catch (SQLException e) {
    //         System.err.println(e.getMessage());
    //     } finally {
    //         try {
    //             if (connection != null)
    //                 connection.close();
    //         } catch (SQLException e) {

    //             System.err.println(e.getMessage());
    //         }
    //     }
    
    // }

    // public void cadastrarUsuario() throws SQLException{

    //     try{
         
    //         Usuarios usuario = new Usuarios(tela.getNomeUsuario(),tela.getSenha(), tela.getCpf());
     
    //         db.adicionar_usuario(usuario);
    //     } catch (SQLException e) {
    //         System.err.println(e.getMessage());
    //     } finally {
    //         try {
    //             if (connection != null)
    //                 connection.close();
    //         } catch (SQLException e) {

    //             System.err.println(e.getMessage());
    //         }
    //     }
    
      
       
//     }

//     public void getRestaurantes() throws SQLException{
//       db.selecionar(0);
//     }
  
 

// }
