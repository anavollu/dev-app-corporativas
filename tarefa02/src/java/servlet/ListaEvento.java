package servlet;

import dao.EdicaoDAO;
import dao.EventoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Edicao;
import model.Evento;

/**
 *
 * @author Felipe Vila Chã
 */
public class ListaEvento extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        try {
            
            Evento evento = new Evento();
            
            if(request.getQueryString().contains("nome=")){
                String nome = request.getQueryString().replace("nome=", "");
                evento = new EventoDAO().getEventoByNome(nome);
            } else {
                Integer id = Integer.parseInt(request.getQueryString().replace("id=", ""));
                evento = new EventoDAO().getEventoById(id);
            }
            
            List<Edicao> edicoes = new EdicaoDAO().getEdicoesDeEvento(evento);

            session.setAttribute("evento", evento);
            session.setAttribute("edicoes", edicoes);
            
        } catch (Exception ex) {
            session.setAttribute("erro","busca");
            request.getRequestDispatcher("/index.jsp?erro").forward(request, response);
        }
        
    }
}