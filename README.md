NYUNTING Elbert Noel, KARAMI Yassine
---------------------------------------------------------------------------------------------
# Ex1
Des constantes pour �viter des erreurs de r��criture et de duplication (M1SUPM2, M2SUPM1 et M1EQUM2). comparerMailLePlusImportant et getMailImportant sont cr��es pour factoriser la classe pour permettre une plus simple compartimentalisation des m�thodes afin de pouvoir les r�utiliser. Le refactoring de cette classe permet une meilleure maintenance du logicielle. 

# Ex2
Cette exercice montre pourquoi nous devons d�couper l'architecture en couches
Les couches sont :

domaine : La classe Mail, qui est la structure du mail

infrastructure : Contient MailSender, qui est en relation avec les serveurs du logicielle, qui affiche le message d'envoi des mails.

presentation : les classes ClientMail et InterpreteurLigneCommande envoie au service les demandes du client, donc ces clesses se mettent dans la couche pr�sentation

service : La classe MailService transite la chouche infrastructure et pr�sentation, donc nous le mettons dans service

L'objectif de l'exercice était de nous faire comprendre le fonctionnement du découpage en couche et le but de cette architecture.

# Ex3

Dans la classe mailReaderModule:

Dans la m�thode configure, nous avons li� la classe mailSender � SmtpMailSender si nous sommes en production, et � InMemoryMailSender si nous sommes en phase de test, pour que mailSender n'envoie pas des mails � des vraies adresses en masse lors des tests (les mails seront mis dans le m�moire de la machine).

Nous avons �galement utilis� l'injection de d�pendande dans la classe InterpreteurLigneCommande, afin de lui injecter un mailService via l'anotation "@Inject" au dessus du constructeur qui instantie un objet de type serviceMail.


# Ex 4

Pour cette question, nous devons compl�ter et cr�er un test unitaire dans MailTest et MailComparatorTest avec JUnit (@Test avant les m�thodes dans un fichier test mis dans un package test pr�par� avec Maven) 

Classe MailComparatorTest:
		
Test compl�t�:

"gauxSiDeuxMailsNuls()" ==> le resultat de la comparaison doit etre �gal a 0 si les deux mails ne sont pas instanti�.

"egauxSiUnDesMailsNuls()" ==> le r�sultat de la comparaison doit etre �gal a 0 si l'un des deux mails n'est pas instanti�.

Test ajout� : 

"egauxSiMail1PlusImportant()" ==> si le mail1 est plus important que mail2, alors mail1 est �gal a 1.

"egauxSiMail1MoinssStatut()"  ==> compare les status des deux mails.
				 
Nous avons utilis� la fonction assert() afin de v�rifier si le r�sultat obtenu est bien celui qui est attendu.

Tests ajout� dans MailTest :

testDateAvant1970Erreur

testDateApres2100Erreur

premierPlusPetitSiDateNulle



# Ex5

Nous avons commenc� par pr�parer 2 mails (un_premier_mail , un_second_mail)  avec des donn�es et des param�tre, dans la m�thode annot� @given.
dans la m�thode annot� @writen , nous avons mis dans l'attribut r�sultatComparaison la valeur de la m�thode mais avec mail1 et mail2.
Dans la m�thode annot� @Then , nous avons mis le r�sultat de la comparaison de mail1 et mail2.
Les phrases ont des expression r�guli�re pour montrer o� se trouve les variables � changer. Les variables sont tri� par son ordre dans les param�tres de la fonction.


Nous avons donc mis dans le fichier de configuration Cucumber les valeurs � prendre pour les it�rations de tests voulu pour ces mails, afin que Cucumber fasse ces tests automatiquement sans que nous devons changer les valeurs nous m�me.

Cucumber est donc un bon outil des tests avec la simplicit� de son utilisation et l'efficacit� de ses r�sultats.
