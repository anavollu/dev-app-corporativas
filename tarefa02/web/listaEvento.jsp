<%@page import="model.Evento"%>
<%@page import="model.Edicao"%>
<%@page import="java.util.List"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>MarcAi</title>
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
				$('#cria-edicao').on('show.bs.modal', function (event) {
				var button = $(event.relatedTarget); // Button that triggered the modal
				var id = button.data('id'); // Extract info from data-* attributes
				var modal = $(this);
				modal.find('#id').val(id);
				});
			});
                        
                        $(function () {
				$('#edita-edicao').on('show.bs.modal', function (event) {
				var button = $(event.relatedTarget); // Button that triggered the modal
				var id = button.data('id'); // Extract info from data-* attributes
				var modal = $(this);
				modal.find('#id').val(id);
				});
			});
                        
                        $(function () {
				$('#exclui-edicao').on('show.bs.modal', function (event) {
				var button = $(event.relatedTarget); // Button that triggered the modal
				var id = button.data('id'); // Extract info from data-* attributes
				var modal = $(this);
				modal.find('#id').val(id);
				});
			});
                        
		</script>
		<noscript>
                        <link rel="icon" type="image/png" href="images/icons/party.ico"/>
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
                        <link rel="shortcut icon" href="images/icons/party.ico" />
		</noscript>
	</head>
        <body id="top">
                
		<!-- Header -->
			<header id="header" class="skel-layers-fixed">
				<h1><a href="#">MarcAi</a></h1>
				<nav id="nav">
					<ul>
						<li><a href="index.jsp">Home</a></li>
					</ul>
				</nav>
			</header>

		<!-- Main -->
                <jsp:include page="/listaEvento"/>
                
			<section id="main" class="wrapper style1">
				<header class="major">
					<h2>Evento</h2>
					<p> <%= ((Evento) session.getAttribute("evento")).getNome() %> </p>
				</header>
				<div class="container">
					<hr class="major" />
					<section class="special">
						<a href="#" class="image fit"><img src="images/pic01.jpg" alt="" /></a>						
						<h3> <strong>Sigla:</strong> <%= ((Evento) session.getAttribute("evento")).getSigla() %> </h3>
                                                <h3> <strong>Local:</strong> <%= ((Evento) session.getAttribute("evento")).getArea() %> </h3>
                                                <h3> <strong>Oferecimento:</strong> <%= ((Evento) session.getAttribute("evento")).getOrganizacao()%></h3>
						<ul class="actions flex">
							<li><a class="button alt" data-toggle="modal" data-target="#edita-evento">Editar</a></li>
                                                        <li><a class="button alt" data-toggle="modal" data-target="#exclui-evento">Remover</a></li>
						</ul>
					</section>
				</div>	
			</section>
			<section id="history" class="wrapper style1">
				<header class="major">
					<h2>Hist�rico de edi��es</h2>
                                        <button class="button alt" data-title="Criar" data-toggle="modal" data-target="#cria-edicao">Criar</button>
				</header>
				<div class="container">
					<hr class="major" />
					<div class="row">
						<table id="historico" class="table">
							<thead>
							  <th>Numero</th>
							  <th>Ano</th>
							  <th>Data de inicio</th>
							  <th>Data de termino</th>
							  <th>Cidade</th>
							  <th>Pais</th>
							</thead>
							<tbody>
								  <% if (((List<Edicao>) session.getAttribute("edicoes")) != null) { 
                                                                        for (Edicao edicao : ((List<Edicao>) session.getAttribute("edicoes"))){
                                                                            out.println("<tr>");
                                                                            out.println("<td> " + edicao.getNumero() + " </td>");
                                                                            out.println("<td> " + edicao.getAno() + " </td>");
                                                                            out.println("<td> " + edicao.getData_inicio() + " </td>");
                                                                            out.println("<td> " + edicao.getData_fim() + " </td>");
                                                                            out.println("<td> " + edicao.getCidade() + " </td>");
                                                                            out.println("<td> " + edicao.getPais() + " </td>");
                                                                            out.println("<td> <button class=\"button alt\" data-title=\"Editar\" data-toggle=\"modal\" data-target=\"#edita-edicao\" data-id=\"" + edicao.getId() + "\">Editar</button></td>");
                                                                            out.println("<td> <button class=\"button danger\" data-title=\"Excluir\" data-toggle=\"modal\" data-target=\"#exclui-edicao\" data-id=\"" + edicao.getId() + "\">Excluir</button></td></tr>");
                                                                      }
                                                                }%>
							</tbody>
						  </table>
					</div>
				</div>
			</section>
			<!-- Modal Nova Edi��o-->
			<div class="modal fade" id="cria-edicao" tabindex="-1">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">	
							<h2 class="modal-title">MarcA� <span class="close" data-dismiss="modal">&times;</span> </h2>
						</div>
						<form role="form" action="http://localhost:8080/marcai/criaEdicao" method="POST" class="registration-form">
						<div class="modal-body">	
                                                    <input type="hidden" name="evento_id" value="<%=((Evento) session.getAttribute("evento")).getNome()%>">
								<div class="form-group">
									<label class="sr-only">Numero</label>
									<input type="text" name="numero" placeholder="Numero da edi��o do rol�..." class="form-control" id="numero" required/>
								</div>
								<div class="form-group">
									<label class="sr-only">Ano</label>
									<input type="text" name="ano" placeholder="Ano de realiza��o..." class="form-control" id="ano" required/>
								</div>
								<div class="form-group">
									<label class="sr-only">Data de inicio</label>
									<input type="date" name="data_inicio" placeholder="Data de inicio..." class="form-control" id="data_inicio" required/>
								</div>
								<div class="form-group">
									<label class="sr-only">Data de termino</label>
									<input type="date" name="data_fim" placeholder="Data de t�rmino..." class="form-control" id="data_fim" required/>
								</div>
								<div class="form-group">
									<label class="sr-only">Cidade</label>
									<input type="text" name="cidade" placeholder="Cidade sede..." class="form-control" id="cidade" required/>
								</div>
								<div class="form-group">
									<label class="sr-only">Pais</label>
									<input type="text" name="pais" placeholder="Pa�s sede..." class="form-control" id="pais" required/>
								</div>
							</div>
							<div class="modal-footer">
								<button type="submit" class="button special">Marcar!</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- Model Remo��o Edi��o -->
			<div class="modal fade" id="exclui-edicao">
				<div class="modal-dialog" role="document">
					<div class="modal-content-warn">
						<!-- Modal Header -->
						<div class="modal-header">
							<h4 class="modal-title">Tem certeza? <span class="close" data-dismiss="modal">&times;</h4>
                                                        
						</div>
						<!-- Modal body -->
						<form method="POST" action="http://localhost:8080/marcai/removeEdicao">
							<div class="modal-body">
								<input type="hidden" name="id" id="id" value=""/>
								Nao vai conseguir recuperar, hein?
							</div>
							<!-- Modal footer -->
							<div class="modal-footer">
								<ul class="actions">
									<li><a class="button alt" data-dismiss="modal">Cancel</a></li>
                                                                        <li><button type="submit" class="button danger"> Excluir</button></li>
								</ul>
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- Model Remo��o Evento -->
			<div class="modal fade" id="exclui-evento">
				<div class="modal-dialog" role="document">
					<div class="modal-content-warn">
						<!-- Modal Header -->
						<div class="modal-header">
							<h4 class="modal-title">Tem certeza? <span class="close" data-dismiss="modal">&times;</h4>
						</div>
						<!-- Modal body -->
						<form method="POST" action="http://localhost:8080/marcai/removeEvento">
							<div class="modal-body">
								<input type="hidden" name="id" id="id" value="<%= ((Evento) session.getAttribute("evento")).getIdEvento() %>"/>
								Nao vai conseguir recuperar, hein?
							</div>
							<!-- Modal footer -->
							<div class="modal-footer">
								<ul class="actions">
									<li><a class="button alt" data-dismiss="modal">Cancel</a></li>
									<li><button type="submit" class="button danger">Excluir</button></li>
								</ul>
							</div>
						</form>
					</div>
				</div>
			</div>  
			<!-- Modal Edi��o Evento -->
			<div class="modal fade" id="edita-evento" tabindex="-1">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">	
							<h2 class="modal-title">MarcA� <span class="close" data-dismiss="modal">&times;</span> </h2>
						</div>
						
                                            <form role="form" action="http://localhost:8080/marcai/editaEvento" method="POST" class="registration-form">
						<div class="modal-body">
								<div class="form-group">
                                                                    <input type="hidden" name="id" id="id" value="<%= ((Evento) session.getAttribute("evento")).getIdEvento()%>"/>
								</div>
								<div class="form-group">
									<label class="sr-only">Nome</label>
                                                                        <input type="text" name="nome" value="<%= ((Evento) session.getAttribute("evento")).getNome() %>" class="form-control" id="form-first-name">
								</div>
								<div class="form-group">
									<label class="sr-only">Sigla</label>
                                                                        <input type="text" name="sigla" value="<%= ((Evento) session.getAttribute("evento")).getSigla()%>" class="form-control" id="sigla">
								</div>
								<div class="form-group">
									<label class="sr-only" >Local</label>
									<input type="text" name="area" value="<%= ((Evento) session.getAttribute("evento")).getArea() %>" class="form-control" id="area">
								</div>
								<div class="form-group">
									<label class="sr-only">Organizacao</label>
                                                                        <input type="text" name="organizacao" value="<%= ((Evento) session.getAttribute("evento")).getOrganizacao() %>" class="form-control" id="organizacao">
								</div>
							</div>
							<div class="modal-footer">
								<ul class="actions">
                                                                    <li><button type="submit" class="button special">Atualizar</button></li>
								</ul>
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- Modal Edi��o Edi��o -->
			<div class="modal fade" id="edita-edicao" tabindex="-1">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">	
							<h2 class="modal-title">MarcA� <span class="close" data-dismiss="modal">&times;</span> </h2>
						</div>
						
                                            <form role="form" action="http://localhost:8080/marcai/editaEdicao" method="POST" class="registration-form">
						<div class="modal-body">
								<input type="hidden" name="id" id="id" value="">
								<input type="hidden" name="evento_id" value="<%= ((Evento) session.getAttribute("evento")).getIdEvento() %>">
								<div class="form-group">
									<label class="sr-only">Numero</label>
									<input type="text" name="numero" placeholder="Numero da edicao" class="form-control" id="numero" required/>
								</div>
								<div class="form-group">
									<label class="sr-only">Ano</label>
									<input type="text" name="ano" placeholder="Ano de realizacao..." class="form-control" id="ano" required/>
								</div>
								<div class="form-group">
									<label class="sr-only">Data de inicio</label>
									<input type="date" name="data_inicio" placeholder="" class="form-control" id="data_inicio" required/>
								</div>
								<div class="form-group">
									<label class="sr-only">Data de termino</label>
									<input type="date" name="data_fim" placeholder="" class="form-control" id="data_fim" required/>
								</div>
								<div class="form-group">
									<label class="sr-only">Cidade</label>
									<input type="text" name="cidade" placeholder="Cidade sede..." class="form-control" id="cidade" required/>
								</div>
								<div class="form-group">
									<label class="sr-only">Pais</label>
									<input type="text" name="pais" placeholder="Pais sede..." class="form-control" id="pais" required/>
								</div>
							</div>
							<div class="modal-footer">
								<button type="submit" class="button special">Atualizar</button>
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
						<h2>Quem somos nos</h2>
						<p>Uma empresa especializada em marcar a vida dos clientes. Vivencie experiencias unicas!</p>
						<ul class="icons">
							<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
							<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
							<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
							<li><a href="#" class="icon fa-linkedin"><span class="label">LinkedIn</span></a></li>
						</ul>
					</div>
				</div>
				<ul class="copyright">
					<li>&copy; Felipe Vila Ch�. All rights reserved.</li>
					<li>Design: <a href="http://templated.co">TEMPLATED</a></li>
				</ul>
			</div>
		</footer>

	</body>
</html>