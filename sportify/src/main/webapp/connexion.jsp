<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Connexion SPORTIFY</title>
	<link rel="stylesheet" href="css/style-connexion.css">
</head>
<body>
	<div class="connexion-title">SPORTIFY</div>
	
	<div id="c-c" class="cadre-authentification cadre-connexion">
		<h2>Connexion</h2>
		<form>
			<div class="user-box">
				<input type="text" name="" required="">
				<label>Email</label>
			</div>
			<div class="user-box">
				<input type="password" name="" required="">
				<label>Mot de passe</label>
			</div>
			<a href="#">
				<span></span>
				<span></span>
				<span></span>
				<span></span>
				Connexion
			</a>
		</form>
		<div class="inscrire">
			<a class="aff-inscr-adh">Inscription Adhérent</a>
			-
			<a class="aff-inscr-club">Inscription Club</a>
		</div>
	</div>
	
	<div id="c-i-a" class="cadre-authentification cadre-inscription-adh" style="left:-50%;">
		<h2>Inscription adhérent</h2>
		<form>
			<div class="user-box">
				<input type="text" name="" required="">
				<label>Nom</label>
			</div>
			<div class="user-box">
				<input type="text" name="" required="">
				<label>Prénom</label>
			</div>
			<div class="user-box">
				<input type="password" name="" required="">
				<label>Mot de passe</label>
			</div>
			<div class="user-box">
				<input type="email" name="" required="">
				<label>Email</label>
			</div>
			<div class="user-box">
				<input type="tel" name="" required="">
				<label>n° téléphone</label>
			</div>
			<div class="user-box">
				<input type="date" name="" required="">
				<label>Date de naissance</label>
			</div>
			<a href="#">
				<span></span>
				<span></span>
				<span></span>
				<span></span>
				S'inscrire
			</a>
		</form>
		<div class="inscrire">
			<a class="aff-connexion">Connexion</a>
			-
			<a class="aff-inscr-club">Inscription Club</a>
		</div>
	</div>
	
	<div id="c-i-c" class="cadre-authentification cadre-inscription-club" style="left:-50%;">
		<h2>Inscription Club</h2>
		<form>
			<div class="user-box">
				<input type="text" name="" required="">
				<label>Nom du club</label>
			</div>
			<div class="user-box">
				<input type="text" name="" required="">
				<label>Email</label>
			</div>
			<div class="user-box">
				<input type="text" name="" required="">
				<label>Nom responsable</label>
			</div>
			<div class="user-box">
				<input type="password" name="" required="">
				<label>Mot de passe</label>
			</div>
			<div class="user-box">
				<input type="number" name="" required="">
				<label>Capacité (nb adhérent max)</label>
			</div>
			<a href="#">
				<span></span>
				<span></span>
				<span></span>
				<span></span>
				Inscrire le club
			</a>
		</form>
		<div class="inscrire">
			<a class="aff-connexion">Connexion</a>
			-
			<a class="aff-inscr-adh">Inscription Adhérent</a>
		</div>
	</div>
	
	<div class="connexion-footer">
		<p>© SPORTIFY by Team13 - All right reserved</p>
	</div>
	
	
	<script type="text/javascript">
		var affClub = document.getElementsByClassName("aff-inscr-club");
		var affCo = document.getElementsByClassName("aff-connexion");
		var affAdh = document.getElementsByClassName("aff-inscr-adh");

		var affInscrClub = function() {
			console.log("fonction");
		    var cadreToShow = document.getElementById("c-i-c");
		    var cadreToHide1 = document.getElementById("c-i-a");
		    var cadreToHide2 = document.getElementById("c-c");
		    cadreToShow.style.left = "50%";
		    cadreToHide1.style.left = "-50%";
		    cadreToHide2.style.left = "-50%";
		};
		
		var affInscrAdh = function() {
			console.log("fonction");
		    var cadreToShow = document.getElementById("c-i-a");
		    var cadreToHide1 = document.getElementById("c-i-c");
		    var cadreToHide2 = document.getElementById("c-c");
		    cadreToShow.style.left = "50%";
		    cadreToHide1.style.left = "-50%";
		    cadreToHide2.style.left = "-50%";
		};
		
		var affConnexion = function() {
			console.log("fonction");
		    var cadreToShow = document.getElementById("c-c");
		    var cadreToHide1 = document.getElementById("c-i-a");
		    var cadreToHide2 = document.getElementById("c-i-c");
		    cadreToShow.style.left = "50%";
		    cadreToHide1.style.left = "-50%";
		    cadreToHide2.style.left = "-50%";
		};
		
		for (var i = 0; i < affClub.length; i++) {
		    affClub[i].addEventListener('click', affInscrClub, false);
		}
		for (var i = 0; i < affAdh.length; i++) {
		    affAdh[i].addEventListener('click', affInscrAdh, false);
		}
		for (var i = 0; i < affCo.length; i++) {
		    affCo[i].addEventListener('click', affConnexion, false);
		}
	</script>
	
</body>
</html>