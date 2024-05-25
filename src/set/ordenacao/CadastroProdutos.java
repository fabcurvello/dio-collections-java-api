package set.ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {

    private Set<Produto> produtosSet ;

    public CadastroProdutos() {
        produtosSet = new HashSet<>();
    }

    public void adicionarProduto(int cod, String nome, double preco, int qtd) {
        produtosSet.add(new Produto(nome, cod, preco, qtd));
    }

    //A classe Produto recebeu implements Comparable para este método conseguir ordenar
    public Set<Produto> exibirProdutosOrdenadosPorNome() {
        //TreeSet vai organizar o HashSet conforme ordenação imposta pelo método compareTo da Classe Produto.
        //Não foi utilizado Collections.sort(), pois só funciona com List, e aqui estamos utilizando HashSet.
        Set<Produto> produtosOrdenadosPorNome = new TreeSet<>(produtosSet);
        return produtosOrdenadosPorNome;
    }

    //Abaixo da classe Produto foi criada a classe Comparator para este método conseguir ordenar
    public Set<Produto> exibirProdutosOrdenadosPorPreco() {
        //TreeSet vai organizar o HashSet conforme ordenação imposta pela classe ComparatorPorPreco.
        Set<Produto> produtosOrdenadosPorPreco = new TreeSet<>(new ComparatorPorPreco()) ;
        produtosOrdenadosPorPreco.addAll(produtosSet);
        return produtosOrdenadosPorPreco;
    }

    public static void main(String[] args) {
        CadastroProdutos cp = new CadastroProdutos();
        cp.adicionarProduto(1, "Produto 5", 15.99, 5);
        cp.adicionarProduto(2, "Produto 0", 20.99, 10);
        cp.adicionarProduto(1, "Produto 3", 10.99, 2); //cod repetido. Não será adicionadp.
        cp.adicionarProduto(9, "Produto 9", 2.99, 2);

        System.out.println(cp.produtosSet);
        System.out.println(cp.exibirProdutosOrdenadosPorNome());
        System.out.println(cp.exibirProdutosOrdenadosPorPreco());
    }

}
