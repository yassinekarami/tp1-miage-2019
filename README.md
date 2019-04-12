NYUNTING Elbert Noel, KARAMI Yassine
---------------------------------------------------------------------------------------------
# Ex1
Des constantes pour éviter des erreurs de réécriture et de duplication (M1SUPM2, M2SUPM1 et M1EQUM2). comparerMailLePlusImportant et getMailImportant sont créées pour factoriser la classe pour permettre une plus simple compartimentalisation des méthodes afin de pouvoir les réutiliser. Le refactoring de cette classe permet une meilleure maintenance du logicielle. 

# Ex2
Cette exercice montre pourquoi nous devons découper l'architecture en couches
Les couches sont :

domaine : La classe Mail, qui est la structure du mail

infrastructure : Contient MailSender, qui est en relation avec les serveurs du logicielle, qui affiche le message d'envoi des mails.

presentation : les classes ClientMail et InterpreteurLigneCommande envoie au service les demandes du client, donc ces clesses se mettent dans la couche présentation

service : La classe MailService transite la chouche infrastructure et présentation, donc nous le mettons dans service

L'objectif de l'exercice Ã©tait de nous faire comprendre le fonctionnement du dÃ©coupage en couche et le but de cette architecture.

# Ex3

Dans la classe mailReaderModule:

Dans la méthode configure, nous avons lié la classe mailSender à SmtpMailSender si nous sommes en production, et à InMemoryMailSender si nous sommes en phase de test, pour que mailSender n'envoie pas des mails à des vraies adresses en masse lors des tests (les mails seront mis dans le mémoire de la machine).

Nous avons également utilisé l'injection de dépendande dans la classe InterpreteurLigneCommande, afin de lui injecter un mailService via l'anotation "@Inject" au dessus du constructeur qui instantie un objet de type serviceMail.


# Ex 4

Pour cette question, nous devons compléter et créer un test unitaire dans MailTest et MailComparatorTest avec JUnit (@Test avant les méthodes dans un fichier test mis dans un package test préparé avec Maven) 

Classe MailComparatorTest:
		
Test complété:

"gauxSiDeuxMailsNuls()" ==> le resultat de la comparaison doit etre égal a 0 si les deux mails ne sont pas instantié.

"egauxSiUnDesMailsNuls()" ==> le résultat de la comparaison doit etre égal a 0 si l'un des deux mails n'est pas instantié.

Test ajouté : 

"egauxSiMail1PlusImportant()" ==> si le mail1 est plus important que mail2, alors mail1 est égal a 1.

"egauxSiMail1MoinssStatut()"  ==> compare les status des deux mails.
				 
Nous avons utilisé la fonction assert() afin de vérifier si le résultat obtenu est bien celui qui est attendu.

Tests ajouté dans MailTest :

testDateAvant1970Erreur

testDateApres2100Erreur

premierPlusPetitSiDateNulle



# Ex5

Nous avons commencé par préparer 2 mails (un_premier_mail , un_second_mail)  avec des données et des paramètre, dans la méthode annoté @given.
dans la méthode annoté @writen , nous avons mis dans l'attribut résultatComparaison la valeur de la méthode mais avec mail1 et mail2.
Dans la méthode annoté @Then , nous avons mis le résultat de la comparaison de mail1 et mail2.
Les phrases ont des expression régulière pour montrer où se trouve les variables à changer. Les variables sont trié par son ordre dans les paramètres de la fonction.


Nous avons donc mis dans le fichier de configuration Cucumber les valeurs à prendre pour les itérations de tests voulu pour ces mails, afin que Cucumber fasse ces tests automatiquement sans que nous devons changer les valeurs nous même.

Cucumber est donc un bon outil des tests avec la simplicité de son utilisation et l'efficacité de ses résultats.
