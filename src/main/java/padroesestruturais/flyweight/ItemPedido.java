package padroesestruturais.flyweight;

// Contexto: guarda o estado extrínseco (observação) e referencia o produto compartilhado.
public class ItemPedido {

    private Produto produto;
    private String observacao;

    public ItemPedido(Produto produto, String observacao) {
        this.produto = produto;
        this.observacao = observacao;
    }

    public Produto getProduto() {
        return produto;
    }

    public String obterItem() {
        return "ItemPedido{" +
                "produto='" + this.produto.getNome() + '\'' +
                ", preco=" + this.produto.getPreco() +
                ", observacao='" + this.observacao + '\'' +
                '}';
    }
}
