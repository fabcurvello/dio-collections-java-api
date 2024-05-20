package lists.operacoesBasicas;

import java.util.ArrayList;
import java.util.List;

// ENUNCIADO EM https://github.com/cami-la/collections-java-api-2023/tree/master/src/main/java/list
public class ListaTarefas {

    private List<Tarefa> tarefasList;

    public ListaTarefas() {
        this.tarefasList = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        tarefasList.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        List<Tarefa> tarefasParaRemover = new ArrayList<>();
        for (Tarefa t : tarefasList) {
            if ( t.getDescricao().equalsIgnoreCase(descricao) ) {
                tarefasParaRemover.add(t);
            }
        }
        tarefasList.removeAll(tarefasParaRemover);
    }

    public int obterNumeroTotalTarefas() {
        return tarefasList.size();
    }

    public List obterDescricoesTarefas() {
        return tarefasList;
    }
}
