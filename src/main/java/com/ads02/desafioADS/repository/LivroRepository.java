package com.ads02.desafioADS.repository;

import com.ads02.desafioADS.config.Conexao;
import com.ads02.desafioADS.models.LivroModel;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LivroRepository {

    public List<LivroModel> consultar() throws SQLException {
        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<LivroModel> livroList = new ArrayList<>();

        String consulta = "SELECT * FROM tb_livro";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery(consulta);

            while (resultado.next()) {
                LivroModel livro = new LivroModel();
                livro.setId(resultado.getLong("id"));
                livro.setTitulo(resultado.getString("titulo"));
                livro.setAutor(resultado.getString("autor"));
                livro.setDataPublicacao(resultado.getDate("data_publicacao"));
                livro.setEditora(resultado.getString("editora"));
                livroList.add(livro);
            }

        } catch (Exception e) {
            System.out.println("Não conseguiu consultar a tabela Livro");
        } finally {
            conexao.desconectar(connection);
        }
        return livroList;
    }

    public void inserir(LivroModel livro) throws SQLException {
        Connection connection = Conexao.conectar();
        String inserir = "INSERT INTO tb_livro (titulo, autor, data_publicacao, editora) VALUES (?, ?, ?, ?)";

            try {
                PreparedStatement statement = connection.prepareStatement(inserir);

                statement.setString(1, livro.getTitulo());
                statement.setString(2, livro.getAutor());
                statement.setDate(3, livro.getDataPublicacao());
                statement.setString(4, livro.getEditora());

                statement.execute();
            } catch (SQLException e) {
                System.out.println("Erro para salvar livros, verifique" + e.getMessage());
            } finally {
                Conexao.desconectar(connection);
            }
        }
    }

