package map.ordenacao;

import java.util.*;

public class LivrariaOnline {

    private Map<String, Livro> livrariaMap ;
    public LivrariaOnline() {
        livrariaMap = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco) {
        livrariaMap.put(link, new Livro(titulo, autor, preco));
    }

    public void removerLivro(String titulo) {
        List<String> linksRemover = new ArrayList<>();
        for ( Map.Entry<String, Livro> entry : livrariaMap.entrySet()) {
            if ( entry.getValue().getTitulo().equalsIgnoreCase(titulo.trim()) ) {
                linksRemover.add(entry.getKey());
            }
        }
        for (String link : linksRemover ) {
            livrariaMap.remove(link);
        }
    }

    //Para este método, foi implementada a Classe comparator após a classe Livro
    public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {

        //Um LIST onde cada item é uma entrada do MAP
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorPreco = new ArrayList<>(livrariaMap.entrySet());

        //Indica as regras de ordenação desejada (nesse caso, ordenação por preco)
        Collections.sort(livrosParaOrdenarPorPreco, new ComparatorPorPreco());

        //Map de LinkedHashMap que, no for, receberá as entradas já na ordem desejada
        Map<String, Livro> livrosOrdenadosPorPreco = new LinkedHashMap<>();

        for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorPreco) {
            livrosOrdenadosPorPreco.put(entry.getKey(),entry.getValue());
        }

        return livrosOrdenadosPorPreco;
    }

    //Para este método, foi implementada a Classe comparator após a classe Livro
    public Map<String, Livro> exibirLivrosOrdenadosPorAutor() {

        //Um LIST onde cada item é uma entrada do MAP
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorAutor = new ArrayList<>(livrariaMap.entrySet());

        //Indica as regras de ordenação desejada (nesse caso, ordenação por autor)
        Collections.sort(livrosParaOrdenarPorAutor, new ComparatorPorAutor());

        //Map de LinkedHashMap que, no for, receberá as entradas já na ordem desejada
        Map<String, Livro> livrosOrdenadosPorAutor = new LinkedHashMap<>();

        for (Map.Entry<String, Livro> entry: livrosParaOrdenarPorAutor) {
            livrosOrdenadosPorAutor.put(entry.getKey(), entry.getValue());
        }

        return livrosOrdenadosPorAutor;
    }

    public Map<String, Livro> pesquisarlivrosPorAutor(String autor) {
        Map<String,Livro> livrosPorAutor = new LinkedHashMap<>();
        for (Map.Entry<String, Livro> entry: livrariaMap.entrySet()) {
            Livro livro = entry.getValue();
            if (livro.getAutor().contains(autor.trim())) {
                livrosPorAutor.put(entry.getKey(),livro);
            }
        }
        return livrosPorAutor;
    }

    public Livro obterLivroMaisCaro(){
        Livro livroMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;

        for (Map.Entry<String, Livro> entry : livrariaMap.entrySet()) {
            if (maiorPreco < entry.getValue().getPreco()) {
                maiorPreco = entry.getValue().getPreco();
                livroMaisCaro = entry.getValue();
            }
        }
        return livroMaisCaro;
    }

    public Livro obterLivroMaisBarato() {
        Livro livroMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;

        for (Map.Entry<String, Livro> entry : livrariaMap.entrySet()) {
            if (menorPreco > entry.getValue().getPreco()) {
                menorPreco = entry.getValue().getPreco();
                livroMaisBarato = entry.getValue();
            }
        }
        return livroMaisBarato;
    }


    public static void main(String[] args) {

        LivrariaOnline lo = new LivrariaOnline();
        System.out.println("Livros ordenados por Autor: " + lo.exibirLivrosOrdenadosPorAutor());

        lo.adicionarLivro("8576082675", "Código Limpo", "Robert C Martin ", 84.93);
        lo.adicionarLivro("8536531452", "Algoritmos", "Manzano ", 53.99);
        lo.adicionarLivro("8575227149", "Python", "Manzano ", 87.98);
        lo.adicionarLivro("8536509260", "Java", "Manzano ", 104.91);
        System.out.println("Livros ordenados por Autor: " + lo.exibirLivrosOrdenadosPorAutor());
        System.out.println("Livros ordenados por Preço: " + lo.exibirLivrosOrdenadosPorPreco());

        lo.removerLivro("Algoritmos");
        System.out.println("Livros ordenados por Autor: " + lo.exibirLivrosOrdenadosPorAutor());

        System.out.println("Livros do autor Manzano: " + lo.pesquisarlivrosPorAutor("Manzano"));

        System.out.println("Livro mais caro: " + lo.obterLivroMaisCaro());
        System.out.println("Livro mais barato: " + lo.obterLivroMaisBarato());

    }
}
