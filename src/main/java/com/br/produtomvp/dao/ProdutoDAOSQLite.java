package com.br.produtomvp.dao;

import com.br.produtomvp.model.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tetzner
 */
public class ProdutoDAOSQLite implements ProdutoDAO {

    private Connection connection;

    public ProdutoDAOSQLite() {
        try {
            connection = DriverManager.getConnection("");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void criarProduto(Produto produto) {

        String sql = "INSERT INTO produto (nome, precoCusto, percentualLucro, precoVenda) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
           
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPrecoCusto());
            stmt.setDouble(3, produto.getPercentualLucro());
            stmt.setDouble(4, produto.getPrecoVenda());

            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    produto.setIdProduto(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falha ao inserir produto, nenhum ID obtido.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir produto" + e.getMessage());
        }

    }

    @Override
    public Produto lerProdutoPorID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Produto> lerTodosProdutos() {
        
        String sql = "SELECT * FROM produto";
        
        List<Produto> produtos = new ArrayList<>();
        
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setPrecoCusto(rs.getDouble("precoCusto"));
                produto.setPercentualLucro(rs.getDouble("percentualLucro"));
                
                produtos.add(produto);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar todos os clientes: " + e.getMessage());
        }
        return produtos;

    }

    @Override
    public void atualizarProduto(Produto produto) {
        String sql = "UPDATE produto SET nome = ?, precoCusto = ?, percentualLucro = ?, precoVenda = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPrecoCusto());
            stmt.setDouble(3, produto.getPercentualLucro());
            stmt.setDouble(4, produto.getPrecoVenda());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar produto: " + e.getMessage());
        }
    }

    @Override
    public void deletarProdutoPorID(int id) {
        String sql = "DELETE FROM produto WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar produto: " + e.getMessage());
        }
    }

}
