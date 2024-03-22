package com.forum.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.forum.Model.Ranking;
import com.forum.Model.Usuario;
import com.forum.Util.DatabaseUtil;

public class RankingDAO {
    private final Connection connection;

    public RankingDAO() throws SQLException {
        connection = DatabaseUtil.getConnection();
    }

    public List<Ranking> getRankingUsuarios() {
        List<Ranking> rankingUsuarios = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM usuarios ORDER BY pontos DESC");
            ResultSet resultSet = preparedStatement.executeQuery();
            int posicao = 1;
            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String login = resultSet.getString("login");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                int pontos = resultSet.getInt("pontos");

                Usuario usuario = new Usuario(nome, login, email, senha, pontos);
                Ranking ranking = new Ranking(usuario, pontos, posicao);
                rankingUsuarios.add(ranking);
                posicao++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rankingUsuarios;
    }
}
