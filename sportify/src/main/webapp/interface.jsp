<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<title>Espace inscrit</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/style-interface.css">	
</head>


<body>

<div class="interface">
	<div class="interface-header">
		<div class="header-title">SPORTIFY</div>
		
	    <a href="index.jsp">
	    	<button class="deconnexion-button"></button>
		</a>
		<button class="setting-button"></button>
		<button class="identifiant-button"></button>
	</div>
	
	<div class="interface-menu">
		<%@ include file="composants/menu_inscrit.jsp" %>
	</div>

	<%--Contenu--%>

	<div class="interface-contenu">
	<%--  Les différentes interfaces pour les inscrits--%>
		<div id="accueil" class="accueil hidden">
			Accueil
		</div>

		<div id="reserver" class="reserver hidden">
			Reservation
		</div>

		<div id="listeclubs" class="listeclubs hidden">
			Liste des clubs
			<table class="tableau table table-bordered">
				<tr>
					<th>Nom</th>
					<th>Prénom</th>
					<th>Date d'inscription</th>
					<th>Numéro</th>
					<th> Mail </th>
					<th> </th>
				</tr>
				<%-- --%>
				<tr>
					<td>Tonton</td>
					<td>Floda</td>
					<td>17/11/2020</td>
					<td>0650595113</td>
					<td> UncleFloda@gmail.com</td>
					<td> <button onclick="retirer()"> X </button></td>
				</tr>
				<tr>
					<td>Tonton</td>
					<td>Jeff</td>
					<td>17/11/2020</td>
					<td>0649025614</td>
					<td> TontonJeff@gmail.com</td>
					<td> <button onclick="retirer()"> X </button></td>
				</tr>

			</table>
		</div>

		<div id="profil" class="profil hidden">
			Profil
		</div>


<%--Coté admin--%>
<%-- Pour les membres coté admin--%>


		<div id="membres" class="membres hidden">
			Liste des membres

			<table class="tableau table table-bordered">
				<tr>
					<th>Nom</th>
					<th>Prénom</th>
					<th>Date d'inscription</th>
					<th>Numéro</th>
					<th> Mail </th>
					<th> </th>
				</tr>
				<%-- --%>
				<tr>
					<td>Tonton</td>
					<td>Floda</td>
					<td>17/11/2020</td>
					<td>0650595113</td>
					<td> UncleFloda@gmail.com</td>
					<td> <button onclick="retirer()"> X </button></td>
				</tr>
				<tr>
					<td>Tonton</td>
					<td>Jeff</td>
					<td>17/11/2020</td>
					<td>0649025614</td>
					<td> TontonJeff@gmail.com</td>
					<td> <button onclick="retirer()"> X </button></td>
				</tr>

			</table>
		</div>

	</div>
</div>

</body>
</html>