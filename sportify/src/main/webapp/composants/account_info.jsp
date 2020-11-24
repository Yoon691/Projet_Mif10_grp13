<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="fr.univ.lyon1.m1if.m1if10Grp13.classes.Inscrit"%>
<%@ page import="java.text.SimpleDateFormat" %>

<% 
	SimpleDateFormat fr_date_format = new SimpleDateFormat ("d-M-yyyy");
%>
<h2 class="interface-titles"><b>Mon Profil</b></h2>
<hr class="line">
<div class="user-infos">
	<div class="container">
	  <div class="row align-items-center">
	    <div class="col-md-auto">
			<img class="profil-picture-large" src="img/default-pic.png" alt="default profil picture">
		</div>
	    <div class
					 ="col">
	    	<div class="info-name">${sessionScope.user.getNomInscrit()}</div>
	    	<hr class="subline">
	    	<div class="info-userClub">Club : ${null!=null? "club":"Vous n'�tes pas encore adh�rent d'un club."}</div>
	    </div>
	    <div class="w-100" style="margin:2vh;"></div>
	    <div class="col"> 
	    	<span class="infos-th" >Email :</span> ${sessionScope.user.getEmailInscrit()} <br> 
	    	<span class="infos-th" >T�l�phone : </span> ${sessionScope.user.getTelInscrit()}
		</div>
	    <div class="col">
	    	<span class="infos-th" >Date de naissance :</span> <fmt:formatDate pattern = "dd-MM-yyyy" value = "${sessionScope.user.getNaissanceInscrit()}" /><br> 
	    	<span class="infos-th" >Date d'inscription :</span> <fmt:formatDate pattern = "dd-MM-yyyy" value = "${sessionScope.user.getDateInscription() }" />
	    </div>
	  </div>
	</div>
</div>