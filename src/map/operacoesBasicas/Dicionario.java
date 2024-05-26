package map.operacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {

    private Map<String, String> dicionarioMap;

    public Dicionario() {
        dicionarioMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao) {
        dicionarioMap.put(palavra, definicao);
    }

    public void removerPalavra(String palavra) {
        if (!dicionarioMap.isEmpty()) {
            dicionarioMap.remove(palavra);
        }
    }

    public void exibirPalavras() {
        if (!dicionarioMap.isEmpty()) {
            System.out.println(dicionarioMap);
        } else {
            System.out.println("Nenhuma palavra cadastrada");
        }
    }

    public String pesquisarPorPalavra(String palavra) {
        String definicao = null;
        if (!dicionarioMap.isEmpty()) {
            definicao = dicionarioMap.get(palavra);
        }
        return definicao;
    }

    public static void main(String[] args) {

        Dicionario d = new Dicionario();
        d.exibirPalavras();

        d.adicionarPalavra("correr", "locomover-se a pé rapidamente");
        d.adicionarPalavra("gritar", "falar muito alto");
        d.adicionarPalavra("mastigar", "triturar os alimentos com os dentes");
        d.exibirPalavras();

        System.out.println(d.pesquisarPorPalavra("correr"));

        d.removerPalavra("correr");
        d.exibirPalavras();
    }

}
