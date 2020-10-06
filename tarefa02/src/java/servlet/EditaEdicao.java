package servlet;

import dao.EdicaoDAO;
import dao.EventoDAO;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class EditaEdicao extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        Integer id = Integer.parseInt(request.getParameter("id"));
        Evento evento = (Evento) session.getAttribute("evento");
        Integer numero = Integer.parseInt(request.getParameter("numero"));
        Integer ano = Integer.parseInt(request.getParameter("ano"));
        String inputDataInicio = request.getParameter("data_inicio");
        String inputDataFim = request.getParameter("data_fim");
        String cidade = request.getParameter("cidade");
        String pais = request.getParameter("pais");
        
        
        Date dataInicio = new Date();
        Date dataFim = new Date();
        
        try {
            dataInicio = new SimpleDateFormat("yyyy-MM-dd").parse(inputDataInicio);
            dataFim = new SimpleDateFormat("yyyy-MM-dd").parse(inputDataFim);
        } catch (ParseException ex) {
            Logger.getLogger(EditaEdicao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Edicao edicaoNova = new Edicao(id, numero, ano, dataInicio, dataFim, cidade, pais, evento);
        
        boolean atualizou = new EdicaoDAO().updateEdicao(edicaoNova);
        
        if(!atualizou){
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            session.setAttribute("eventos", new EventoDAO().getEventos());
            response.setIntHeader("Refresh", 1);
            response.sendRedirect("http://localhost:8080/marcai/listaEvento.jsp?id=" + evento.getIdEvento());
        }
    }
}