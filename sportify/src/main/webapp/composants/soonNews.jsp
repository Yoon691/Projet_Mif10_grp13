<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
	.soonNews {
		width: 430px;
		heigth: 500px;
		border: solid red 3px;
	}

	.banniere-sn {
		width: 100%;
		heigth: 60px;
		background-color: #282828;
	}

	.banniere-sn h2 {
		color: white;
	}

	.content-sn {
		width: 100%;
		/*height: 440px;*/
		background-color: #DAE1E2;
		margin-bottom:20px;
		margin-left:10px;
		margin-right:10px;
	}

</style>
<head>
	<meta charset="UTF-8">
</head>

<section>
	
	
	<div class="soonNews">
	
		<div class="banniere-sn">
			<h2>Prochaines Actualités :</h2>
		</div>
		
		<div class="content-sn">
			Hello World Je teste le contenu :) Quand on met un contenu qui est long
		</div>

		<div class="content-sn">
			Hello World
		</div>
		<%-- <c:forEach var="name"  items="${requestScope['ListName']}" >
	          <option value="${ListName.nom}"> ${ListName.nom} </option>
		</c:forEach> --%>
		
	</div>
	
	
</section>