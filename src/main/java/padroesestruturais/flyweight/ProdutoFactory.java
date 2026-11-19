package padroesestruturais.flyweight;

import java.util.HashMap;
import java.util.Map;

// Fábrica de flyweights: devolve o produto já existente ou cria um novo.
public class ProdutoFactory {

    private Map<String, Produto> produtos = new HashMap<>();

    public Produto getProduto(String nome, float preco) {
        Produto produto = produtos.get(nome);
        if (produto == null) {
            produto = new Produto(nome, preco);
            produtos.put(nome, produto);
        }
        return produto;
    }

    public int getTotalProdutos() {
        return produtos.size();
    }

}
