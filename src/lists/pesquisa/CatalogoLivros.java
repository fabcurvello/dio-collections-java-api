package lists.pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {

    private List<Livro> livroList;

    public CatalogoLivros() {
        this.livroList = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        livroList.add(new Livro(titulo, autor, anoPublicacao));
    }

    public List<Livro> pesquisarporAutor(String autor) {
        List<Livro> livrosDoAutorPesquisado = new ArrayList<>();
        if (!livroList.isEmpty()) {
            for ( Livro l : livroList ) {
                if ( l.getAutor().equalsIgnoreCase(autor.trim())) {
                    livrosDoAutorPesquisado.add(l);
                }
            }
        }
        return livrosDoAutorPesquisado;
    }

    public List<Livro> pesquisarPorIntervaloAnos (int anoInicial, int anoFinal) {
        List<Livro> livrosIntervaloAnos = new ArrayList<>();
        if(!livroList.isEmpty()) {
            for ( Livro l : livroList ) {
                if (l.getAnoPublicacao() >= anoInicial && l.getAnoPublicacao() <= anoFinal) {
                    livrosIntervaloAnos.add(l);
                }
            }
        }
        return livrosIntervaloAnos;
    }

    public Livro pesquisarPorTitulo(String titulo) {
        Livro livroPorTitulo = null;
        if (!livroList.isEmpty()) {
            for (Livro l : livroList) {
                if (l.getTitulo().equalsIgnoreCase(titulo.trim())){
                    livroPorTitulo = l;
                    return livroPorTitulo;
                }
            }
        }
        return livroPorTitulo;
    }

    public static void main(String[] args) {
        CatalogoLivros catalogoLivros = new CatalogoLivros();
        catalogoLivros.adicionarLivro("Livro 1", "Autor 1", 2020);
        catalogoLivros.adicionarLivro("Livro 1", "Autor 2", 2021);
        catalogoLivros.adicionarLivro("Livro 2", "Autor 2", 2022);
        catalogoLivros.adicionarLivro("Livro 3", "Autor 3", 2023);
        catalogoLivros.adicionarLivro("Livro 4", "Autor 4", 2020);
        catalogoLivros.adicionarLivro("Livro 2", "Autor 4", 2005);

        System.out.println(catalogoLivros.pesquisarporAutor("Autor 2"));
        System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(2021, 2023));
        System.out.println(catalogoLivros.pesquisarPorTitulo("Livro 2  "));
    }


}
