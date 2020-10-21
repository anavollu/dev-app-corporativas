package br.com.uff.verde.servlet;

import br.com.uff.verde.dao.DenunciaDAO;
import br.com.uff.verde.enumerate.StatusDenuncia;
import br.com.uff.verde.model.Denuncia;
import br.com.uff.verde.util.EnviaEmail;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Felipe Vila Chã
 */
public class AtualizaStatusDenuncia extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        Denuncia denuncia = new DenunciaDAO().getDenunciaById((Integer) session.getAttribute("denuncia_id"));
        String status = request.getParameter("status");
        Integer codStatus = 0;
        
        if(StatusDenuncia.EM_ANALISE.toString().equals(status)){
            codStatus = 1;
        } else if (StatusDenuncia.ENCAMINHADO.toString().equals(status)) {
            codStatus = 2;
        } else {
            codStatus = 3;
        }
        
        denuncia.setStatus(codStatus);
        
        boolean atualizou = new DenunciaDAO().updateDenuncia(denuncia);
        
        if(!atualizou) {
            session.setAttribute("status", false);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            new EnviaEmail(denuncia).denunciaAtualizada();
            
            session.setAttribute("status", true);
            request.getRequestDispatcher("/elements.html").forward(request, response);
        }
    }
}