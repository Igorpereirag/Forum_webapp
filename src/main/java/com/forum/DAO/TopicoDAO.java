package com.forum.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.forum.Model.Topico;
import com.forum.Model.Usuario;
import com.forum.Util.DatabaseUtil;

public class TopicoDAO {
    
 public boolean adicionarTopico(Topico topico, Usuario usuario) {
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO topicos(titulo, content, user_id) VALUES (?, ?, ?)")) {
            preparedStatement.setString(1, topico.getTitulo());
            preparedStatement.setString(2, topico.getContent());
            preparedStatement.setString(3, topico.getUserId());
            
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                usuario.setPontos(usuario.getPontos() + 10);
                atualizarPontosUsuario(usuario); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

   private void atualizarPontosUsuario(Usuario usuario) {
    try (Connection connection = DatabaseUtil.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("UPDATE usuarios SET pontos = ? WHERE user_id = ?")) {
        preparedStatement.setInt(1, usuario.getPontos());
        preparedStatement.setString(2, usuario.getLogin());
        
        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    public List<Topico> getAllTopicos() {
        List<Topico> topicos = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM topicos");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String titulo = resultSet.getString("titulo");
                String content = resultSet.getString("content");
                String userId = resultSet.getString("user_id");
                
                Topico topico = new Topico(titulo, content, userId);
                topicos.add(topico);
            }
            return topicos; 
        } catch (SQLException e) {
            e.printStackTrace();
            
            return topicos;
        }
    }

    public Topico getTopicoById(int id) {
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM topicos WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String titulo = resultSet.getString("titulo");
                String content = resultSet.getString("content");
                String userId = resultSet.getString("user_id");

                Topico topico = new Topico(titulo, content, userId);
                return topico;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
