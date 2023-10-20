package com.ads02.desafioADS.repository;

import com.ads02.desafioADS.config.Conexao;
import com.ads02.desafioADS.models.LivroModel;
import com.ads02.desafioADS.models.UsuarioModel;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {

    public List<UsuarioModel> consultar() throws SQLException {
        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        List<UsuarioModel> usuarioList = new ArrayList<>();

        String consulta = "SELECT * FROM tb_usuario";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery(consulta);

            while (resultado.next()) {
                UsuarioModel usuario = new UsuarioModel();
                usuario.setId(resultado.getLong("id"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setCpf(resultado.getString("cpf"));
                usuario.setLogin(resultado.getString("login"));
                usuario.setSenha(resultado.getString("senha"));
                usuarioList.add(usuario);
            }
        } catch (Exception e) {
            System.out.println("Não conseguiu consultar a tabela usuario");
        } finally {
            conexao.desconectar(connection);
        }
        return usuarioList;
    }

    public void inserir(UsuarioModel usuario) throws SQLException {
        Connection connection = Conexao.conectar();
        String inserir = "INSERT INTO tb_usuario (nome, cpf, login, senha) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(inserir);

        statement.setString(1, usuario.getNome());
        statement.setString(2, usuario.getCpf());
        statement.setString(3, usuario.getLogin());
        statement.setString(4, usuario.getSenha());

        statement.execute();
        statement.close();

        Conexao.desconectar(connection);
    }
}
