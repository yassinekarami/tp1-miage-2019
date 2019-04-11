package com.acme.mailreader.domain;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.acme.mailreader.domain.Mail;
import com.acme.mailreader.domain.Mail.Statut;
import com.acme.mailreader.domain.MailComparator;

public class MailComparatorTest {
	
	private MailComparator comparator;

	@Before
	public void setUp() throws Exception {
		this.comparator = new MailComparator();
	}

	@Test
	public final void egauxSiDeuxMailsNuls() {
		Mail mail1 = null;
		Mail mail2 = null;
		assertThat(comparator.compare(mail1, mail2), is(0));
	}
	
	@Test
	public final void egauxSiUnDesMailsNuls() {
		Mail mail1 = new Mail();
		Mail mail2 = null;
		assertThat(comparator.compare(mail1, mail2), is(0));
	}
	
	@Test
	public final void egauxSiMail1PlusImportant() {
		Mail mail1 = new Mail();
		mail1.setImportant(true);
		Mail mail2 = new Mail();
		mail2.setImportant(false);
		assertThat(comparator.compare(mail1, mail2), is(1));
	}
	
	@Test
	public final void egauxSiMail1MoinssStatut() {
		Mail mail1 = new Mail();
		mail1.setStatut(Statut.UNSENT);
		Mail mail2 = new Mail();
		mail2.setStatut(Statut.SENT);
		assertThat(comparator.compare(mail1, mail2), is(-1));
	}
	
}
