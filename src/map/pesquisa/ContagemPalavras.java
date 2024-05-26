package map.pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {

    private Map<String, Integer> contagemPalavrasMap;

    public ContagemPalavras() {
        contagemPalavrasMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem) {
        contagemPalavrasMap.put(palavra, contagem);
    }

    public void removerPalavra(String palavra) {
        if(!contagemPalavrasMap.isEmpty()) {
            Integer contagem = contagemPalavrasMap.get(palavra);
            if (contagem > 1) {
                this.adicionarPalavra(palavra, contagem-1);
            } else {
                contagemPalavrasMap.remove(palavra);
            }
        }
    }

    public void exibirContagemPalavras() {
        System.out.println(this.contagemPalavrasMap);
    }

    public String encontrarPalavraMaisFrequente() {
        String palavraMaisFrequente = null;
        Integer contagemMaior = Integer.MIN_VALUE;
        if(!contagemPalavrasMap.isEmpty()) {
            for ( Map.Entry<String, Integer> entry : contagemPalavrasMap.entrySet()) {
                if ( entry.getValue() > contagemMaior ) {
                    palavraMaisFrequente = entry.getKey();
                    contagemMaior = entry.getValue();
                }
            }
        }
        return palavraMaisFrequente;
    }

    public static void main(String[] args) {

        ContagemPalavras cp = new ContagemPalavras();
        cp.exibirContagemPalavras();

        cp.adicionarPalavra("casa", 5);
        cp.adicionarPalavra("joelho", 17);
        cp.adicionarPalavra("olho", 1);
        cp.adicionarPalavra("disco", 2);
        cp.adicionarPalavra("telefone", 3);
        cp.exibirContagemPalavras();

        cp.removerPalavra("disco");
        cp.exibirContagemPalavras();

        cp.removerPalavra("olho");
        cp.exibirContagemPalavras();

        System.out.println("Palavra mais frequente: " + cp.encontrarPalavraMaisFrequente());
    }
}
