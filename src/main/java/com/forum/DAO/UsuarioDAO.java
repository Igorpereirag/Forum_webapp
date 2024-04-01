package com.forum.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.forum.Model.Usuario;
import com.forum.Util.DatabaseUtil;

public class UsuarioDAO {
    private final Connection connection;

    public UsuarioDAO() throws SQLException {
        connection = DatabaseUtil.getConnection();
    }

    public boolean adicionarUsuario(Usuario usuario) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO usuarios(nome, login, email, senha, pontos) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getLogin());
            preparedStatement.setString(3, usuario.getEmail());
            preparedStatement.setString(4, usuario.getSenha());
            preparedStatement.setInt(5, usuario.getPontos());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0; 
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }

    public List<Usuario> getUsuariosOrdenadosPorPontuacao() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM usuarios ORDER BY pontos DESC");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String login = resultSet.getString("login");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                int pontos = resultSet.getInt("pontos");
                Usuario usuario = new Usuario(nome, login, email, senha, pontos);
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public Usuario getUsuarioById(String id) {
        Usuario usuario = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM usuarios WHERE login = ?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String login = resultSet.getString("login");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                int pontos = resultSet.getInt("pontos");
                usuario = new Usuario(nome, login, email, senha, pontos);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public void atualizarPontosUsuario(Usuario usuario) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE usuarios SET pontos = ? WHERE login = ?");
            preparedStatement.setInt(1, usuario.getPontos());
            preparedStatement.setString(2, usuario.getLogin());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
