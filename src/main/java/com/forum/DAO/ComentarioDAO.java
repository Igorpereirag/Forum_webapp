package com.forum.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.forum.Model.Comentario;
import com.forum.Model.Usuario;
import com.forum.Util.DatabaseUtil;

public class ComentarioDAO {
    private final Connection connection;
    private final UsuarioDAO usuarioDAO;

    public ComentarioDAO() throws SQLException {
        connection = DatabaseUtil.getConnection();
        usuarioDAO = new UsuarioDAO();
    }

    public void adicionarComentario(Comentario comentario) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO comentarios(texto, id_usuario_criador, id_topico) VALUES (?, ?, ?)")) {
            preparedStatement.setString(1, comentario.getContent());
            preparedStatement.setString(2, comentario.getUser_id());
            preparedStatement.setInt(3, comentario.getIdTopico());
            preparedStatement.executeUpdate();
    
            
            Usuario usuario = usuarioDAO.getUsuarioById(comentario.getUser_id());
            if (usuario != null) {
               
                usuario.setPontos(usuario.getPontos() + 3);
                usuarioDAO.atualizarPontosUsuario(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    public List<Comentario> getComentarioByTopicId(int idTopico) {
        List<Comentario> comentarios = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM comentarios WHERE topic_id = ?")) {
            preparedStatement.setInt(1, idTopico);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Comentario comentario = new Comentario(resultSet.getString("content"), resultSet.getString("user_id"), idTopico);
                comentarios.add(comentario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comentarios;
    }
}
