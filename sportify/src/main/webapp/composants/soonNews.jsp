<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>

<style>
	.soonNews {
		width: 430px;
		height: 648px;
		border: solid red 3px;
		background-color: #F2F2F2;
		overflow:scroll;
	}

	.banniere-sn {
		width: 100%;
		heigth: 60px;
		background-color: #282828;
	}

	.banniere-sn h2 {
		color: white;
	}

	hr.line{
		width:95%;
		margin-left:10px;
		border:1px solid gold;
	}

	.content-sn {
		width: 95%;
		/*height: 440px;*/
		background-color: #D9D9D9;
		margin-bottom:20px;
		margin-left:10px;
		margin-top:20px;
		/*margin-right:10px;*/
	}

</style>

<head>
	<%--<meta charset="utf-8">--%>
</head>

<section>
	<% int nb_elements = 5;%>
	
	<div class="soonNews">
	
		<div class="banniere-sn">
			<h2>Prochaines actualités :</h2>
		</div>
		<% for(int i =0; i<nb_elements; i++){ %>
		<div class="content-sn">
			Hello World :
		</div>

		<hr class="line">
		<% } %>


		<%--<div class="content-sn">
			Hello World
		</div>

		<hr class="line">

		<div class="content-sn">
			Actualité 3:
		</div>--%>
		<%-- <c:forEach var="name"  items="${requestScope['ListName']}" >
	          <option value="${ListName.nom}"> ${ListName.nom} </option>
		</c:forEach> --%>
		
	</div>
	
	
</section>