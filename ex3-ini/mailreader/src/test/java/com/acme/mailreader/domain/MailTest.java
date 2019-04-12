package com.acme.mailreader.domain;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.time.Instant;

import org.junit.Test;

import com.acme.mailreader.domain.Mail.Statut;

public class MailTest {
	
	MailComparator comparator = new MailComparator();	

	@Test(expected=DateIncorrecteException.class)
	public final void testDateAvant1970Erreur() throws DateIncorrecteException {
		new Mail.Builder("blabla").important(false).statut(Statut.READ).date( Instant.parse("1969-12-31")).build();
	}
	
	@Test(expected = DateIncorrecteException.class)
	public final void testDateApres2100Erreur() throws DateIncorrecteException {
		new Mail.Builder("blabla").important(false).statut(Statut.READ).date( Instant.parse("2101-01-01")).build();
	}
	
	@Test
	public final void premierPlusPetitSiDateNulle() throws DateIncorrecteException  {
		Mail mail1 = new Mail.Builder("blabla").important(false).statut(Statut.READ).build();
		Mail mail2 = new Mail.Builder("blabla").important(false).statut(Statut.READ).date(Instant.now()).build();
		assertThat(comparator.compare(mail1, mail2),is(1));
				
	}

}
