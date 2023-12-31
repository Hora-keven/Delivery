package org.example.Classes;

public class Endereco {
    int eixoX;
    int eixoY;
    int fkU;
    int fkR;

    public Endereco(int eixoX, int eixoY) {
        this.eixoX = eixoX;
        this.eixoY = eixoY;
    }

    public Endereco(int eixoX, int eixoY, int fkR) {
        this.eixoX = eixoX;
        this.eixoY = eixoY;
        this.fkR = fkR;
    }

    public void setFkU(int fkU) {
        this.fkU = fkU;
    }

    public void setFkR(int fkR) {
        this.fkR = fkR;
    }

    public int getEixoX() {
        return eixoX;
    }

    public int getEixoY() {
        return eixoY;
    }

    public int getFkU() {
        return fkU;
    }

    public int getFkR() {
        return fkR;
    }
}
