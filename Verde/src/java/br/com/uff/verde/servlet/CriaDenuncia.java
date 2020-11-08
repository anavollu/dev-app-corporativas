package br.com.uff.verde.servlet;

import br.com.uff.verde.dao.UsuarioDAO;
import br.com.uff.verde.dao.DenunciaDAO;
import br.com.uff.verde.dao.LocalDAO;
import br.com.uff.verde.model.Denuncia;
import br.com.uff.verde.model.Local;
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
        Local local = new LocalDAO().getLocalById(Integer.parseInt(request.getParameter("id_local")));
        String descricao = request.getParameter("descricao");
        
        Denuncia denuncia = new Denuncia(descricao, usuario);
        
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