package map.pesquisa;

public class Produto {

    private String nome;
    private int qtd;
    private double preco;

    public Produto(String nome, int qtd, double preco) {
        this.nome = nome;
        this.qtd = qtd;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", qtd=" + qtd +
                ", preco=" + preco +
                '}';
    }
}
