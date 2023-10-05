// package org.example;

public class Pedidos {
   
        public String getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(String precoTotal) {
        this.precoTotal = precoTotal;
    }

        String precoTotal;
 
        int fkU;
        int fkR;
        int fkL;
    
        Pedidos(String preco,int fkU, int fkR, int fkL){
            this.precoTotal = preco;
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


     
}
