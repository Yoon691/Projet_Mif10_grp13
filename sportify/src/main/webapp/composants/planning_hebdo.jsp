<style>
	
	.planning {
		width : 76vw;
		margin-left: 3vw;
		height: 76vh;
		margin-top: 3vh;
	}
	
	.planning-thead {
		background-color: #FDC500;
	}
	
	.table td, .table th {
		text-align : center;
		border-bottom: 1px solid #dee2e6 !important;
		border-right: 1px solid #dee2e6 !important;
	}

    .th-line {
		width: 7vw;
		background-color: #373434;
		color : #F8F8FF;
	}
    
    .occupe {
    	background-color: #ef9393;
    }
    
   	.reserve {
    	background-color: #59d9ff;
    }
    
    /*=======FORM========*/
    
    .reservation-form {
    	margin-top: 3vh;
    }
    
    .form-row {
		margin-left: 21vw;
	    text-align: center;
	    width: fit-content;
    }
    
    .col-auto {
		width: 10vw;
	}
    
    .btn-primary {
    	width: -webkit-fill-available;
    	background-color : #FDC500;
    	border: none;
    }
    .btn-primary:hover {
    	background-color : #373434;
    }
    
    /*=======\FORM========*/	
    

</style>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>

<h2 class="interface-titles"><b>Reservation</b></h2>
<hr class="line">

<div class="reservation-form">
    <form method="POST" action="Reservation">
	  <div class="form-row align-items-center">
	    <div class="col-auto">
	      <div class="form-group">
		    <label for="selectJour">Jour :</label>
		    <select class="form-control" id="selectJour" name="day">
		      <option>Lundi</option>
		      <option>Mardi</option>
		      <option>Mercredi</option>
		      <option>Jeudi</option>
		      <option>Vendredi</option>
		      <option>Samedi</option>
		      <option>Dimanche</option>
		    </select>
		  </div>
	    </div>
	    <div class="col-auto">
	      <div class="form-group">
		    <label for="selectHeure">Heure :</label>
		    <select class="form-control" id="selectHeure" name="horaire">
		     	<% for(int i=8; i < 21; i++ ) { %>
		     		<option><%=i %>h</option>
		     	<% } %>
		    </select>
		  </div>
	    </div>
	    <div class="col-auto">
	      <div class="form-group">
		    <label for="selectDuree">Duree :</label>
		    <select class="form-control" id="selectDuree" name="duree">
		     	<option>1h</option>
		     	<option>2h</option>
		     	<option>3h</option>
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

<%
   Date dNow = new Date();
   SimpleDateFormat n_semaine = new SimpleDateFormat ("w");
   String[][] tab;
   tab = new String[7][13];
   for (int i = 0; i < 7; i++){
	   for (int j = 0; j < 13; j++) {
		   tab[i][j] = "dispo";
	   }
   }
   tab[2][5] = "occupe";
   tab[2][6] = "occupe";
   tab[1][8] = "occupe";
   tab[5][1] = "occupe";
   tab[1][0] = "reserve";
%>


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
		<% for(int i=8; i < 21; i++) { %>
			<tr>
	          <th class="th-line" scope="row"><c:out value ="<%=i %>"/>h - <c:out value="<%=i+1%>"/>h</th>
	          <% for(int j=0; j < 7; j++) { %>
	          	<td class="creneau <%=tab[j][i-8]%>">Cell <c:out value="<%=j%>"/></td>
	          	<%-- <td class="creneau ${tab[0][0]}">Cell <c:out value = "<%=j%>"/></td> --%>
	          <% } %>
	         <tr>
		<% } %>
        <%-- <c:forEach var="i" begin="8" end="20" step="1">
		   <tr>
	          <th scope="row"><c:out value = "${i}"/>h - <c:out value = "${i+1}"/>h</th>
	          <c:forEach var="j" begin="0" end="6" step ="1">
	          	<td class="<%=getDispo(${i},j);%>">Cell <c:out value = "${j}"/></td>
	          </c:forEach>
	        </tr>
		</c:forEach> --%>
      </tbody>
  </table>
</div>