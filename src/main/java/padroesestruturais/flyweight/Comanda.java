package padroesestruturais.flyweight;

import java.util.ArrayList;
import java.util.List;

public class Comanda {

    private ProdutoFactory produtoFactory;
    private List<ItemPedido> itens = new ArrayList<>();

    public Comanda(ProdutoFactory produtoFactory) {
        this.produtoFactory = produtoFactory;
    }

    public void adicionarItem(String nomeProduto, float preco, String observacao) {
        Produto produto = this.produtoFactory.getProduto(nomeProduto, preco);
        ItemPedido item = new ItemPedido(produto, observacao);
        itens.add(item);
    }

    public List<String> obterItens() {
        List<String> saida = new ArrayList<String>();
        for (ItemPedido item : this.itens) {
            saida.add(item.obterItem());
        }
        return saida;
    }

    public float calcularTotal() {
        float total = 0;
        for (ItemPedido item : this.itens) {
            total += item.getProduto().getPreco();
        }
        return total;
    }

}
