<div class="club-info">
	<img class="profil-picture" src="../img/default-pic.png" alt="default profil picture">
     <div class="club-name">${sessionScope.club.getNomClub()}</div>
     <div class="club-coach">coach : ${sessionScope.club.getNomResponsable()}</div>
</div>

<div class="btn-list">
	<button class="menu-button home-button" onclick="showAccueil()">Accueil</button>
	<button class="menu-button calendrier-button" onclick="showCalendrier()">Reserver</button>
	<button class="menu-button event-button">Creer un évenement</button>
	<button class="menu-button club-button">Liste des adhérents</button>
	<button class="menu-button profil-button" onclick="showProfil()">Compte Club</button>
</div>


<script>
	function showAccueil(){
		document.getElementById("accueil").style.display="block";
		document.getElementById("reserver").style.display="none";
		document.getElementById("profil").style.display="none";
	}

	function showCalendrier(){
		document.getElementById("accueil").style.display="none";
		document.getElementById("reserver").style.display="block";
		document.getElementById("profil").style.display="none";
	}

	function showProfil(){
		document.getElementById("accueil").style.display="none";
		document.getElementById("reserver").style.display="none";
		document.getElementById("profil").style.display="block";
	}
</script>