<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<section>
	
	
	<div class="soonNews">
	
		<div class="banniere-sn">
			<h2>Prochaines Actualités :</h2>
		</div>
		
		<c:forEach var="name"  items="${requestScope['ListName']}" >
	          <option value="${ListName.nom}"> ${ListName.nom} </option>
		</c:forEach>
		
	</div>
	
	
</section>