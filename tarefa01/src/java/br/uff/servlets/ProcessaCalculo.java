package br.uff.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProcessaCalculo extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession httpSession = request.getSession();
        
        Double valor1 = 0.0;
        Double valor2 = 0.0;
        Double resultado = 0.0;
        String operacao = "";
        
        try {
            valor1 = Double.parseDouble(request.getParameter("valor1"));
            valor2 = Double.parseDouble(request.getParameter("valor2"));
            operacao = request.getParameter("operacao");
            
            if("SOM".equals(operacao)){
                resultado = (valor1 + valor2);
            } else if ("SUB".equals(operacao)) {
                resultado = (valor1 - valor2);
            } else if ("DIV".equals(operacao)) {
                resultado = (valor1 / valor2);
            } else if ("MUL".equals(operacao)) {
                resultado = (valor1 * valor2);
            }
        
            httpSession.setAttribute("resultado", Math.round(resultado * 100.0) / 100.0);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("/index.jsp?erro=S").forward(request, response);
        }
        
        
    }
}