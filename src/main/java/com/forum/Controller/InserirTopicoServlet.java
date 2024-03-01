package com.forum.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forum.DAO.TopicoDAO;
import com.forum.Model.Topico;

@WebServlet("/inserir-topico")
public class InserirTopicoServlet extends HttpServlet {

    private TopicoDAO topicoDAO;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
        String titulo = request.getParameter("titulo");
        String content = request.getParameter("content");
        String userId = request.getParameter("user_id");

        topicoDAO = new TopicoDAO(); 
        
        Topico topico = new Topico(titulo, content, userId);

        
        boolean sucesso = topicoDAO.adicionarTopico(topico);
        System.out.println(topico);

        if (sucesso) {
         
            response.sendRedirect(request.getContextPath() + "/view/Topicos.jsp");
            System.out.println(topico);
        } else {
         
            response.sendRedirect(request.getContextPath() + "/erro.jsp");
        }
    }
}
