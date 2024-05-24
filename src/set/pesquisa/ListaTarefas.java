package set.pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {

    private Set<Tarefa> tarefasSet;

    public ListaTarefas() {
        tarefasSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao){
        tarefasSet.add(new Tarefa(descricao, false));
    }

    public void removerTarefa(String descricao) {
        Tarefa tarefaRemover = null;
        for ( Tarefa t : tarefasSet ) {
            if ( t.getDescricao().equalsIgnoreCase(descricao.trim())) {
                tarefaRemover = t;
                break;
            }
        }
        tarefasSet.remove(tarefaRemover);
    }

    public void exibirTarefas() {
        System.out.println(tarefasSet);
    }

    public String contarTarefas() {
        return "Total de tarefas da lista: " + tarefasSet.size();
    }

    public Set<Tarefa> obterTarefasConcluidas() {
        Set<Tarefa> tarefasConcluidasSet = new HashSet<>();
        for ( Tarefa t : tarefasSet ) {
            if (t.isStatus()) {
                tarefasConcluidasSet.add(t);
            }
        }
        return tarefasConcluidasSet;
    }

    public Set<Tarefa> obterTarefasPendentes() {
        Set<Tarefa> tarefasPendentesSet = new HashSet<>();
        for ( Tarefa t : tarefasSet ) {
            if (!t.isStatus()) {
                tarefasPendentesSet.add(t);
            }
        }
        return tarefasPendentesSet;
    }

    public void marcarTarefaConcluida(String descricao) {
        for ( Tarefa t : tarefasSet ) {
            if (t.getDescricao().equalsIgnoreCase(descricao.trim())) {
                t.setStatus(true);
                break;
            }
        }
    }

    public void marcarTarefaPendente(String descricao) {
        for ( Tarefa t : tarefasSet ) {
            if (t.getDescricao().equalsIgnoreCase(descricao.trim())) {
                t.setStatus(false);
                break;
            }
        }
    }

    public void limparListaTarefas() {
        tarefasSet.clear();
    }

    public static void main(String[] args) {
        ListaTarefas lt = new ListaTarefas();

        lt.exibirTarefas();

        lt.adicionarTarefa("Tarefa 1");
        lt.adicionarTarefa("Tarefa 2");
        lt.adicionarTarefa("Tarefa 3");
        lt.adicionarTarefa("Tarefa 3"); //Repetida. Não adiciona.
        lt.adicionarTarefa("Tarefa 4");
        lt.adicionarTarefa("Tarefa 5");

        lt.exibirTarefas();
        System.out.println(lt.contarTarefas());

        lt.marcarTarefaConcluida("Tarefa 3 ");
        lt.marcarTarefaConcluida("Tarefa 5 ");
        lt.marcarTarefaConcluida("Tarefa 1 ");
        lt.exibirTarefas();

        lt.marcarTarefaPendente("Tarefa 5 ");
        lt.exibirTarefas();

        System.out.println("TAREFAS PENDENTES: " + lt.obterTarefasPendentes());
        System.out.println("TAREFAS CONCLUÍDAS: " + lt.obterTarefasConcluidas());

        lt.limparListaTarefas();
        lt.exibirTarefas();


    }

}
