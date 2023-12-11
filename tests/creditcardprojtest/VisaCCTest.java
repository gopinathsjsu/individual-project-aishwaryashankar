package creditcardprojtest;

import creditcardproj.VisaCC;
import creditcardproj.AmExCC;
import creditcardproj.CreditCard;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class VisaCCTest {

	@Test
	void checkCardValidityExpectedTrue() {
		boolean expected = true;
		String cardNumber = "4212345678909";
		CreditCard testCard = new VisaCC(cardNumber, "01-01-2024","Aishwarya");
		boolean actual = testCard.checkIfCardValid(testCard.getCardNumber());
		assertEquals(expected,actual);
	}
	
	@Test
	void checkCardValidityExpectedTrue2() {
		boolean expected = true;
		String cardNumber = "4123456789098765";
		CreditCard testCard = new VisaCC(cardNumber, "01-01-2024","Aishwarya");
		boolean actual = testCard.checkIfCardValid(testCard.getCardNumber());
		assertEquals(expected,actual);
	}
	
	@Test
	void checkCardValidityExpectedFalse() {
		boolean expected = false;
		String cardNumber = "351234567890987";
		CreditCard testCard = new VisaCC(cardNumber, "01-01-2024","Aishwarya");
		boolean actual = testCard.checkIfCardValid(testCard.getCardNumber());
		assertEquals(expected,actual);
	}

}
