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
		
	    <a href="${pageContext.request.contextPath}/Deco">
	    	<button class="deconnexion-button"></button>
		</a>
		<button class="identifiant-button" onclick="showProfil()"></button>
	</div>
	
	<div class="interface-menu">
		<%@ include file="composants/menus/menu_inscrit.jsp" %>
	</div>

	<%--Contenu--%>

	<div class="interface-contenu">
	<%--  Les différentes interfaces pour les inscrits--%>
		<div id="accueil" class="accueil hidden">
			<%-- <%@ include file="composants/planning_day.jsp" %>
			<%@ include file="composants/calendrier.jsp" %> --%>
			Bienvenue
		</div>


	<%-- Réserver --%>
		<div id="reserver" class="reserver hidden">
			<%@ include file="composants/planning_hebdo.jsp" %>
		</div>


	<%--La liste des clubs--%>
		<div id="listeclubs" class="listeclubs hidden">
			<%@ include file="composants/liste_club.jsp" %>
		</div>


	<%--Mon Compte--%>
		<div id="profil" class="profil hidden">
			<%@ include file="composants/account_info.jsp" %> 
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
					<td>Benz</td>
					<td>17/11/2020</td>
					<td>0650595113</td>
					<td> UncleBenz@gmail.com</td>
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