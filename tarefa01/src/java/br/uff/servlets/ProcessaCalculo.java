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
        
        try {
            valor1 = Double.parseDouble(request.getParameter("valor1"));
            valor2 = Double.parseDouble(request.getParameter("valor2"));
            String operacao = request.getParameter("operacao");
            
            if(null == operacao){
                resultado = null;
            } else switch (operacao) {
                case "SOM":
                    resultado = (valor1 + valor2);
                    break;
                case "SUB":
                    resultado = (valor1 - valor2);
                    break;
                case "DIV":
                    resultado = (valor1 / valor2);
                    break;
                case "MUL":
                    resultado = (valor1 * valor2);
                    break;
                default:
                    resultado = null;
                    break;
            }
            
            httpSession.removeAttribute("erro");
            httpSession.setAttribute("resultado", Math.round(resultado * 100.0) / 100.0);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        
        } catch (IOException | NumberFormatException | ServletException e) {
            httpSession.setAttribute("erro", "Informe valores válidos");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }   
    }
}