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

	<%-- ${requestscope["club"]
		<c:forEach var="i" begin="0" end="3" step="1">
		   <tr>
	          <td class="">club.getNomClub()</td>
	          <td class="">club.getEmailClub()</td>
	          <td class="">club.getNomResponsable()</td>
	          <td class="">7/12</td>
	          <td> <button class="btn btn-primary mb-2" onclick="rejoindre()"> Rejoindre </button></td>
	        </tr>
		</c:forEach>

	}--%>
		<c:forEach var="i" begin="0" end="3" step="1">
		   <tr>
	          <td class="">Lyon</td>
	          <td class="">Lyon@gmail.com</td>
	          <td class="">Aulas</td>
	          <td class="">7/12</td>
	          <td> <button class="btn btn-primary mb-2" onclick="rejoindre()"> Rejoindre </button></td>
	        </tr>
		</c:forEach>
	</tbody>
  </table>
</div>
	
	
	
	
	
	
	
	