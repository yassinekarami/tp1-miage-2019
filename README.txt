TP ingénieurie logiciel
Yassine KARAMI
Noel NYUNTING

exo3 :

dans la classe mailReaderModule:

	Nous avons également utilisé l'injection de dépendande dans la classe InterpreteurLigneCommande, afin de lui injecter un mailService via l'anotation "@Inject" au dessus du constructeur qui instantie un objet de type serviceMail.

	Dans la méthode configure, nous avons lié la classe mailSender à SmtpMailSender si nous sommes en production, et à InMemoryMailSender si nous sommes en phase de test, pour que mailSender n'envoie pas des mails à des vraies adresses en masse lors des tests (les mails seront mis dans le mémoire de la machine).


exo 4 :

Pour cette question, nous devons compléter et créer un test unitaire dans MailTest et MailComparatorTest avec JUnit (@Test avant les méthodes dans un fichier test mis dans un package test préparé avec Maven) 

	Classe MailComparatorTest:
		Test complété:
				"gauxSiDeuxMailsNuls()" ==> le resultat de la comparaison doit etre égal a 0 si les deux mails ne sont pas instantié.
				"egauxSiUnDesMailsNuls()" ==> le résultat de la comparaison doit etre égal a 0 si l'un des deux mails n'est pas instantié.

		Test ajouté : 
				 "egauxSiMail1PlusImportant()" ==> si le mail1 est plus important que mail2, alors mail1 est égal a 1.
				 "egauxSiMail1MoinssStatut()"  ==> compare les status des deux mails.
				 
Nous avons utilisé la fonction assert() afin de vérifier si le résultat obtenu est bien celui qui est attendu. 

exo 5 :

Nous avons commencé par préparer 2 mails (un_premier_mail , un_second_mail)  avec des données et des paramètre, dans la méthode annoté @given.
dans la méthode annoté @writen , nous avons mis dans l'attribut résultatComparaison la valeur de la méthode mais avec mail1 et mail2.
Dans la méthode annoté @Then , nous avons mis le résultat de la comparaison de mail1 et mail2.
Les phrases ont des expression régulière pour montrer où se trouve les variables à changer. Les variables sont trié par son ordre dans les paramètres de la fonction.


Nous avons donc mis dans le fichier de configuration Cucumber les valeurs à prendre pour les itérations de tests voulu pour ces mails, afin que Cucumber fasse ces tests automatiquement sans que nous devons changer les valeurs nous même.






