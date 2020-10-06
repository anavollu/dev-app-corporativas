package servlet;

import dao.EdicaoDAO;
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
public class RemoveEdicao extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Evento evento = ((Evento) session.getAttribute("evento"));
        Integer id = Integer.parseInt(request.getParameter("id"));
        boolean removeu = new EdicaoDAO().removeEdicao(id);
        
        if(!removeu){
            session.setAttribute("status", "erro");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            session.setAttribute("status", "removido");
            session.setAttribute("evento", evento);
            response.setIntHeader("Refresh", 1);
            response.sendRedirect("http://localhost:8080/marcai/listaEvento.jsp?id=" + evento.getIdEvento());
        }
    }
}
