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
public class RemoveEvento extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Integer id = Integer.parseInt(request.getParameter("id"));

        boolean removeu = new EventoDAO().removeEvento(id);
        
        if(!removeu){
            session.setAttribute("status", "erro");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            session.setAttribute("eventos", new EventoDAO().getEventos());
            session.setAttribute("status", "removido");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
