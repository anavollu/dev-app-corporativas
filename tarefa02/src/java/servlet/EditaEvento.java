package servlet;

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
        
        Evento novo = new Evento(id, nome, sigla, area, organizacao);
        
        boolean atualizou = new EventoDAO().updateEvento(novo);
        
        if(!atualizou){
            session.setAttribute("status", "erro");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            session.setAttribute("eventos", new EventoDAO().getEventos());
            session.setAttribute("status", "atualizado");
            request.getRequestDispatcher("/buscaEvento").forward(request, response);
        }
    }
}