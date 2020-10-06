<%@page import="model.Evento"%>
<%@page import="model.Edicao"%>
<%@page import="java.util.List"%>
<!DOCTYPE HTML>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
                <meta name="viewport" content="width=device-width, initial-scale=1">
		<title>MarcAí</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<script src="assets/js/jquery.min.js"></script>
		<script src="assets/js/skel.min.js"></script>
		<script src="assets/js/skel-layers.min.js"></script>
		<script src="assets/js/init.js"></script>
		<script src="assets/js/bootstrap.bundle.js"></script>
		<script src="assets/js/bootstrap.bundle.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
		<script src="assets/js/bootstrap.js"></script>
		<script src="assets/js/bootstrap.min.js"></script>
		<script>
			$(function () {
				$('#aceita').on('show.bs.modal', function (event) {
				var button = $(event.relatedTarget); // Button that triggered the modal
				var id = button.data('id'); // Extract info from data-* attributes
				var modal = $(this);
				modal.find('#id').val(id);
				});
			});
		</script>
		<noscript>
			<link rel="stylesheet" href="assets/css/skel.css" />
			<link rel="stylesheet" href="assets/css/style.css" />
			<link rel="stylesheet" href="assets/css/style-xlarge.css" />
			<link rel="stylesheet" href="assets/css/bootstrap.css" />
			<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
			<link rel="stylesheet" href="assets/css/bootstrap-grid.css" />
			<link rel="stylesheet" href="assets/css/bootstrap-grid.min.css" />
			<link rel="stylesheet" href="assets/css/bootstrap-reboot.css" />
			<link rel="stylesheet" href="assets/css/bootstrap-reboot.min.css" />
			<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
			<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		</noscript>
	</head>
	<body id="top">

		<!-- Header -->
			<header id="header" class="skel-layers-fixed">
				<h1><a href="#">MarcAí</a></h1>
				<nav id="nav">
					<ul>
                                            <li><a href="index.jsp">Home</a></li>
					</ul>
				</nav>
			</header>

		<!-- Banner -->
			<section id="banner">
				<div class="inner">
					<h2>MarcAí</h2>
					<p>Crie e gerencie seus eventos de forma prática e rápida</p>
					<ul class="actions">
                                            <li><a data-toggle="modal" data-target="#cria-evento" class="button big special">Marque aqui</a></li>
                                            <li><a href="#eventos"  class="button big alt">Veja o que está rolando</a></li>
					</ul>
				</div>
			</section>

		<!-- One -->
                <jsp:include page="/buscaEvento"/>
			<section id="one" class="wrapper style1">
				<header class="major">
					<h2>Alguns rolês marcados</h2>
					<p>Explore e descubra!</p>
                                </header>
				<div class="container" id="eventos">
                                    <ul class="actions fit">
                                        <li><input type="text" class="" id="procura_nome" placeholder="Procurar..." name="procura_nome"></li>
                                        <li><button class="button alt" onclick="window.location.href='http://localhost:8080/marcai/listaEvento.jsp?nome='+document.getElementById('procura_nome').value"><i class="fa fa-search"></i></button></li>
                                    </ul>
                                    <div class="row">
                                            <% for (Evento evento : ((List<Evento>) session.getAttribute("eventos"))){
						int evento_id = evento.getIdEvento();
                                                out.println("<div class=\"4u\">");
						out.println("<section class=\"special box\">");
                                                out.println("<i class=\"icon fa-calendar major\"></i>");
						out.println("<h3>" + evento.getNome() +"</h3>");
						out.println("<p> Sigla: " + evento.getSigla() + "</p>");
                                                out.println("<p> Local: " + evento.getArea() + "</p>"); 
                                                out.println("<p> Oferecimento: " + evento.getOrganizacao() + "</p>"); 
						out.println("<ul class=\"actions\">");
                                                out.println("<li><a href=\"http://localhost:8080/marcai/listaEvento.jsp?id=" + evento_id + "\" class=\"button alt\">Informações</a></li>");
						out.println("</ul>");
                                                out.println("</section>");
						out.println("</div>");
                                            }%>
					</div>
				</div>
			</section>
			<!-- Modal Criacao -->
			<div class="modal fade" id="cria-evento" tabindex="-1">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">	
							<h2 class="modal-title">MarcAí <span class="close" data-dismiss="modal">&times;</span> </h2>
						</div>
						<form method="POST" action="http://localhost:8080/marcai/criaEvento" class="registration-form">
                                                    <div class="modal-body">
                                                            <div class="form-group">
                                                                 <label class="sr-only">Nome</label>
                                                                 <input type="text" name="nome" placeholder="Nome do rolê..." class="form-control" id="nome" required/>
                                                            </div>
                                                                    <div class="form-group">
                                                                            <label class="sr-only">Sigla</label>
                                                                            <input type="text" name="sigla" placeholder="Sigla..." class="form-control" id="sigla" required/>
                                                                    </div>
                                                                    <div class="form-group">
                                                                            <label class="sr-only" >Local</label>
                                                                            <input type="text" name="area" placeholder="Local..." class="form-control" id="area" required/>
                                                                    </div>
                                                                    <div class="form-group">
                                                                            <label class="sr-only">Organização</label>
                                                                            <input type="text" name="organizacao" placeholder="Organização responsável..." class="form-control" id="organizacao" required/>
                                                                    </div>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="submit" class="button special">Marcar!</button>  
                                                        </div>
                                                </form>
					</div>
				</div>
			</div>               
		<!-- Footer -->
			<footer id="footer">
				<div class="container">
					<div class="row">
						<div class="6u">
							<h2>Quem somos nós</h2>
							<p>Uma empresa especializada em marcar a vida dos clientes. Vivencie experiências únicas!</p>
							<ul class="icons">
								<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
								<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
								<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
								<li><a href="#" class="icon fa-linkedin"><span class="label">LinkedIn</span></a></li>
							</ul>
						</div>
					</div>
					<ul class="copyright">
						<li>&copy; Felipe Vila Chã. All rights reserved.</li>
						<li>Design: <a href="http://templated.co">TEMPLATED</a></li>
					</ul>
				</div>
			</footer>

	</body>
</html>