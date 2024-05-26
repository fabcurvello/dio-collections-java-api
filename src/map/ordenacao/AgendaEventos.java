package map.ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {

    private Map<LocalDate, Evento> agendaEventosMap;

    public AgendaEventos() {
        agendaEventosMap = new HashMap<>();
    }

    public void adicionarEvento (LocalDate data, String nome, String atracao) {
        agendaEventosMap.put(data, new Evento(nome, atracao));
    }

    public void exibirAgenda() {

        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(agendaEventosMap); //TreeMap vai ordenar
        if (!agendaEventosMap.isEmpty()) {
            System.out.println("Eventos cadastrados na agenda:");
            for (Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()) {
                LocalDate dataEvento = entry.getKey();
                Evento evento = entry.getValue();
                System.out.println("Data: " + dataEvento + " -> Evento: " + evento.getNomeEvento() + " -> Atração: " + evento.getNomeAtracao());
            }
        } else {
            System.out.println("Nenhum evento cadastrado");
        }
    }

    public void obterProximosEventos() {
        LocalDate dataAtual = LocalDate.now();
        Map<LocalDate, Evento> proximosEventosTreeMap = new TreeMap<>();
        for (Map.Entry<LocalDate, Evento> entry : agendaEventosMap.entrySet()) {
            if ( entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)) {
                proximosEventosTreeMap.put(entry.getKey(), entry.getValue());
            }
        }
        if (!proximosEventosTreeMap.isEmpty()) {
            System.out.println("Próximos eventos cadastrados na agenda:");
            for (Map.Entry<LocalDate, Evento> entry : proximosEventosTreeMap.entrySet()) {
                LocalDate dataEvento = entry.getKey();
                Evento evento = entry.getValue();
                System.out.println("Data: " + dataEvento + " -> Evento: " + evento.getNomeEvento() + " -> Atração: " + evento.getNomeAtracao());
            }
        } else {
            System.out.println("Não há eventos futuros na agenda.");
        }
    }

    public static void main(String[] args) {
        AgendaEventos ae = new AgendaEventos();
        ae.exibirAgenda();

        ae.adicionarEvento(LocalDate.of(2022, Month.JULY, 15), "Show Rock BR", "Paralamas do Sucesso");
        ae.adicionarEvento(LocalDate.of(2022, 7, 9), "Show Pop BR", "Jota Quest");
        ae.adicionarEvento(LocalDate.of(2024, 5, 26), "Estudo Java", "Java Collections");
        ae.adicionarEvento(LocalDate.of(2024, 5,27), "Corrigir Provas", "Provas GQS A1");
        ae.adicionarEvento(LocalDate.of(2024, 5, 28), "Elaborar Provas", "Provas PSC A3 parte 2");
        ae.exibirAgenda();

        ae.obterProximosEventos();
    }

}
