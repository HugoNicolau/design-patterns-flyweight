package padroesestruturais.flyweight;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComandaTest {

    @Test
    void deveRetornarItensComanda() {
        Comanda comanda = new Comanda(new ProdutoFactory());
        comanda.adicionarItem("X-Burguer", 25.0f, "sem cebola");
        comanda.adicionarItem("X-Burguer", 25.0f, "bem passado");
        comanda.adicionarItem("Suco", 6.0f, "sem gelo");

        List<String> saida = Arrays.asList(
                "ItemPedido{produto='X-Burguer', preco=25.0, observacao='sem cebola'}",
                "ItemPedido{produto='X-Burguer', preco=25.0, observacao='bem passado'}",
                "ItemPedido{produto='Suco', preco=6.0, observacao='sem gelo'}");

        assertEquals(saida, comanda.obterItens());
    }

    @Test
    void deveCompartilharProdutoEntreItens() {
        ProdutoFactory produtoFactory = new ProdutoFactory();
        Comanda comanda = new Comanda(produtoFactory);
        comanda.adicionarItem("X-Burguer", 25.0f, "sem cebola");
        comanda.adicionarItem("X-Burguer", 25.0f, "bem passado");
        comanda.adicionarItem("X-Burguer", 25.0f, "sem picles");
        comanda.adicionarItem("Suco", 6.0f, "sem gelo");

        assertEquals(2, produtoFactory.getTotalProdutos());
    }

    @Test
    void deveCompartilharProdutoEntreComandas() {
        ProdutoFactory produtoFactory = new ProdutoFactory();
        Comanda mesa1 = new Comanda(produtoFactory);
        Comanda mesa2 = new Comanda(produtoFactory);
        mesa1.adicionarItem("X-Burguer", 25.0f, "sem cebola");
        mesa1.adicionarItem("X-Burguer", 25.0f, "bem passado");
        mesa2.adicionarItem("X-Burguer", 25.0f, "sem picles");
        mesa2.adicionarItem("Suco", 6.0f, "sem gelo");

        assertEquals(2, produtoFactory.getTotalProdutos());
    }

    @Test
    void deveRetornarMesmaInstanciaProduto() {
        ProdutoFactory produtoFactory = new ProdutoFactory();

        assertSame(produtoFactory.getProduto("X-Burguer", 25.0f), produtoFactory.getProduto("X-Burguer", 25.0f));
    }

    @Test
    void deveCalcularTotalComanda() {
        Comanda comanda = new Comanda(new ProdutoFactory());
        comanda.adicionarItem("X-Burguer", 25.0f, "sem cebola");
        comanda.adicionarItem("X-Burguer", 25.0f, "bem passado");
        comanda.adicionarItem("X-Burguer", 25.0f, "sem picles");
        comanda.adicionarItem("Suco", 6.0f, "sem gelo");

        assertEquals(81.0f, comanda.calcularTotal(), 0.01f);
    }

}
