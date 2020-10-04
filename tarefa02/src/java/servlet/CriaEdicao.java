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
public class CriaEdicao extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        Evento evento = (Evento) session.getAttribute("evento");
        int numero = Integer.parseInt(request.getParameter("numero"));
        int ano = Integer.parseInt(request.getParameter("ano"));
        String cidade = request.getParameter("cidade");
        String pais = request.getParameter("pais");
        String inputDataInicio = request.getParameter("data_inicio");
        String inputDataFim = request.getParameter("data_fim");
        
        Date dataInicio = new Date();
        Date dataFim = new Date();
        
        try {
            dataInicio = new SimpleDateFormat("yyyy-MM-dd").parse(inputDataInicio);
            dataFim = new SimpleDateFormat("yyyy-MM-dd").parse(inputDataFim);
        } catch (ParseException ex) {
            Logger.getLogger(CriaEdicao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Edicao edicaoNova = new Edicao();
        edicaoNova.setEvento(evento);
        edicaoNova.setNumero(numero);
        edicaoNova.setAno(ano);
        edicaoNova.setData_inicio(dataInicio);
        edicaoNova.setData_fim(dataFim);
        edicaoNova.setCidade(cidade);
        edicaoNova.setPais(pais);

        boolean inseriu = new EdicaoDAO().insereEdicao(edicaoNova);
        
        if(!inseriu){
            session.setAttribute("status", "erro");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            session.setAttribute("eventos", new EventoDAO().getEventos());
            session.setAttribute("status", "inserido");
            response.sendRedirect("http://localhost:8080/marcai/listaEvento.jsp?id=" + evento.getIdEvento());
        }
    }
}