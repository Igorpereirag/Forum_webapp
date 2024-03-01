package com.forum.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forum.Util.DatabaseUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);


        boolean isAuthenticated = authenticate(username, password);

        if (isAuthenticated) {
            response.sendRedirect(request.getContextPath() + "/topicos");
        } else {
            String errorMessage = "Usuário não encontrado. Verifique seu nome de usuário e senha.";
            request.setAttribute("error", errorMessage);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

   private boolean authenticate(String username, String password) {
      
      
        try {
            Connection connection = DatabaseUtil.getConnection();
            String sql = "SELECT COUNT(*) FROM usuarios WHERE login = ? AND senha = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

          
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count == 1; 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; 
}

}

