package com.ads02.desafioADS.repository;

import com.ads02.desafioADS.config.Conexao;
import com.ads02.desafioADS.models.LivroModel;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LivroRepository {
    Conexao conexao = new Conexao();
    Connection connection = conexao.conectar();
    public List<LivroModel> consultar() throws SQLException {

        List<LivroModel> livroList = new ArrayList<>();

        String consulta = "SELECT * FROM tb_livro";

        Statement statement = connection.createStatement();
        ResultSet resultado = statement.executeQuery(consulta);

        try {
            while (resultado.next()) {
                LivroModel livro = new LivroModel();
                livro.setId(resultado.getLong("id_livro"));
                livro.setTitulo(resultado.getString("titulo"));
                livro.setAutor(resultado.getString("autor"));
                livro.setDataPublicacao(resultado.getDate("dt_publicacao"));
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

    public List<LivroModel> inserir() {
        
    }
}
