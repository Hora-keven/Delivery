import java.sql.SQLDataException;
import java.sql.SQLException;

public class Aplicativo {
    

    FuncaoBanco db;

    public void cadastrarRestaurante(Restaurante r, Endereco e) throws SQLException {
        db.adicionar_restaurante(r);
        db.endereco(e);
    }
         
    public String getRestaurantes(){
        return "restaurante";
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        
  
    }
    

}
