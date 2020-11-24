<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>


<%
   Date dNow = new Date();
   SimpleDateFormat n_semaine = new SimpleDateFormat ("w");
   SimpleDateFormat YMD = new SimpleDateFormat ("yyyy-MM-dd");
%>

<h2 class="interface-titles"><b>Reservation</b></h2>
<hr class="line">

<div class="reservation-form">
    <form method="POST" action="Reserve">
	  <div class="form-row align-items-center">
	    <div class="col-auto">
	      <div class="form-group">
		    <label for="selectJour">Jour :</label>
		    <input type="date" id="day" name="day"
       				value="<%=YMD.format(dNow)%>"
       				min="<%=YMD.format(dNow)%>">
		  </div>
	    </div>
	    <div class="col-auto">
	      <div class="form-group">
		    <label for="selectHeur">Heure :</label>
		    <select class="form-control" id="selectHeure" name="horaire">
		     	<c:forEach var="i" begin="8" end="20" step="1">
		     		<option value="${i}">${i}h</option>
		     	</c:forEach>
		    </select>
		  </div>
	    </div>
	    <div class="col-auto">
	      <div class="form-group">
		    <label for="selectDuree">Duree :</label>
		    <select class="form-control" id="selectDuree" name="duree">
		     	<option value="1">1h</option>
		     	<option value="2">2h</option>
		     	<option value="3">3h</option>
		    </select>
		  </div>
	    </div>
	    <div class="col-auto">
	    	<label></label>
	    	<button type="submit" class="btn btn-primary mb-2">Reserver</button>
	    </div>
	  </div>
	</form>
</div>

<div class="table-responsive planning">
  <table class="table">
	<thead class="planning-thead">
        <tr>
          <th scope="col">Sem. <%=n_semaine.format(dNow)%></th>
          <th scope="col">Lundi</th>
          <th scope="col">Mardi</th>
          <th scope="col">Mercredi</th>
          <th scope="col">Jeudi</th>
          <th scope="col">Vendredi</th>
          <th scope="col">Samedi</th>
          <th scope="col">Dimanche</th>
        </tr>
      </thead>
	<tbody>
       <c:forEach var="i" begin="8" end="20" step="1">
		   <tr>
	          <th class="th-line" scope="row">${i}h - ${i+1}h</th>
	          <c:forEach var="j" begin="0" end="6" step ="1">
	          	<td class="creneau ${applicationScope['daoReservation'].creneauDispo(String.format('0%d:00:00',i), j, sessionScope.user)}">
	          		Cell <c:out value = "${j}"/>
	          	</td>
	          </c:forEach>
	        </tr>
		</c:forEach> 
      </tbody>
  </table>
</div>