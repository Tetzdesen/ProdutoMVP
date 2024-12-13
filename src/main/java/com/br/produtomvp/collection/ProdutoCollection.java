package com.br.produtomvp.collection;

import com.br.produtomvp.model.Produto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import com.br.produtomvp.observer.IProdutoObservador;

/**
 *
 * @author tetzner
 */
public final class ProdutoCollection {

    private final List<Produto> produtos;
    private final List<IProdutoObservador> observadores;

    public ProdutoCollection() {
        this.produtos = new ArrayList<>();
        this.observadores = new ArrayList<>();
    }

    public List<Produto> getProdutos() {
        return Collections.unmodifiableList(produtos);
    }

    public void adicionarProduto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("Informe um produto válido");
        }

        this.produtos.add(produto);

        notificarObservadores();
    }

    public void removerProduto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("Informe um produto válido");
        }

        this.produtos.remove(produto);

        notificarObservadores();
    }

    public Optional<Produto> findProdutoByNome(String nome) {

        if (nome == null) {
            throw new IllegalArgumentException("Nome é nulo/invalido ");
        }

        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return Optional.of(produto);
            }
        }

        return Optional.empty();
    }

    public int obterQuantidadeDeProdutos() {
        return produtos.size();
    }

    public void adicionarObservador(IProdutoObservador observer) {
        if (observer == null) {
            throw new IllegalArgumentException(" Observer é nulo ");
        }
        observadores.add(observer);
    }

    public void removerObservador(IProdutoObservador observer) {
        if (observer == null) {
            throw new IllegalArgumentException(" Observer é nulo ");
        }
        observadores.remove(observer);
    }

    private void notificarObservadores() {
        for (IProdutoObservador observador : observadores) {
            observador.atualizar(this);
        }
    }

}
