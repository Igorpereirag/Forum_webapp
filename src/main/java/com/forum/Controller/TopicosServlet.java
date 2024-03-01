package com.forum.Controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forum.DAO.TopicoDAO;
import com.forum.Model.Topico;
@WebServlet("/topicos")
public class TopicosServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
        TopicoDAO topicoDAO = new TopicoDAO();
        List<Topico> topicos = topicoDAO.getAllTopicos();
        
        System.out.println("Número de tópicos encontrados: " + topicos.size()); 
        
        request.setAttribute("topicos", topicos);
        
        request.getRequestDispatcher("/view/Topicos.jsp").forward(request, response);
    }
    
}

