package map.operacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {

    private Map<String, Integer> agendaContatosMap;

    public AgendaContatos() {
        agendaContatosMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone){
        agendaContatosMap.put(nome, telefone);
    }

    public void removerContato (String nome) {
        if (!agendaContatosMap.isEmpty()) {
            agendaContatosMap.remove(nome);
        }
    }

    public void exibirContatos() {
        System.out.println(agendaContatosMap);
    }

    public Integer pesquisarPorNome(String nome) {
        Integer numeroPorNome = null;
        if(!agendaContatosMap.isEmpty()) {
            numeroPorNome = agendaContatosMap.get(nome);
        }
        return numeroPorNome;
    }

    public static void main(String[] args) {

        AgendaContatos ac = new AgendaContatos();

        ac.adicionarContato("Fabricio", 1111);
        ac.adicionarContato("Fabricio C", 1112);
        ac.adicionarContato("Fabricio C", 1113); //nome repetido. Não vai adicionar.
        ac.adicionarContato("Fabricio Curvello", 1114);
        ac.adicionarContato("Flora", 1111);
        ac.exibirContatos();

        ac.removerContato("Flora");
        ac.exibirContatos();

        System.out.println(ac.pesquisarPorNome("Fabricio"));
    }
}
