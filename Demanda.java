package org.example;

public class Demanda {
    String nome;
    String lanche;

    public Demanda(String nome, String lanche, String preco) {
        this.nome = nome;
        this.lanche = lanche;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLanche() {
        return lanche;
    }

    public void setLanche(String lanche) {
        this.lanche = lanche;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    String preco;
}
