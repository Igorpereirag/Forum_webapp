package com.forum.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forum.DAO.TopicoDAO;
import com.forum.Model.Topico;

@WebServlet("/exibeTopico")
public class ExibeTopicoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam != null) {
            int idTopico = Integer.parseInt(idParam);
            TopicoDAO topicoDAO = new TopicoDAO();
            Topico topico = topicoDAO.getTopicoById(idTopico);
            if (topico != null) {
                request.setAttribute("topico", topico);
                request.getRequestDispatcher("/view/ExibeTopico.jsp").forward(request, response);
            } else {
              
                response.sendRedirect(request.getContextPath() + "/erro.jsp");
            }
        } 
    }
}
