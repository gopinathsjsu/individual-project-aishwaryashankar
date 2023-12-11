package creditcardprojtest;

import creditcardproj.AmExCC;
import creditcardproj.CreditCard;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class AmExCCTest {

	@Test
	void checkCardValidityExpectedTrue() {
		boolean expected = true;
		String cardNumber = "341234567890987";
		CreditCard testCard = new AmExCC(cardNumber, "01-01-2024","Aishwarya");
		boolean actual = testCard.checkIfCardValid(testCard.getCardNumber());
		assertEquals(expected,actual);
	}
	
	@Test
	void checkCardValidityExpectedFalse() {
		boolean expected = false;
		String cardNumber = "351234567890987";
		CreditCard testCard = new AmExCC(cardNumber, "01-01-2024","Aishwarya");
		boolean actual = testCard.checkIfCardValid(testCard.getCardNumber());
		assertEquals(expected,actual);
	}

}
