<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt" class="no-js">
  <head>
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <link rel="shortcut icon" href="img/fav.png" />
    <meta name="author" content="colorlib" />
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <meta charset="UTF-8" />
    <title>Calculadora</title>
    
    <body>
    <div role="document">
        <% if ("V".equals((String) request.getParameter("erro"))){
            out.append("<p> Informe um valor válido! </p>");
        } else if ("O".equals((String) request.getParameter("erro"))){
            out.append("<p> Selecione um operador válido! </p>");
        }
 
        if ((Double) session.getAttribute("resultado") != null) {
                out.println("<p> Resultado: " + (Double) session.getAttribute("resultado") + "</p>");
           } else {
               out.println("<p> Faça seu cálculo! </p>");
        }%>
        <form name="frm" method="POST" action="http://localhost:8080/Calculator/ProcessaCalculo">
            <div>
                <label>Valor</label>
                <input
                    name="valor1"
                    placeholder="000"
                    type="text"
                    required
                />
            </div>
            <div>
                <label>Valor</label>
                <input
                    name="valor2"
                    placeholder="000"
                    type="text"
                    required
                />
            </div>
            <div>
                <label> <input type="radio" name="operacao" value="SOM" /> + </label>
                <label> <input type="radio" name="operacao" value="SUB" /> - </label>
                <label> <input type="radio" name="operacao" value="DIV" /> / </label>
                <label> <input type="radio" name="operacao" value="MUL" /> * </label>
            </div>
            <div>
                <button type="submit">
                    Calcular
                </button>
            </div>
        </form>
    </div>
    </body>
</html>