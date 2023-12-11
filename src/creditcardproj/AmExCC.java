package creditcardproj;

public class AmExCC extends CreditCard{
	public AmExCC(String cardNumber, String expirationDate, String cardHolderName)
	{
		super(cardNumber, expirationDate, cardHolderName);
	}
	
	public AmExCC(String cardNumber, String expirationDate, String cardHolderName, String typeOfCard, String err)
	{
		super(cardNumber, expirationDate, cardHolderName, typeOfCard, err);
	}
	
	
	public boolean checkIfCardValid(String cardNumber)
	{
		if (super.checkIfCardValid(cardNumber))
		{
			if (cardNumber.length()==15)
			{
				if (cardNumber.charAt(0)=='3' && (cardNumber.charAt(1)=='4' || cardNumber.charAt(1)=='7'))
				{
					super.setTypeOfCard("AmExCC");
					super.setErr("");
					return true;
				}
				else
				{
					super.setTypeOfCard("Invalid card.");
					super.setErr("Invalid AmExCC - doesn't match criteria.");
				}
			}
			else
			{
				
				super.setTypeOfCard("Invalid card.");
				super.setErr("Invalid AmExCC - wrong card number length.");
				
			}
		}
		
		return false;
	}
}
