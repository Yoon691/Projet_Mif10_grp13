<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<c:if test="${sessionScope.club != null}">
		<%@ include file="composants/menus/menu_club.jsp" %>
	</c:if>
	<c:if test="${sessionScope.user != null}">
		<%@ include file="composants/menus/menu_inscrit.jsp" %>
	</c:if>
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

		<div id="evenement" class="evenement hidden">
			<%@ include file="composants/evenement.jsp" %>

		</div>

		<div id="membres" class="membres hidden">
			<%@ include file="composants/liste_membres.jsp" %>
		</div>

	</div>
</div>

</body>
</html>