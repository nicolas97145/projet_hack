Pour lancer le projet, il faut l'ouvrir et le lancer via un serveur TomCat.

Une fois le projet lancé, on arrive sur une page d'accueil. Sur cette page d'accueil l'utilisateur peut se connecter ou s'inscrire.


Pour la démonstration, un utilisateur "user" "user" est déjà crée.

Connectez vous avec ces informations de connexion pour arriver sur la page d'accueil de l'utilisateur.
De là, vous pourrez souscrire à un contrat, consulter vos contrats et déclarer un sinistre.


Explications des différentes fonctionnalités :

* Inscription : Pour s'inscrire l'utilisateur doit remplir un formulaire dans lequel il doit renseigner ses informations personnelles :
nom, prénom, date de naissance, sexe, mail, mot de passe, le type de bac obtenu (général, professionnel, technologique).
Une fois le formulaire rempli, l'utilisateur clique sur envoyer et est redirigé vers la page d'accueil utilisateur.


* Souscrire à un contrat :

En cliquant sur souscrire à un contrat l'utilisateur est redirigé vers la page de souscription à un contrat.
L'utilisateur renseignera dans un premier temps son année d'étude supérieure, son cyle, son cursus ainsi que le prix de l'année d'étude concernée.
Ensuite il devra indiquer dans une seconde page la date de début de son contrat correspondant à la date de début de son année scolaire. La date de fin 
du contrat correspond à la date de début à laquelle on ajoute 1 an et est donc calculer automatiquement.
Conditions pour être admissible à la souscription d'un contrat :
	- Le coût de l'école doit être inférieure à 10 000 euros.
	- La pourcentage de chance que l'élève réussisse l'année doit être supérieur ou égal à 60%

Si il est admissible, une page de récapitulatif avec les informations du contrat sera affichée. Sinon, il sera informé qu'il n'est pas admissible à la
souscription d'un contrat.


* Consulter vos contrats :

En cliquant sur consulter vos contrats, l'utilisateur arrive sur une page où il pourra consulter tous ses contrats s'il en possède.
Sinon un message lui indiquant qu'il n'a souscrit à aucun contrat sera affiché.



* Déclarer un sinistre :

En cliquant sur déclarer un sinistre, si l'utilisateur possède un contrat valide,
alors il se rend sur la page qui lui permet de rentrer ses notes des deux semestres correspondants à l'année en cours.
Sinon, il ne peut pas acceder à cette page.

L'utilisateur va donc rentrer ses deux notes, et valider.
On calcule donc selon son cycle d'étude et le prix de son année la somme que l'on devra lui rembourser en fonction des notes qu'il a obtenues.
Puis l'utilisateur est renvoyé sur un écran de confirmation de gestion de son sinistre sauf s'il avait déjà un sinistre en cours sur ce contrat,
auquel cas il est renvoyé à la page d'accueil.