package br.uff.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Contador extends HttpServlet {
    private int visitas;

    @Override
    public void init() throws ServletException {
        visitas = 0;
    }
     
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer visitantes = (Integer) session.getAttribute("visitas");
        visitas = visitantes + 1;
        
        session.setAttribute("visitas", visitas);
        request.getRequestDispatcher("/ProcessaCalculo").forward(request, response);
    }
}