<%-- 
    Document   : index
    Created on : 30/09/2020, 00:04:20
    Author     : Felipe Vila Chã
--%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>Projection by TEMPLATED</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body>

		<!-- Header -->
			<header id="header">
				<div class="inner">
					<a href="index.jsp" class="logo"><strong>Home</strong></a>
					<nav id="nav">
						<a href="index.jsp">Informações</a>
						<a href="generic.html">Denúncias</a>
						<a href="index.jsp">Sobre</a>
						<a href="elements.html">Login</a>
					</nav>
					<a href="#navPanel" class="navPanelToggle"><span class="fa fa-bars"></span></a>
				</div>
			</header>

		<!-- Banner -->
			<section id="banner">
				<div class="inner">
					<header>
						<h1>Verde da Esperança</h1>
					</header>

					<div class="flex ">

						<div>
							<span class="icon fa-tree"></span>
							<h3>Conscientize</h3>
							<p> As queimadas não podem ter vez!</p>
						</div>

						<div>
							<span class="icon fa-phone"></span>
							<h3>Denuncie</h3>
							<p>Completamente anônimas!</p>
						</div>

						<div>
							<span class="icon fa-cog"></span>
							<h3>Colabore</h3>
							<p>Vamos construir um futuro viável!</p>
						</div>

					</div>

					<footer>
                                            <form method="POST" action="login">
                                                <input type="text" name="username" placeholder="login" required />
                                                <input type="text" name="senha" placeholder="login" required />
                                                <button type="submit" class="button special"> CRIAR </button>>
                                            </form>
                                            <form method="POST" action="criaDenuncia">
                                                <input type="hidden" name="id_usuario" value="1">
                                                <input type="text" name="descricao" placeholder="descricao" required />
                                                <input type="text" name="localidade" placeholder="localidade" required />
                                                <button type="submit" class="button special"> CRIAR </button>>
                                            </form>
					</footer>
				</div>
			</section>


		<!-- Three -->
			<section id="three" class="wrapper align-center">
				<div class="inner">
					<div class="flex flex-3">
						<article>
							<div class="image round">
								<img src="images/pic01.jpg" alt="Pic 01" />
							</div>
							<header>
								<h3>Lorem ipsum<br /> dolor amet nullam</h3>
							</header>
							<p>Morbi in sem quis dui placerat ornare. Pellentesquenisi<br />euismod in, pharetra a, ultricies in diam sed arcu. Cras<br />consequat  egestas augue vulputate.</p>
							<footer>
								<span class="icon fa-location-arrow"> Cidade,ES</span>
							</footer>
						</article>
						<article>
                                                    <header>
                                                        <h3>Últimas  notícias </h3>
                                                        </header>
                                                    <a class="twitter-timeline" href="https://twitter.com/MomentsBrasil/lists/meio-ambiente?ref_src=twsrc%5Etfw"> 
                                                    </a> <script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>
						</article>
						<article>
							<div class="image round">
								<img src="images/pic02.jpg" alt="Pic 02" />
							</div>
							<header>
								<h3>Sed feugiat<br /> tempus adipicsing</h3>
							</header>
							<p>Pellentesque fermentum dolor. Aliquam quam lectus<br />facilisis auctor, ultrices ut, elementum vulputate, nunc<br /> blandit ellenste egestagus commodo.</p>
							<footer>
								<span class="icon fa-location-arrow"> Cidade,ES</span>
							</footer>
						</article>
					</div>
				</div>
			</section>
                <%  if ((Boolean) session.getAttribute("status") != null && (Boolean) session.getAttribute("status") == false){
                        out.println("<p> Tente again! </p>");
                    } else if ((Boolean) session.getAttribute("status") != null && (Boolean) session.getAttribute("status") == true){
                        out.println("<p> Bem-vindo 06! </p>");
                } %>
		<!-- Footer -->
			<footer id="footer">
				<div class="container">
					<ul class="icons">
						<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
						<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
						<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
						<li><a href="#" class="icon fa-envelope-o"><span class="label">Email</span></a></li>
					</ul>
				<div class="copyright">
					&copy; Felipe Vila Chã. All rights reserved.
				</div>
				</div>
			</footer>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>
