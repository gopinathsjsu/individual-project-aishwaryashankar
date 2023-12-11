package creditcardproj;

public class CardFactory {

	CreditCard creditCard;
	
	public CardFactory(CreditCard creditCard)
	{
		this.creditCard = creditCard;
	}
	
	public CreditCard buildCard(String cardNumber, String expirationDate, String cardHolderName)
	{
		char firstNum = cardNumber.charAt(0);
		if (firstNum == '5')
		{
			creditCard = new MasterCC(cardNumber, expirationDate, cardHolderName);
			if (creditCard.checkIfCardValid(creditCard.getCardNumber()))
			{
				creditCard = new MasterCC(cardNumber, expirationDate, cardHolderName, creditCard.getTypeOfCard(),creditCard.getErr());
			}
		}
		else if (firstNum == '4')
		{
			creditCard = new VisaCC(cardNumber, expirationDate, cardHolderName);
			if (creditCard.checkIfCardValid(creditCard.getCardNumber()))
			{
				creditCard = new VisaCC(cardNumber, expirationDate, cardHolderName, creditCard.getTypeOfCard(),creditCard.getErr());
			}
		}
		else if (firstNum == '3')
		{
			creditCard = new AmExCC(cardNumber, expirationDate, cardHolderName);
			if (creditCard.checkIfCardValid(creditCard.getCardNumber()))
			{
				creditCard = new AmExCC(cardNumber, expirationDate, cardHolderName, creditCard.getTypeOfCard(),creditCard.getErr());
			}
		}
		else if (firstNum == '6')
		{
			creditCard = new Discover(cardNumber, expirationDate, cardHolderName);
			if (creditCard.checkIfCardValid(creditCard.getCardNumber()))
			{
				creditCard = new Discover(cardNumber, expirationDate, cardHolderName, creditCard.getTypeOfCard(),creditCard.getErr());
			}
		}
		else
		{
			creditCard = new CreditCard(cardNumber, expirationDate, cardHolderName);
			creditCard.checkIfCardValid(creditCard.cardNumber);
		}
		return creditCard;
	}
}
