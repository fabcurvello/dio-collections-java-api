package set.operacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {

    private Set<String> palavrasUnicasSet ;

    public ConjuntoPalavrasUnicas() {
        palavrasUnicasSet = new HashSet<>();
    }

    public void adicionarPalavra(String palavra) {
        palavrasUnicasSet.add(palavra);
    }

    public void removerPalavra(String palavra) {
        for ( String p : palavrasUnicasSet ) {
            if (p.equalsIgnoreCase(palavra.trim())) {
                palavrasUnicasSet.remove(p);
                break;
            }
        }
    }

    public void verificarPalavra(String palavra) {
        boolean palavraEncontrada = false;
        for ( String p : palavrasUnicasSet ) {
            if (p.equalsIgnoreCase(palavra.trim())) {
                palavraEncontrada = true;
                break;
            }
        }
        if ( palavraEncontrada ) {
            System.out.println( "Palavra '" + palavra.trim() + "' foi encontrada no Set de Palavras Únicas.");
        } else {
            System.out.println( "Palavra '" + palavra.trim() + "' NÃO foi encontrada no Set de Palavras Únicas.");
        }
    }

    public void exibirPalavrasUnicas() {
        System.out.println(palavrasUnicasSet);
    }

    public void contarPalavras() {
        System.out.println("Total de " + palavrasUnicasSet.size() + " palavras únicas");
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas cpu = new ConjuntoPalavrasUnicas();
        cpu.adicionarPalavra("Laranja");
        cpu.adicionarPalavra("Banana");
        cpu.adicionarPalavra("Mamão");
        cpu.adicionarPalavra("Uva");
        cpu.adicionarPalavra("Banana"); // repetida. não será incluída

        cpu.exibirPalavrasUnicas();
        cpu.contarPalavras();

        cpu.removerPalavra("uva ");
        cpu.contarPalavras();

        cpu.verificarPalavra("mamão ");
        cpu.verificarPalavra(" pêra");
    }
}
