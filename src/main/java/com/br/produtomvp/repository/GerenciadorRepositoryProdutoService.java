package com.br.produtomvp.repository;

import com.br.produtomvp.model.Produto;
import com.br.produtomvp.observer.IProdutoObservador;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author tetzner
 */
public class GerenciadorRepositoryProdutoService {

    private final ProdutoRepository produtoRepository;
    private final List<IProdutoObservador> observadores;

    public GerenciadorRepositoryProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
        this.observadores = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtoRepository.criarProduto(produto);
        notificarObservadores();
    }

    public List<Produto> buscarProdutos() {
        return produtoRepository.buscarTodosProdutos();
    }

    public void atualizarProduto(Produto produto) {
        produtoRepository.atualizarProduto(produto);
        notificarObservadores();
    }
   
    public Optional<Produto> buscarProdutoPorID(int id){
        return produtoRepository.buscarProdutoPorID(id);
    }
    
    public Optional<Produto> buscarProdutoPorNome(String nome){
        return produtoRepository.buscarProdutoPorNome(nome);
    }

    public void deletarProdutoPorID(int id) {
        produtoRepository.deletarProdutoPorID(id);
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
