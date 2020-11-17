<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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
	
	<div class="interface-contenu">
	
	</div>
</div>

</body>
</html>