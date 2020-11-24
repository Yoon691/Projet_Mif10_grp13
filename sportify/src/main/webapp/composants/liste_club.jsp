<%@page import="fr.univ.lyon1.m1if.m1if10Grp13.classes.Club"%>

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

		<c:forEach var="club" items="${sessionScope.clubList}">
		  <tr>
	          <td class="">${club.getNomClub()}</td>
	          <td class="">${club.getEmailClub()}</td>
	          <td class="">${club.getNomResponsable()}</td>
	          <td class="">${club.getNbMaxAdherent()}</td>
	          <td> <button class="btn btn-primary mb-2" onclick="rejoindre()"> Rejoindre </button></td>
	        </tr>
		</c:forEach>
	</tbody>
  </table>
</div>
	
	
	
	
	
	
	
	