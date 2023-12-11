package creditcardprojtest;

import creditcardproj.CardFactory;
import creditcardproj.AmExCC;
import creditcardproj.MasterCC;
import creditcardproj.CreditCard;
import creditcardproj.Discover;
import creditcardproj.VisaCC;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class CardFactoryTest {

	@Test
	void buildCardExpectedAmExCC() {
		CreditCard card = new CreditCard("341234567890987","","");
		CardFactory factory = new CardFactory(card);
		card = factory.buildCard(card.getCardNumber(),card.getExpirationDate(),card.getCardHolderName());
		assertTrue(card instanceof AmExCC);
		
	}
	
	@Test
	void buildCardExpectedDiscover() {
		CreditCard card = new CreditCard("6011123456789098","","");
		CardFactory factory = new CardFactory(card);
		card = factory.buildCard(card.getCardNumber(),card.getExpirationDate(),card.getCardHolderName());
		assertTrue(card instanceof Discover);
	}
	
	@Test
	void buildCardExpectedVisaCC() {
		CreditCard card = new CreditCard("401112345678909","","");
		CardFactory factory = new CardFactory(card);
		card = factory.buildCard(card.getCardNumber(),card.getExpirationDate(),card.getCardHolderName());
		assertTrue(card instanceof VisaCC);
	}
	
	@Test
	void buildCardExpectedMasterCC() {
		CreditCard card = new CreditCard("51012345678909","","");
		CardFactory factory = new CardFactory(card);
		card = factory.buildCard(card.getCardNumber(),card.getExpirationDate(),card.getCardHolderName());
		assertTrue(card instanceof MasterCC);
	}
	
	@Test
	void buildCardExpectedCreditCard() {
		CreditCard card = new CreditCard("1234567890987654321","","");
		CardFactory factory = new CardFactory(card);
		card = factory.buildCard(card.getCardNumber(),card.getExpirationDate(),card.getCardHolderName());
		assertTrue(card instanceof CreditCard);
	}

}
