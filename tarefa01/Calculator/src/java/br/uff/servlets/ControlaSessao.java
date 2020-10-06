package br.uff.servlets;

import br.uff.models.Sessao;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
public class ControlaSessao extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession httpSession = request.getSession();
        Sessao sessao = new Sessao();
        
        ArrayList<Cookie> cookies = new ArrayList<>();
        
        if(request.getCookies() != null){
            for(Cookie c : request.getCookies()){
                if(c.getName().contains("visitante")){
                    cookies.add(c);
                }
            }
        }
        
        if(cookies.isEmpty()){
            sessao.atualizaHistorico();
            Cookie c = new Cookie("visitante" + String.valueOf(sessao.ID), String.valueOf(sessao.ID));
            c.setMaxAge(-1);
            response.addCookie(c);
            cookies.add(c);    
        }
        
        int visitantes = Integer.parseInt(cookies.get(cookies.size() - 1).getValue());
        
        httpSession.setAttribute("visitas", visitantes);
    }
}