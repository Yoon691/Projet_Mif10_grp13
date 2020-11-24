<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<title>Landing Page</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
	<link rel="shortcut icon" href="">
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
				<p class="join-us">Join us !</p>
			</button>
		</a>
	</div>
	
	<div class="landing-content">
		<div class="soon-news">
			<%@ include file="composants/soonNews.jsp" %>
		</div>
		<div class="landing-information">
			<div class="information-text">
				<p id="landing-paragraphe1" class="landing-paragraphe">Team13 est une application web de gestion de clubs sportifs, elle a comme principal objectif de simplifier l'organisation des �v�nements,
				 de g�rer les r�servations et  d'informer les utilisateurs de l'actualit� du complexe. </p>
				 <p id="landing-paragraphe2" class="landing-paragraphe">L'application s'adresse � toutes personnes souhaitant pratiquer du sport ou s'informer de l'actualit� du complexe. Elle s'adresse �galement aux clubs, 
				 en leur permettant d'organiser des �v�nements, r�server un terrain ou encore g�rer ses membres de fa�on simple et centralis�. </p>
				 <p id="landing-paragraphe3" class="landing-paragraphe">Une fois inscrit sur le site, un particulier peut r�server un terrain, consulter l'agenda ainsi que la liste des clubs et peut adh�rer � ces derniers.
				  Une fois adh�rent � un club, l'utilisateur sera notifi� des �v�nements et pourra s'inscrire afin d'y participer. </p>
				 <p id="landing-paragraphe4" class="landing-paragraphe">Notre but est, avant tout, de simplifier la gestion des clubs et des �quipements sportifs et de rendre accessible � tous les informations en rapport au complexe. </p>
			</div>
			<img class="information-illustration" src="img/landing-illustration.jpg" alt="illustration sport"/>
		</div>
	</div>
	
	<div class="landing-footer">
		<p>� SPORTIFY by Team13 - All right reserved</p>
	</div>
	
</div>

<script type="text/javascript" src="js/landing-script.js"></script>

</body>
</html>
