package com.forum.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forum.DAO.RankingDAO;
import com.forum.Model.Ranking;

@WebServlet("/ranking")
public class RankingServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RankingDAO rankingDAO;
        try {
            rankingDAO = new RankingDAO();
            List<Ranking> rankingUsuarios = rankingDAO.getRankingUsuarios();
            request.setAttribute("rankingUsuarios", rankingUsuarios);
            request.getRequestDispatcher("/view/Ranking.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
          
            response.sendRedirect(request.getContextPath() + "/view/error.jsp?message=database_error");
        }
    }
}
