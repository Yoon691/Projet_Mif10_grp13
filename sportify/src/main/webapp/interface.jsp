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
	<div id="interface-header" class="interface-header">
		<h1>SPORTIFY</h1>
		

	    <a href="index.jsp">
	    	<button class="deconnexion-button"></button>
		</a>
		
		<button class="setting-button"></button>
		
		<button class="identifiant-button"></button>

	</div>
	
	<div id="menu-interface" class="menu-interface">
		<%@ include file="composants/menu_inscrit.jsp" %>
	</div>
	
	<div id=interface-contenu class="interface-contenu">
	
	</div>
</div>

</body>
</html>