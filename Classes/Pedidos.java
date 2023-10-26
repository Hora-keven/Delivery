package org.example.Classes; //

public class Pedidos {

    public float getPrecoTotal() {
        return precoTotal;
    }


    float precoTotal;

    int fkU;
    int fkR;
    int fkL;

    public Pedidos(float preco, int fkU, int fkR, int fkL) {
        this.precoTotal = preco;
        this.fkU = fkU;
        this.fkR = fkR;
        this.fkL = fkL;
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
