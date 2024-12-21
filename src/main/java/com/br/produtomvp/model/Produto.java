package com.br.produtomvp.model;

/**
 *
 * @author tetzner
 */
public final class Produto {
    
    private int idProduto;
    private String nome;
    private double precoCusto;
    private double percentualLucro;
    private double precoVenda;

    public Produto(){
        
    }
    
    public Produto(String nome, double precoCusto, double percentualLucro) {
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.percentualLucro = percentualLucro;
        this.precoVenda = calcularPrecoVenda();
    }

    public int getIdProduto() {
        return idProduto;
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

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public void setPercentualLucro(double percentualLucro) {
        this.percentualLucro = percentualLucro;
    }
   
    private double calcularPrecoVenda() {
        return precoCusto + (precoCusto * percentualLucro / 100);
    }

    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", precoCusto=" + precoCusto + ", percentualLucro=" + percentualLucro + ", precoVenda=" + precoVenda + '}';
    }
}
