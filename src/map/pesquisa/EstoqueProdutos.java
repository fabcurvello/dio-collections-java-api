package map.pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {

    private Map<Integer, Produto> estoqueProdutosMap;

    public EstoqueProdutos() {
        this.estoqueProdutosMap = new HashMap<>();
    }

    public void adicionarProduto(Integer cod, String nome, int qtd, double preco) {
        estoqueProdutosMap.put(cod, new Produto(nome, qtd, preco));
    }

    public void exibirProdutos() {
        System.out.println(estoqueProdutosMap);
    }

    public double calcularValorTotalEstoque() {
        double valorTotal = 0;
        if(!estoqueProdutosMap.isEmpty()) {
            for (Produto p : estoqueProdutosMap.values()) {
                valorTotal += (p.getPreco() * p.getQtd());
            }
        }
        return valorTotal;
    }

    public Produto obterProdutoMaisCaro() {
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        if(!estoqueProdutosMap.isEmpty()) {
            for (Produto p : estoqueProdutosMap.values()) {
                if (p.getPreco() > maiorPreco) {
                    produtoMaisCaro = p;
                    maiorPreco = p.getPreco();
                }
            }
        }
        return produtoMaisCaro;
    }

    public Produto obterProdutoMaisBarato() {
        Produto produtoMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;
        if(!estoqueProdutosMap.isEmpty()) {
            for (Produto p : estoqueProdutosMap.values()) {
                if (p.getPreco() < menorPreco) {
                    produtoMaisBarato = p;
                    menorPreco = p.getPreco();
                }
            }
        }
        return produtoMaisBarato;
    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        Produto produtoMaiorQuantidadeValorTotalEstoque = null;
        double maiorQtdValorTotal = Double.MIN_VALUE;
        if(!estoqueProdutosMap.isEmpty()) {
            for (Produto p : estoqueProdutosMap.values()) {
                if ( (p.getPreco() * p.getQtd()) > maiorQtdValorTotal ) {
                    produtoMaiorQuantidadeValorTotalEstoque = p;
                    maiorQtdValorTotal = p.getQtd() * p.getPreco();
                }
            }
        }
        return produtoMaiorQuantidadeValorTotalEstoque;
    }

    public static void main(String[] args) {
        EstoqueProdutos ep = new EstoqueProdutos();
        ep.exibirProdutos();

        ep.adicionarProduto(1, "Produto A", 10, 5.00);
        ep.adicionarProduto(2, "Produto B", 5, 10.00);
        ep.adicionarProduto(1, "Produto C", 2, 15.00); //SOBRESCREVE o que foi add antes com a mesma chave.
        ep.exibirProdutos();

        System.out.printf("Valor total do estoque: R$ %.2f \n", ep.calcularValorTotalEstoque());
        System.out.println("Produto mais barato: " + ep.obterProdutoMaisBarato());
        System.out.println("Produto mais caro: " + ep.obterProdutoMaisCaro());
        System.out.printf("Produto de maior quantidade valor: " + ep.obterProdutoMaiorQuantidadeValorTotalNoEstoque());
    }
}
