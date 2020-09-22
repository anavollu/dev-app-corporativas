<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
    <head>
        <meta
        name="viewport"
        content="width=device-width, initial-scale=1"
        />
        <link rel="icon" type="image/png" href="images/icons/calculator.ico"/>
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="shortcut icon" href="img/fav.png" />
   
        <meta charset="UTF-8" />
        <title> Calculadora </title>
    </head>
    <body>
	<div class="contact1">
                <div class="container-contact1">
                        <div class="contact1-pic js-tilt" data-tilt>
				<img src="images/img-01.png" alt="IMG">
                                <span class="contact1-form-span" >
                                    <jsp:include page="/ControlaSessao"/>
                                        <%  if ((Integer) session.getAttribute("visitas") != null) {
                                                out.println("Visitas: " + (Integer) session.getAttribute("visitas"));
                                        }%>
                                </span>
			</div>
			<form class="contact1-form validate-form" method="POST" action="http://localhost:8080/Calculator/ProcessaCalculo">
                                <span class="contact1-form-title">
					Faça seu cálculo!
				</span>
				<div class="wrap-input1 validate-input" data-validate = "O primeiro valor é necessário!">
					<input class="input1" type="text" name="valor1" placeholder="0">
					<span class="shadow-input1"></span>
				</div>

				<div class="wrap-input1 validate-input" data-validate = "O segundo valor é necessário!">
					<input class="input1" type="text" name="valor2" placeholder="0">
					<span class="shadow-input1"></span>
				</div>
                            
                                <div class="wrap-input1 validate-input" data-validate = "Selecione um operador!">
                                    <label class="container">+
                                        <input type="radio" name="operacao" value="SOM">
                                        <span class="checkmark"></span>
                                    </label>

                                    <label class="container">-
                                        <input type="radio" name="operacao" value="SUB">
                                        <span class="checkmark"></span>
                                    </label>

                                    <label class="container">/
                                        <input type="radio" name="operacao" value="DIV">
                                        <span class="checkmark"></span>
                                    </label>

                                    <label class="container">*
                                        <input type="radio" name="operacao" value="MUL">
                                        <span class="checkmark"></span>
                                    </label>
				</div>

				<div class="wrap-input1 validate-input" data-validate = "">
                                    <% Double resultado = (Double) session.getAttribute("resultado");
                                        if ((Double) session.getAttribute("resultado") != null) {
                                            out.println("<input class=\"input1\" type=\"text\" name=\"resultado\" value=\"" + resultado + "\" readonly>");
                                        } else {
                                            out.println("<input class=\"input1\" type=\"text\" name=\"resultado\" value=\"0.0\" readonly>");
                                    }%>
                                    <span class="shadow-input1"></span>
				</div>

				<div class="container-contact1-form-btn">
					<button type="submit" class="contact1-form-btn">
						<span>
							Calcular
							<i class="fa fa-long-arrow-right" aria-hidden="true"></i>
						</span>
					</button>
				</div>
			</form>
                        <div>
                            <%  if ((String) session.getAttribute("erro") != null) {
                                    out.println("<span class=\"alert alert-danger\">");
                                    out.println("<strong>ERRO:</strong> " + (String) session.getAttribute("erro"));
                                    out.println("</span>");
                            }%>
                        </div>
		</div>
	</div>

	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="vendor/select2/select2.min.js"></script>
	<script src="vendor/tilt/tilt.jquery.min.js"></script>
	<script>
		$('.js-tilt').tilt({
			scale: 1.1
		});   
	</script>
	<script src="js/main.js"></script>

</body>
</html>