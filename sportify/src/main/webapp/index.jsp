<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<title>Landing Page</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/style.css">	
</head>

<body>

<div class="landing-page">

	<div id="landing-header" class="landing-header">
		<div class="header-icon">
		</div>
		<a href="connexion.jsp">
			<button class="connexion-button">
				<p>Connexion</p>
			</button>
		</a>
	</div>
	
	<div class="landing-home">
		<div id="bg-img" class="bg-img"></div>
		<div class="home-text">
			SPORTIFY
		</div>
		<a href="connexion.jsp">
			<button class="home-button">
				<p style="margin-top: -8px; margin-left: 12px;">Join us !</p>
			</button>
		</a>
	</div>
	
	<div class="landing-content">
		<div class="soon-news">
			<%@ include file="composants/soonNews.jsp" %>
			<%-- <jsp:include page="composants/soonNews.jsp"/> --%>
		</div>
		<div class="landing-information">
			<div class="information-text">
				<p>Team13 est une application web de gestion de clubs sportifs, elle a comme principal objectif de simplifier l'organisation des évènements,
				 de gérer les réservations et  d'informer les utilisateurs de l'actualité du complexe. </p>
				 <p>L'application s'adresse à toutes personnes souhaitant pratiquer du sport ou s'informer de l'actualité du complexe. Elle s'adresse également aux clubs, 
				 en leur permettant d'organiser des évènements, réserver un terrain ou encore gérer ses membres de façon simple et centralisé. </p>
				 <p>Une fois inscrit sur le site, un particulier peut réserver un terrain, consulter l'agenda ainsi que la liste des clubs et peut adhérer à ces derniers.
				  Une fois adhérent à un club, l'utilisateur sera notifié des évènements et pourra s'inscrire afin d'y participer. </p>
				 <p>Notre but est, avant tout, de simplifier la gestion des clubs et des équipements sportifs et de rendre accessible à tous les informations en rapport au complexe. </p>
			</div>
			<img class="information-illustration" src="img/landing-illustration.jpg" alt="illustration sport"/>
		</div>
	</div>
	
	<div class="landing-footer">
	</div>
	
</div>

<script type="text/javascript">
	window.onscroll = function () {
		console.log(document.documentElement.scrollTop);
		if (document.documentElement.scrollTop > 100) {
			document.getElementById("landing-header").style.transform = "translateY(-70px)"; 
		} else {
			document.getElementById("landing-header").style.transform = "translateY(0px)";
		}
		if (document.documentElement.scrollTop > 300) {
			document.getElementById("bg-img").style.filter = "brightness(60%)";
		} else if (document.documentElement.scrollTop > 550) {
			document.getElementById("bg-img").style.filter = "brightness(40%)"; 
		} else {
			document.getElementById("bg-img").style.filter = "brightness(80%)";
		}
	}
</script>

</body>
</html>
