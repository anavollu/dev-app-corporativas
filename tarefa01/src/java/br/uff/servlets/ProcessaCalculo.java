package br.uff.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProcessaCalculo extends HttpServlet {
    int visitas = 0;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        if(request.getCookies().length == 0){
            Cookie c = new Cookie("visitantes", String.valueOf(Math.random()));
            c.setMaxAge(60*60*24*7);
            response.addCookie(c);
        } else {
            visitas++;
        }
            
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
        session.setAttribute("visitas", visitas);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}