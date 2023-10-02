

package org.example;
public class Restaurante {

    String nome;
    String cnpj;

  
    public Restaurante(String nome, String cnpj, int eixoX, int eixoY){
        this.nome = nome;
        this.cnpj = cnpj;
      
    }
  
    public String getNome(){
        return nome;
    }
    public String getCnpj(){
        return cnpj;
    }




}
