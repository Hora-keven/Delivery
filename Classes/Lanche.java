package org.example.Classes;

public class Lanche {
    String nome;
    float preco;
    int fk_restaurante;

    public Lanche(String nome, float preco, int fk_restaurante) {
        this.nome = nome;
        this.preco = preco;
        this.fk_restaurante = fk_restaurante;
    }


    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    public int getFk_restaurante() {
        return fk_restaurante;
    }

}
