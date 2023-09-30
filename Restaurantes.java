import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Restaurantes {
    String nome;
    String cnpj;
    int eixoX, eixoY;
  
   

    public Restaurantes(String nome, String cnpj, int eixoX, int eixoY){
        this.nome = nome;
        this.cnpj = cnpj;
        this.eixoX = eixoX;
        this.eixoY=eixoY;
    }
    public String imprimirCardapio(){
        return "Cardapio Lanches";
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
    public String getCnpj(){
        return cnpj;
    }


}
