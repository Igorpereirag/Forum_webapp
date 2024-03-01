package com.forum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TesteInsercaoUsuario {

    public static void main(String[] args) {
       
        String url = "jdbc:mysql://localhost:3306/mysql_db"; 
        String user = "admin";
        String password = "admin";

        String[][] usuarios = {
            {"usuario1", "usuario1@example.com", "Usuário 1", "senha1", "100"},
            {"usuario2", "usuario2@example.com", "Usuário 2", "senha2", "200"},
            {"usuario3", "usuario3@example.com", "Usuário 3", "senha3", "300"}
        };

       
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
          
            String sql = "INSERT INTO usuario (login, email, nome, senha, pontos) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

          
            for (String[] usuario : usuarios) {
                statement.setString(1, usuario[0]);
                statement.setString(2, usuario[1]);
                statement.setString(3, usuario[2]);
                statement.setString(4, usuario[3]);
                statement.setInt(5, Integer.parseInt(usuario[4]));
                statement.executeUpdate();
            }

            System.out.println("Usuários inseridos com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir usuários: " + e.getMessage());
        }
    }
}
