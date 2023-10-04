

package org.example;
public class Usuarios {


        String nome;
        private String senha;
        private String CPF;
        Usuarios(String nome, String senha, String CPF) {
                this.nome = nome;
                this.senha = senha;
                this.CPF = CPF;
        }


        public String getNome() {
                return nome;
        }

        public String getSenha() {
                return senha;
        }

        public String getCPF() {
                return CPF;
        }

}
