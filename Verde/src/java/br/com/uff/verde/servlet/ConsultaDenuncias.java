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
import java.util.List;

/**
 *
 * @author Felipe Vila Chã
 */
public class ConsultaDenuncias extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        Usuario usuario = new UsuarioDAO().getUsuarioById((Integer) session.getAttribute("id_usuario"));
        
        List<Denuncia> denuncias = new DenunciaDAO().getDenuncias();
        
        for(Denuncia denuncia : denuncias){
            if(!denuncia.getUsuario().getId().equals(usuario.getId())){
                denuncias.remove(denuncia);
            }
        }
        
        session.setAttribute("denuncias", denuncias);
    }
}