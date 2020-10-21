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
public class InfosUser extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Integer id = (Integer) session.getAttribute("id_user");
        Usuario usuario = new UsuarioDAO().getUsuarioById(id);
        
        session.setAttribute("usuario", usuario);
    }
}