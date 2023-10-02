
package org.example;
public class Pedidos {
   
        String nomeUsuario;
        String nomeRestaurante;
        String lanche;
        int fkU;
        int fkR;
        int fkL;
    
        Pedidos(String usuario, String restaurante, String lanche, int fkU, int fkR, int fkL){
            this.nomeUsuario = usuario;
            this.nomeRestaurante = restaurante;
            this.lanche = lanche;
            this.fkU = fkU;
            this.fkR = fkR;
            this.fkL=fkL;
        }

        public int getFkU() {
            return fkU;
        }

        public int getFkR() {
            return fkR;
        }

        public int getFkL() {
            return fkL;
        }

        public String getNomeUsuario() {
            return nomeUsuario;
        }

        public String getNomeRestaurante() {
            return nomeRestaurante;
        }

        public String getLanche() {
            return lanche;
        }
    
}
