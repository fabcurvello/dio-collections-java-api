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

    public static void main(String[] args) {
        ConjuntoConvidados cc = new ConjuntoConvidados();
        System.out.println("Existem " + cc.contarConvidados() + " dentro do Set de Convidados");

        cc.adicionarConvidado("Convidado 1", 1001);
        cc.adicionarConvidado("Convidado 2", 1002);
        cc.adicionarConvidado("Convidado 3", 1003);
        cc.adicionarConvidado("Convidado 4", 1004);
        cc.adicionarConvidado("Convidado 5", 1004); //codConvite repetido. Não será incluído

        System.out.println("Existem " + cc.contarConvidados() + " convidado(s) dentro do Set de Convidados");

        cc.removerConvidadoPorCodigoConvite(1002);
        System.out.println("Existem " + cc.contarConvidados() + " convidado(s) dentro do Set de Convidados");

        cc.exibirConvidados();
    }
}
