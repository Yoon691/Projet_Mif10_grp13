# SPORTIFY 

Le guide de configuration de l'environnement de travaille est orienté pour Linux, cependant certain aux seins de l'équipe ont travaillé sous windows. 
Pour travailler sous windows nous vous conseillons d'installer le *sous-système Windows pour Linux* : [WSL]. 

## Télécharger le projet 
***

Créez un nouveau repertoire de travail. 
Ouvrez un terminal dans ce repertoire et faite un clone du projet :  

```sh
git clone https://forge.univ-lyon1.fr/p1711842/projet_mif10_grp13.git
```

## Configuration d'une Base de Donnée local
***

Pour pouvoir travailler sur le projet **sportify** et tester les fonctionnalités, il vous faudra configurer un base de donnée local. Vous pourrez ainsi créer/supprimer des comptes à votre guise pour tester les nouvelles implémentations selon vos besoins. 

Commencez par installer postgresql : 
```sh
sudo apt install postgresql
```
Si vous rencontrez des soucis voici un guide plus détaillé : [Installer Postgresql].
Démarrez le serveur postgres : 
```sh
sudo service postgresql start
```

Placez vous dans le repertoire du projet. Vous devez maintenant créer un utilisateur qui sera propriétaire de votre BD. 
```sh
sudo su postgres 
```
```sh
psql -U postgres
```
Vous êtes désormais dans le terminal de psql. Creez un utilisateur ainsi :
```sh
=# CREATE USER <nom_utilisateur>;
=# ALTER ROLE <nom_utilisateur> WITH CREATEBD;
=# ALTER USER <nom_utilisateur> WITH ENCRYPYED PASSWORD 'motdepasse';
=# ALTER ROLE <nom_utilisateur> WITH SUPERUSER;
```
Creez une Base de donnée : 
```sh
=# CREATE DATABASE <nom_base_de_donnee> OWNER <nom_utilisateur>;
```
Vous pouvez vérifier que l'utilisateur a bien été créé avec ```\du```et la base de donnée ```\l```. Puis quittez avec ```\q``` ou ```exit```.
Connectez-vous à cette nouvelle base de donnée : 
```sh
psql -h localhsot -U <nom_utilisateur> <nom_base_de_donnee>
```
Executez le fichier sql qui est fourni dans ``> sportify/src/main/resources/sportify_database_1.sql``.
```sh
=# \i sportify_database_1.sql
```
Pour vérifier la création des tables avec `\d`. Ici vous pouvez également faire des requêtes SQL pour vérifier les comptes par exemple. A partir de la votre base de donnée est prête. Mais il reste une étape, ouvrez le fichier *persistance.xml* qui se trouve dans le repertoire `> sportify/src/main/resources/META-INF`. Vous devez modifier les lignes suivantes : 

- **url** : remplacez dans la value de l'url `sportify_db` par le nom de votre base de donnée.
- **user** : remplacez la value `sportify` par le nom de votre utilisateur de postgres.
- **password** : remplacez la value `p2020623` par le mot de passe de votre utilisateur postgres.

:warning: N'ajoutez pas ce fichier lors de vos commit ! (Vous pouvez l'ajouter au .gitignore) :warning:

Votre base de donnée est prête !

## La compilation 
***

Le projet utilise l'outil Maven pour la compilation. Installez maven avec : 

```sh
apt install git maven
```

Le projet est décrit dans le fichier `pom.xml`. Vous devez vous placez dans la repertoire *sportify* pour le compiler. 
  
- `mvn clean package` compile le projet et génère un fichier Web ARchive (*.war* qui nous sera utile plsu tard)
- `mvn tests` lance les tests

## Configuration du serveur
***

### Installation de tomcat
Bon... pour l'instant vous avec un base de donnée, un projet qui compile correctement. Il serais temps de configurer un serveur pour vous permettre de visualiser l'application dans un navigateur non ?

Rendez-vous sur le site de tomcat [Tomcat], et téléachargez la version du core qui correspond à votre configuration. 
Décompressez simplement l'archive où vous le souhaitez (en dehors du clone du projet).
Pour démarrer Tomcat, lancez le script `startup.sh` ou `startup.bat` dans bin. Pour l'arrêter, `shutdown.sh` ou `shutdown.bat` dans le même répertoire.

Testez le fonctionnement de votre serveur à l'adresse http://localhost:8080/.

### Configuration de tomcat
Vous allez modifier la configuration (répertoire `conf` de votre installation) pour :

Ajouter deux utilisateurs managers dans le fichier tomcat-users.xml : 
- L'un vous servira à accéder à l'interface Web de configuration (http://localhost:8080/manager/html).
- L'autre permettra à votre IDE de contrôler le serveur à l'aide de scripts

Modifier l'encodage par défaut (ISO-8859-1) utilisé pour décoder les paramètres des requêtes :
- Dans le fichier **Server.xml**, rajouter à l'élément Connector les attributs URIEncoding="UTF-8" et useBodyEncodingForURI="true" (voir doc ici).
- Dans le fichier **web.xml**, décommenter les deux blocs qui spécifient le CharacterEncodingFilter. (ne pas oublier de décommenter à la fois le bloc `<filter>` et le bloc `<filter-mapping>`).

Redémarrez Tomcat et connectez-vous en tant qu'utilisateur administrateur à l'interface d'administration, pour voir si cela fonctionne. 

### configurez votre IDE
Configurez votre IDE pour qu'il puisse également démarrer et arrêter Tomcat. Nous prendrons l'exemple avec Eclipse. 

Allez dans `show view > other > servers`, un onglet devrais s'ouvrir, cliquez sur le liens pour creer un nouveaux serveur. Selectionnez `Tomcat v9.0` et ajoutez le chemin vers le repertoir tomcat que nous venons de décompresser. 

Vous avez désormais un serveur qui apparait dans l'onglet. Double cliquez sur ce serveur. Vous êtes alors sur l'overview, allez dans `modules`, puis `Add External Web Module...`, et dans `Document base` ajoutez le chemin vers le repertoire `sportify/target/sportify` du projet. Validez. 

Pour Eclipse plus en détails : [Configurer tomcat sur Eclipse]. (Partie 1 & 4)









[Configurer tomcat sur Eclipse]: <http://blog.paumard.org/tutoriaux/eclipse-tomcat/>
[Tomcat]: <https://tomcat.apache.org/download-90.cgi>
[WSL]: <https://docs.microsoft.com/fr-fr/windows/wsl/install-win10>
[Installer Postgresql]: <https://computingforgeeks.com/install-postgresql-12-on-ubuntu/>