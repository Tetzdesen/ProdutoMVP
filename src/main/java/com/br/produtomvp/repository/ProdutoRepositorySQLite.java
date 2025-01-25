package com.br.produtomvp.repository;

import com.br.produtomvp.model.Produto;
import com.br.produtomvp.singleton.SQLiteConnectionSingleton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author tetzner
 */
public class ProdutoRepositorySQLite implements ProdutoRepository {

    private Connection connection;

    public ProdutoRepositorySQLite() {
        try {
            connection = SQLiteConnectionSingleton.getInstance().getConnection();
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
    public Optional<Produto> buscarProdutoPorID(int id) {
        String sql = "SELECT * FROM produto WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Produto produto = new Produto();
                    produto.setIdProduto(rs.getInt("idProduto"));
                    produto.setNome(rs.getString("nome"));
                    produto.setPrecoCusto(rs.getDouble("precoCusto"));
                    produto.setPercentualLucro(rs.getDouble("percentualLucro"));
                    produto.setPrecoVenda(rs.getDouble("precoVenda"));
                    return Optional.of(produto);
                } else {
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar produto pelo ID" + e.getMessage());
        }

    }

    @Override
    public List<Produto> buscarTodosProdutos() {

        String sql = "SELECT * FROM produto";

        List<Produto> produtos = new ArrayList<>();

        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNome(rs.getString("nome"));
                produto.setPrecoCusto(rs.getDouble("precoCusto"));
                produto.setPercentualLucro(rs.getDouble("percentualLucro"));
                produto.setPrecoVenda(rs.getDouble("precoVenda"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar todos os produtos: " + e.getMessage());
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
        String sql = "DELETE FROM produto WHERE idProduto = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar produto: " + e.getMessage());
        }
    }

    @Override
    public Optional<Produto> buscarProdutoPorNome(String nome) {
        String sql = "SELECT * FROM produto WHERE nome = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(2, nome);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Produto produto = new Produto();
                    produto.setIdProduto(rs.getInt("idProduto"));
                    produto.setNome(rs.getString("nome"));
                    produto.setPrecoCusto(rs.getDouble("precoCusto"));
                    produto.setPercentualLucro(rs.getDouble("percentualLucro"));
                    produto.setPrecoVenda(rs.getDouble("precoVenda"));
                    return Optional.of(produto);
                } else {
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar produto pelo nome" + e.getMessage());
        }
    }

}
