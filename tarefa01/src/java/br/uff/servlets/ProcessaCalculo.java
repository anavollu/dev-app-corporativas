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
        HttpSession session = request.getSession();
            
        Double valor1 = 0.0;
        Double valor2 = 0.0;
        Double resultado = 0.0;
        
        try {
            valor1 = Double.parseDouble(request.getParameter("valor1"));
        } catch (Exception e) {
            session.setAttribute("erro","V");
            request.getRequestDispatcher("/index.jsp?erro=V").forward(request, response);
        }
        
        try {
            valor2 = Double.parseDouble(request.getParameter("valor2"));
        } catch (Exception e) {
            session.setAttribute("erro","V");
            request.getRequestDispatcher("/index.jsp?erro=V").forward(request, response);
        }
        
        String operacao = request.getParameter("operacao");
        
        if(operacao == null){
            session.setAttribute("erro","O");
            request.getRequestDispatcher("/index.jsp?erro=O").forward(request, response);
        }
        
        if("SOM".equals(operacao)){
            resultado = (valor1 + valor2);
        } else if ("SUB".equals(operacao)) {
            resultado = (valor1 - valor2);
        } else if ("DIV".equals(operacao)) {
            resultado = (valor1 / valor2);
        } else if ("MUL".equals(operacao)) {
            resultado = (valor1 * valor2);
        }
        
        session.setAttribute("resultado", resultado);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}