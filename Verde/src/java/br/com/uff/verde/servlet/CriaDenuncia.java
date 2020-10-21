package br.com.uff.verde.servlet;

import br.com.uff.verde.dao.UsuarioDAO;
import br.com.uff.verde.dao.DenunciaDAO;
import br.com.uff.verde.model.Denuncia;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.com.uff.verde.model.Usuario;
import br.com.uff.verde.util.EnviaEmail;


/**
 *
 * @author Felipe Vila Chã
 */
public class CriaDenuncia extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        Usuario usuario = new UsuarioDAO().getUsuarioById(Integer.parseInt(request.getParameter("id_usuario")));
        String descricao = request.getParameter("descricao");
        String localidade = request.getParameter("localidade");
        
        Denuncia denuncia = new Denuncia(descricao, localidade, usuario);
        
        boolean inseriu = new DenunciaDAO().insereDenuncia(denuncia);
        
        if(!inseriu) {
            session.setAttribute("status", false);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {

            new EnviaEmail(denuncia).denunciaCriada();
            
            session.setAttribute("status", true);
            request.getRequestDispatcher("/elements.html").forward(request, response);
        }
    }
}