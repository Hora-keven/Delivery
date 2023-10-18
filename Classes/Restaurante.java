package org.example.Classes;
// 

public class Restaurante {

    String nome;
    String cnpj;
    String senha;

    public String getSenha() {
        return senha;
    }

    public Restaurante(String nome, String cnpj, String senha) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.senha = senha;

    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

}
