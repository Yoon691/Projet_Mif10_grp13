<h2>Inscription adhérent</h2>
<form method="POST" action="UserInscription">
	<div class="form-adh">
		<div class="user-box">
			<input type="text" name="nomInscrit" required="">
			<label>Nom</label>
		</div>
		<div class="user-box">
			<input type="text" name="prenomInscrit" required="">
			<label>Prénom</label>
		</div>
		<div class="user-box">
			<input type="password" name="password" required="">
			<label>Mot de passe</label>
		</div>
		<div class="user-box">
			<input type="email" name="emailInscrit" required="">
			<label>Email</label>
		</div>
		<div class="user-box">
			<input type="tel" name="telInscrit" required="">
			<label>n° téléphone</label>
		</div>
		<div class="user-box">
			<input type="date" name="naissanceInscrit" required="">
			<label>Date de naissance</label>
		</div>
	</div>
	<a>
		<span></span>
		<span></span>
		<input class="valid-form-but" type="submit" value="S'inscrire">
		<span></span>
		<span></span>
	</a>
</form>
<div class="inscrire">
	<a class="aff-connexion">Connexion</a>
	-
	<a class="aff-inscr-club">Inscription Club</a>
</div>