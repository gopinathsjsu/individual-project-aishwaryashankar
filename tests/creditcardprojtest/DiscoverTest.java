package creditcardprojtest;

import creditcardproj.AmExCC;
import creditcardproj.CreditCard;
import creditcardproj.Discover;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class DiscoverTest {

	@Test
	void checkCardValidityExpectedTrue() {
		boolean expected = true;
		String cardNumber = "6011123456781234";
		CreditCard testCard = new Discover(cardNumber, "01-01-2024","Aishwarya");
		boolean actual = testCard.checkIfCardValid(testCard.getCardNumber());
		assertEquals(expected,actual);
	}
	
	@Test
	void checkCardValidityExpectedFalse() {
		boolean expected = false;
		String cardNumber = "60111234567891235";
		CreditCard testCard = new Discover(cardNumber, "01-01-2024","Aishwarya");
		boolean actual = testCard.checkIfCardValid(testCard.getCardNumber());
		assertEquals(expected,actual);
	}

}
