<style>
	.container {
		width :30vw;
		text-align: center;
	}
	
	.col-top, .col-content {
		padding-left : 0;
		padding-right: 0;
	}
	
	.col-top {
		font-family: monospace;
    	font-size: xxx-large;
    	cursor: pointer;
    	
	}
	
	.col-top-center {
		font-family: monospace;
    	font-size: xxx-large;
		border-left: 1px solid #dee2e6;
		border-right: 1px solid #dee2e6;
	}
	
	.row-top {
		border-top: 2px solid #a7a8a9;
	    border-left: 2px solid #a7a8a9;
	    border-right: 2px solid #a7a8a9;
	    border-radius: 30px 30px 0px 0px;
	    background-color: #FDC500 ;
	}
	
	.row-content {
		border-right: 2px solid #a7a8a9;
    	border-left: 2px solid #a7a8a9;
   		border-bottom: 2px solid #a7a8a9;
   	}
	
	.table {
		margin-bottom: 0;
	}
	
</style>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>


<%-- <jsp:useBean id="date" type="java.util.Date" scope="session"/> --%>


<%
	Date dNow = new Date();
	SimpleDateFormat jour = new SimpleDateFormat ("E");
%>


<div class="container">
  <div class="row row-top">
    <a class="col col-top">
      <
    </a>
    <div class="col col-top-center">
      <%=jour.format(dNow)%>
    </div>
    <a class="col col-top">
      >
    </a>
  </div>
  <div class="row row-content">
    <div class="col col-content">
      <div class="table-responsive">
			<table class="table">
				<tbody>
					<% for(int i=8; i < 21; i++) { %>
					<tr>
			          	<th class="th-line" scope="row"><c:out value = "<%=i%>"/>h - <c:out value = "<%=i+1%>"/>h</th>
			          	<td class="creneau">Cell </td>
			         <tr>
					<% } %>
				</tbody>
			</table>
		</div>
    </div>
  </div>
</div>