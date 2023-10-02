package br.edu.ifrn.sc.pds.moviecrud.persistencia;

import br.edu.ifrn.sc.pds.moviecrud.dominio.Filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {

    public boolean inserirFilme(Filme filme) {
        boolean resultado = false;

        String query = "INSERT INTO filme(titulo,duracao,ano,avaliacao) VALUES (?,?,?,?);";

        Connection conexao = Conexao.conectar();

        try {
            PreparedStatement comando = conexao.prepareStatement(query);

            comando.setString(1, filme.getTitulo());
            comando.setInt(2, filme.getDuracao());
            comando.setInt(3, filme.getAno());
            comando.setDouble(4, filme.getAvaliacao());

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                resultado = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.desconectar();
        }

        return resultado;
    }

    public boolean alterarFilme(Filme filme) {
        boolean resultado = false;

        String query = "UPDATE filme SET titulo = ?, duracao = ?, ano = ?, avaliacao = ? where id = ?;";

        Connection conexao = Conexao.conectar();

        try {
            PreparedStatement comando = conexao.prepareStatement(query);

            comando.setString(1, filme.getTitulo());
            comando.setInt(2, filme.getDuracao());
            comando.setInt(3, filme.getAno());
            comando.setDouble(4, filme.getAvaliacao());
            comando.setInt(5, filme.getId());

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                resultado = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.desconectar();
        }

        return resultado;
    }

    public boolean removerFilme(int id) {
        boolean resultado = false;

        String query = "DELETE FROM filme WHERE id = ?";

        Connection conexao = Conexao.conectar();

        try {
            PreparedStatement comando = conexao.prepareStatement(query);

            comando.setInt(1, id);

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                resultado = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.desconectar();
        }

        return resultado;
    }
    
    public Filme buscarFilme(String titulo) {
        Filme filme = null;
        
        String query = "SELECT id, titulo, duracao, ano, avaliacao FROM filme WHERE titulo = ?;";
        
        Connection conexao = Conexao.conectar();
        
        try {
            PreparedStatement comando = conexao.prepareStatement(query);
            
            comando.setString(1, titulo);
            
            ResultSet resultSet = comando.executeQuery();
            
            if (resultSet.next()) {
                filme = new Filme();
                
                filme.setId(resultSet.getInt("id"));
                filme.setTitulo(resultSet.getString("titulo"));
                filme.setAno(resultSet.getInt("ano"));
                filme.setAvaliacao(resultSet.getDouble("avaliacao"));
                filme.setDuracao(resultSet.getInt("duracao"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.desconectar();
        }
        
        return filme;
    }
    
    public List<Filme> listarFilmes() {
        List<Filme> filmes = new ArrayList();
        
        String query = "SELECT id, titulo, duracao, ano, avaliacao FROM filme;";
        
        Connection conexao = Conexao.conectar();
        
        try {
            PreparedStatement comando = conexao.prepareStatement(query);
            
            ResultSet resultSet = comando.executeQuery();
            
            while (resultSet.next()) {
                Filme filme = new Filme();
                
                filme.setId(resultSet.getInt("id"));
                filme.setTitulo(resultSet.getString("titulo"));
                filme.setAno(resultSet.getInt("ano"));
                filme.setAvaliacao(resultSet.getDouble("avaliacao"));
                filme.setDuracao(resultSet.getInt("duracao"));
                
                filmes.add(filme);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Conexao.desconectar();
        }
        
        return filmes;
    }

}
