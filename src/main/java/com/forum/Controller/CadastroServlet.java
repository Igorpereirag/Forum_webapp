    package com.forum.Controller;

    import java.io.IOException;
    import java.sql.SQLException;

    import javax.servlet.ServletException;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;

    import com.forum.DAO.UsuarioDAO;
    import com.forum.Model.Usuario;

    @WebServlet("/cadastro")
    public class CadastroServlet extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String name = request.getParameter("name");
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            System.out.println("Name: " + name);
            System.out.println("Username: " + username);
            System.out.println("Email: " + email);
            System.out.println("Password: " + password);

            try {
              
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                boolean success = usuarioDAO.adicionarUsuario(new Usuario(name, username, email, password, 0));

                if (success) {
               
                    response.sendRedirect(request.getContextPath() + "/index.jsp");
                } else {
                   
                    response.sendRedirect(request.getContextPath() + "/view/Cadastro.jsp");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                
                response.sendRedirect(request.getContextPath() + "/view/error.jsp?message=database_error");
            }
        }
    }
