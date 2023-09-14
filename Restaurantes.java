import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Restaurantes {
    String nome;
    String localizacao;
    int eixoX, eixoY;
  
 
    Map<String, Integer>lanches= new HashMap<String, Integer>();
   

    public Restaurantes(String nome, String localizacao, int eixoX, int eixoY){
        this.nome = nome;
        this.localizacao = localizacao;
        this.eixoX = eixoX;
        this.eixoY=eixoY;
    }
    public String imprimirCardapio(){
        return "Cardapio Lanches";
    }
    public void adicionaLanche(String lanche, int valor){
        lanches.put(lanche, valor);
    }
    public void removerLanche(String lanche){
        lanches.get(lanche);
    }
   
    public String getNome(){
        return nome;
    }
    public int getEixox(){
        return eixoX;
    }
    public int getEixoy(){
        return eixoY;
    }
    public String getLocalizacao(){
        return localizacao;
    }


}
