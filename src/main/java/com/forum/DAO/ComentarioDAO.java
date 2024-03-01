package com.forum.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.forum.Model.Comentario;
import com.forum.Util.DatabaseUtil;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class ComentarioDAO {
    private final Connection connection;

    public ComentarioDAO() throws SQLException {
        connection = DatabaseUtil.getConnection();
    }

   
    public void adicionarComentario(Comentario comentario) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO comentarios(texto, id_usuario_criador, id_topico) VALUES (?, ?, ?)");
            preparedStatement.setString(1, comentario.getContent());
            preparedStatement.setString(2, comentario.getUser_id());
            preparedStatement.setInt(3, comentario.getIdTopico());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   public List<Comentario> getComentarioByTopicId(int idTopico) {
      List<Comentario> comentarios = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM comentarios WHERE topic_id = ?");
            preparedStatement.setInt(1, idTopico);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Comentario comentario = new Comentario(idTopico, resultSet.getString("content"), resultSet.getString("user_id"), resultSet.getInt("topic_id"));
                comentarios.add(comentario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comentarios;
    }
      
    
}
