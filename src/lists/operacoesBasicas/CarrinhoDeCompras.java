package lists.operacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> itensList;

    public CarrinhoDeCompras() {
        this.itensList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        this.itensList.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();
        for (Item i : itensList) {
            if ( i.getNomeItem().equalsIgnoreCase(nome.trim())) {
                itensParaRemover.add(i);
            }
        }
        itensList.removeAll(itensParaRemover);
    }

    public double calcularValorTotal() {
        double valorTotal = 0;
        for (Item i : itensList) {
            valorTotal += (i.getPreco() * i.getQuantidade());
        }
        return valorTotal;
    }

    public void exibirItens() {
        System.out.println(itensList);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionarItem("Cola-Cola", 12.90, 10);
        carrinhoDeCompras.adicionarItem("Miojo", 3.99, 5);
        carrinhoDeCompras.exibirItens();
        System.out.printf("Valor total: R$ %.2f \n", carrinhoDeCompras.calcularValorTotal());

        carrinhoDeCompras.removerItem(" miojo ");
        carrinhoDeCompras.exibirItens();
        System.out.printf("Valor total: R$ %.2f \n", carrinhoDeCompras.calcularValorTotal());
    }

}
