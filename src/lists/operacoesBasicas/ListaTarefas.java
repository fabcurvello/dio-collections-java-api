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
            if ( t.getDescricao().equalsIgnoreCase(descricao.trim()) ) {
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

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();
        System.out.println("Total de tarefas na lista: " + listaTarefas.obterNumeroTotalTarefas());

        listaTarefas.adicionarTarefa("Tarefa 1");
        listaTarefas.adicionarTarefa("Tarefa 2");
        listaTarefas.adicionarTarefa("Tarefa 1");
        listaTarefas.adicionarTarefa("Tarefa 3");
        System.out.println("Total de tarefas na lista: " + listaTarefas.obterNumeroTotalTarefas());

        listaTarefas.removerTarefa("   tarefa 1   ");
        System.out.println("Total de tarefas na lista: " + listaTarefas.obterNumeroTotalTarefas());

        System.out.println(listaTarefas.obterDescricoesTarefas());
    }
}
