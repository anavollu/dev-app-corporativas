package servlet;

import dao.EventoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Evento;

/**
 *
 * @author Felipe Vila Chã
 */
public class CriaEvento extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String nome = request.getParameter("nome");
        String sigla = request.getParameter("sigla");
        String area = request.getParameter("area");
        String organizacao = request.getParameter("organizacao");
        
        Evento eventoAtualizado = new Evento();
        eventoAtualizado.setNome(nome);
        eventoAtualizado.setSigla(sigla);
        eventoAtualizado.setArea(area);
        eventoAtualizado.setOrganizacao(organizacao);
        
        boolean inseriu = new EventoDAO().insereEvento(eventoAtualizado);
        
        if(!inseriu){
            session.setAttribute("status", "erro");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            session.setAttribute("eventos", new EventoDAO().getEventos());
            session.setAttribute("status", "inserido");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
