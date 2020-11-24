<%@page import="fr.univ.lyon1.m1if.m1if10Grp13.classes.Club"%>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>

<h2 class="interface-titles"> <b>Liste des clubs</b> </h2>
<hr class="line">

<div class="table-responsive clubList">
  <table class="table">
	<thead class="clubList-thead">
        <tr>
          <th scope="col">Nom</th>
          <th scope="col">Email</th>
          <th scope="col">Responsable</th>
          <th scope="col">Nombre d'adhérants</th>
        </tr>
      </thead>
	<tbody>
		<c:set var="count" value="0" scope="page" />
		<c:forEach var="club" items="${sessionScope.clubList}">
		  	<tr>
		          <td class="club-name">${club.getNomClub()}</td>
		          <td class="">${club.getEmailClub()}</td>
		          <td class="">${club.getNomResponsable()}</td>
		          <td class="">${club.getNbMaxAdherent()}</td>
		          <td> <button id="club${count}" class="btn btn-primary mb-2" value="${club.getEmailClub()}" > Rejoindre </button></td>
	        </tr>
	        <a id="call${count}" href="Adherer?club="></a>
	        <c:set var="count" value="${count + 1}" scope="page"/>
		</c:forEach>
	</tbody>
  </table>
</div>
	
<script>
	for (let i=0; i<3; i++) {
		$("#club"+i).click(function() {
			console.log("club"+i);
			var email = document.getElementById("club"+i).value;
			console.log(email);
		});
	}
</script>
	