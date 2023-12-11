package creditcardproj;

public class Discover extends CreditCard{
	
	public Discover(String cardNumber, String expirationDate, String cardHolderName)
	{
		super(cardNumber, expirationDate, cardHolderName);
	}
	
	public Discover(String cardNumber, String expirationDate, String cardHolderName, String typeOfCard, String err)
	{
		super(cardNumber, expirationDate, cardHolderName, typeOfCard, err);
	}
	
	public boolean checkIfCardValid(String cardNumber)
	{
		if (super.checkIfCardValid(cardNumber))
		{
			if (cardNumber.length()==16)
			{
				if (cardNumber.substring(0, 4).equals("6011"))
				{
					super.setTypeOfCard("Discover");
					super.setErr("");
					return true;
				}
				else
				{
					super.setTypeOfCard("Invalid card.");
					super.setErr("Invalid Discover - doesn't match criteria.");
				}
			}
			else
			{
				
				super.setTypeOfCard("Invalid card.");
				super.setErr("Invalid Discover - wrong card number length.");
				
			}
		}
		
		
		return false;
	}

}
