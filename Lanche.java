
      
public class Lanche {
    String nome;
    String preco;
    int fk_restaurante;

    public Lanche(String nome, String preco, int fk_restaurante) {
        this.nome = nome;
        this.preco = preco;
        this.fk_restaurante = fk_restaurante;
    }
    public Lanche(String nome, String preco) {
        this.nome = nome;
        this.preco = preco;

    }


    public String getNome() {
        return nome;
    }

    public String getPreco() {
        return preco;
    }

    public int getFk_restaurante() {
        return fk_restaurante;
    }

}
