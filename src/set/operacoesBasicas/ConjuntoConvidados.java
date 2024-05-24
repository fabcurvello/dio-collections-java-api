package set.operacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {

    private Set<Convidado> convidadosSet;

    public ConjuntoConvidados() {
        this.convidadosSet = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codConvite) {
        convidadosSet.add(new Convidado(nome, codConvite));
    }

    public void removerConvidadoPorCodigoConvite(int codConvite) {
        Convidado convidadoParaRemover = null;
        for (Convidado c : convidadosSet) {
            if(c.getCodigoConvite() == codConvite) {
                convidadoParaRemover = c;
                break; //como não há elementos repetidos, não faz sentido continuar o for depois de encontrar o obj
            }
        }
        convidadosSet.remove(convidadoParaRemover);
    }

    public int contarConvidados() {
        return convidadosSet.size();
    }

    public void exibirConvidados(){
        System.out.println(convidadosSet);
    }
}
