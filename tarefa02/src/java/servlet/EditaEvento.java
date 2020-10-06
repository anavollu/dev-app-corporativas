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
public class EditaEvento extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        Integer id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String sigla = request.getParameter("sigla");
        String area = request.getParameter("area");
        String organizacao = request.getParameter("organizacao");
        
        Evento evento = new Evento(id, nome, sigla, area, organizacao);
        
        boolean atualizou = new EventoDAO().updateEvento(evento);
        
        if(!atualizou){
            session.setAttribute("status", "erro");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            session.setAttribute("eventos", new EventoDAO().getEventos());
            response.setIntHeader("Refresh", 1);
            response.sendRedirect("http://localhost:8080/marcai/listaEvento.jsp?id=" + evento.getIdEvento());
        }
    }
}