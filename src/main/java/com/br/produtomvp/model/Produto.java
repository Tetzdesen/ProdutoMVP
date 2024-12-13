package com.br.produtomvp.model;

/**
 *
 * @author tetzner
 */
public final class Produto {

    private final String nome;
    private final double precoCusto;
    private final double percentualLucro;
    private final double precoVenda;

    public Produto(String nome, double precoCusto, double percentualLucro) {
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.percentualLucro = percentualLucro;
        this.precoVenda = calcularPrecoVenda();
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public double getPercentualLucro() {
        return percentualLucro;
    }
    
    public double getPrecoVenda() {
        return precoVenda;
    }

    private double calcularPrecoVenda() {
        return precoCusto + (precoCusto * percentualLucro / 100);
    }

    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", precoCusto=" + precoCusto + ", percentualLucro=" + percentualLucro + ", precoVenda=" + precoVenda + '}';
    }
}
