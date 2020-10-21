package br.com.uff.verde.servlet;

import br.com.uff.verde.dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.com.uff.verde.model.Usuario;

/**
 *
 * @author Felipe Vila Chã
 */
public class RealizaLogin extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String username = request.getParameter("username");
        String senha = request.getParameter("senha");
        
        Usuario usuario = new UsuarioDAO().getUsuarioByNome(username);
        
        if(usuario.getId().equals(0) || !usuario.getSenha().equals(senha)){
            session.setAttribute("status", false);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            session.setAttribute("status", true);
            request.getRequestDispatcher("/elements.html").forward(request, response);
        }
    }
}