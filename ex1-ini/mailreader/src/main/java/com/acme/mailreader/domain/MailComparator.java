package com.acme.mailreader.domain;

import java.util.Comparator;

/**
 * Comparateur de mails
 * 
 * Comme on désire afficher les mails les plus importants en premier, l'element le plus grand retourne une valeur négative
 *
 */
public class MailComparator implements Comparator<Mail> {

	public static final int M1SUPM2 = 1;
	public static final int M2SUPM1 = -1;
	public static final int M1EQUM2 = 0;
	
	public int compare(Mail mail1, Mail mail2) {
		int result;
		if (mail1 == null || mail2 == null) {
			result = M1EQUM2;
		}else if (mail1.getSujet() != mail2.getSujet()) {
			result = mail2.getSujet().compareTo(mail1.getSujet());
		}else if (mail1.getStatut() != mail2.getStatut()) {
			result = this.comparerMailLePlusImportant(mail1,mail2);
		}else if (mail1.isImportant() != mail2.isImportant()) {
			result = this.getMailImportant(mail1, mail2);
		}else {
			result =  mail1.getDate().compareTo(mail2.getDate());
		}
		return result;
	}

	private int comparerMailLePlusImportant(Mail mail1, Mail mail2) {
		int result;

		if(mail1.getStatut().ordinal()- mail2.getStatut().ordinal()>M1EQUM2) {
			result = M1SUPM2;
		}else {
			result = M2SUPM1;
		}
		
		return result;
	}
	
	private int getMailImportant(Mail mail1, Mail mail2) {
		int result;
		if (mail1.isImportant() && !mail2.isImportant()) {
			result = M1SUPM2;
		} else {
			result =  M2SUPM1;
		}
		return result;
	}
	
	

}
