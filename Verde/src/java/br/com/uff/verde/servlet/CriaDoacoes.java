package br.com.uff.verde.servlet;

import br.com.uff.verde.dao.UsuarioDAO;
import br.com.uff.verde.dao.DoacoesDAO;
import br.com.uff.verde.model.Doacoes;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.com.uff.verde.model.Usuario;
import br.com.uff.verde.util.EnviaEmail;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Felipe Vila Chã
 */
public class CriaDoacoes extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        Usuario usuario = new UsuarioDAO().getUsuarioById((Integer) session.getAttribute("id_usuario"));
        Double valor = Double.parseDouble(request.getParameter("valor"));
        
        Date data = new Date();
        try {
            data = new SimpleDateFormat("yyyy-MM-dd").parse(data.toString());
        } catch (ParseException ex) {
            Logger.getLogger(CriaDoacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Doacoes doacoes = new Doacoes(valor, data, usuario);
        
        boolean inseriu = new DoacoesDAO().insereDoacoes(doacoes);
        
        if(!inseriu) {
            session.setAttribute("status", false);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {

            /*new EnviaEmail(doacoes).doacaoRealizada();*/
            
            session.setAttribute("status", true);
            request.getRequestDispatcher("/elements.html").forward(request, response);
        }
    }
}