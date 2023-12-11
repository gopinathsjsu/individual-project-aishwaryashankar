package creditcardprojtest;


import creditcardproj.CreditCard;
import creditcardproj.MasterCC;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class MasterCCTest {

	@Test
	void checkCardValidityExpectedTrue() {
		boolean expected = true;
		String cardNumber = "5512345678909812";
		CreditCard testCard = new MasterCC(cardNumber, "01-01-2024","Aishwarya");
		boolean actual = testCard.checkIfCardValid(testCard.getCardNumber());
		assertEquals(expected,actual);
	}
	
	@Test
	void checkCardValidityExpectedFalse() {
		boolean expected = false;
		String cardNumber = "5612345678901255";
		CreditCard testCard = new MasterCC(cardNumber, "01-01-2024","Aishwarya");
		boolean actual = testCard.checkIfCardValid(testCard.getCardNumber());
		assertEquals(expected,actual);
	}

}
