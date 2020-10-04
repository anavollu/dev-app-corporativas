package servlet;

import dao.EventoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Evento;

/**
 *request.getQueryString();
 * @author Felipe Vila Chã
 */
public class BuscaEvento extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        List<Evento> eventos = new EventoDAO().getEventos();
        session.setAttribute("eventos", eventos);
    }
}