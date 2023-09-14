import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Aplicativo{
    Restaurantes restaurante;
    Usuários usuarios;
    Map<Integer, Integer>localizacao= new HashMap<Integer, Integer>();
    Map<String, String>restaurantes= new HashMap<String, String>();

    public void cadastrarRestaurante(){
        restaurantes.put(restaurante.getNome(),restaurante.getLocalizacao());
        localizacao.put(restaurante.getEixox(), restaurante.getEixoy());
    }
         
    public Map getRestaurantes(){
        return restaurantes;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        Restaurantes l = new Restaurantes("Maria da comida", "Campinas SP", 100, 50);
        Aplicativo k = new Aplicativo();
        k.cadastrarRestaurante();
        System.out.println(k.getRestaurantes());
  
    }
    
}