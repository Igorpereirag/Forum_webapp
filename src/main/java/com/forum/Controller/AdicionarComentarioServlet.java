package com.forum.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forum.DAO.ComentarioDAO;
import com.forum.Model.Comentario;

@WebServlet("/adicionar-comentario")
public class AdicionarComentarioServlet extends HttpServlet {

    private ComentarioDAO comentarioDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            comentarioDAO = new ComentarioDAO();
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String texto = request.getParameter("texto");
        String userId = request.getParameter("user_id");
        int idTopico = Integer.parseInt(request.getParameter("id_topico"));

        Comentario comentario = new Comentario( texto, userId, idTopico);

        comentarioDAO.adicionarComentario(comentario);

        
        response.sendRedirect(request.getContextPath() + "/exibe-topico?id=" + idTopico);
    }
}
