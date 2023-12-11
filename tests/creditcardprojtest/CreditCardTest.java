package creditcardprojtest;

import creditcardproj.CreditCard;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;


class CreditCardTest {

	@Test
	void checkCardValidityExpectedTrue() {
		boolean expected = true;
		String cardNumber = "123456789123456789";
		CreditCard testCard = new CreditCard(cardNumber, "01-01-2024","Aishwarya");
		boolean actual = testCard.checkIfCardValid(testCard.getCardNumber());
		assertEquals(expected,actual);
	}
	
	@Test
	void checkCardValidityBlankCard() {
		boolean expected = false;
		String cardNumber = "";
		CreditCard testCard = new CreditCard(cardNumber, "01-01-2024","Aishwarya");
		boolean actual = testCard.checkIfCardValid(testCard.getCardNumber());
		assertEquals(expected,actual);
	}
	
	@Test
	void checkCardValidityNonNumericCard() {
		boolean expected = false;
		String cardNumber = "*12345*12345";
		CreditCard testCard = new CreditCard(cardNumber, "01-01-2024","Aishwarya");
		boolean actual = testCard.checkIfCardValid(testCard.getCardNumber());
		assertEquals(expected,actual);
	}
	
	@Test
	void checkEqualMethodExpectedTrue() {
		boolean expected = true;
		String cardNumber1 = "1234512345";
		String cardNumber2 = "1234512345";
		CreditCard testCard1 = new CreditCard(cardNumber1, "01-01-2024","Aishwarya");
		CreditCard testCard2 = new CreditCard(cardNumber2, "01-01-2024","Aishwarya");
		boolean actual = testCard1.equals(testCard2);
		assertEquals(expected,actual);
	}
	
	@Test
	void checkEqualMethodExpectedFalse() {
		boolean expected = false;
		String cardNumber1 = "1234512345";
		String cardNumber2 = "1234512345";
		CreditCard testCard1 = new CreditCard(cardNumber1, "01-01-2024","Ashwarya");
		CreditCard testCard2 = new CreditCard(cardNumber2, "01-01-2024","Aishwarya");
		boolean actual = testCard1.equals(testCard2);
		assertEquals(expected,actual);
	}
	
}
