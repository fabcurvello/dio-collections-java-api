package set.pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {

    private Set<Contato> contatosSet;

    public AgendaContatos () {
        contatosSet = new HashSet<>();
    }

    public void adicionarContato(String nome, String telefone) {
        contatosSet.add(new Contato(nome,telefone));
    }

    public void exibirContatos() {
        System.out.println(contatosSet);
    }

    public Set<Contato> pesquisarPorNome(String nome) {
        Set<Contato> contatosPesquisados = new HashSet<>();
        for ( Contato c : contatosSet ) {
            if ( c.getNome().startsWith(nome.trim())){
                contatosPesquisados.add(c);
            }
        }
        return contatosPesquisados;
    }

    public Contato atualizarNumeroContato(String nome, String novoTelefone) {
        Contato contatoAtualizado = null;
        for ( Contato c : contatosSet ) {
            if ( c.getNome().equalsIgnoreCase(nome.trim())){
                c.setTelefone(novoTelefone);
                contatoAtualizado = c;
                break;
            }
        }
        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContatos ac = new AgendaContatos();

        ac.exibirContatos();

        ac.adicionarContato("Fabricio", "(21) 11111-1111");
        ac.adicionarContato("Fabricio C", "(21) 11111-1112");
        ac.adicionarContato("Fabricio C", "(21) 11111-1113");
        ac.adicionarContato("Fabricio Curvello", "(21) 11111-1114");
        ac.adicionarContato("Flora", "(21) 11111-1111");

        ac.exibirContatos();

        System.out.println(ac.pesquisarPorNome("Fabricio "));

        ac.exibirContatos();
        System.out.println("Contato atualizado: " + ac.atualizarNumeroContato("Flora", "(22) 22222-2222"));
        ac.exibirContatos();
    }
}
