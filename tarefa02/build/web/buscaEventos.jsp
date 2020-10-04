<%@page import="java.util.List"%>
<%@page import="model.Evento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <% if ((List<Evento>) session.getAttribute("eventos") != null) {
                for (Evento evento : (List<Evento>) session.getAttribute("eventos")){
                    out.println("<form method=\"POST\" action=\"http://localhost:8080/marcai/editaEvento\">");
                    out.println("<input type=\"hidden\" value=\"" + evento.getIdEvento() + "\" name=\"id\">");
                    out.println("<input type=\"text\" value=\"" + evento.getNome() + "\" name=\"nome\">");
                    out.println("<input type=\"text\" value=\"" + evento.getSigla() + "\" name=\"sigla\">");
                    out.println("<input type=\"text\" value=\"" + evento.getArea() + "\" name=\"area\">");
                    out.println("<input type=\"text\" value=\"" + evento.getOrganizacao() + "\" name=\"organizacao\">");
                    out.println("<input type=\"submit\" value=\"GO\">");
                    out.println("</form>");
                }
        }%>
    </body>
</html>
