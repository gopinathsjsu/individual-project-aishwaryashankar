package creditcardproj;

public class VisaCC extends CreditCard{
	
	public VisaCC(String cardNumber, String expirationDate, String cardHolderName)
	{
		super(cardNumber, expirationDate, cardHolderName);
	}
	
	public VisaCC(String cardNumber, String expirationDate, String cardHolderName, String typeOfCard, String err)
	{
		super(cardNumber, expirationDate, cardHolderName, typeOfCard, err);
	}
	
	public boolean checkIfCardValid(String cardNumber)
	{
		if (super.checkIfCardValid(cardNumber))
		{
			if (cardNumber.length()==16 || cardNumber.length()==13)
			{
				char first = cardNumber.charAt(0);
				
				if (first=='4')
				{
					super.setTypeOfCard("VisaCC");
					super.setErr("");
					return true;
				}
				else
				{
					super.setTypeOfCard("Invalid card.");
					super.setErr("Invalid VisaCC - doesn't match criteria.");
				}
			}
			else
			{
				super.setTypeOfCard("Invalid card.");
				super.setErr("Invalid VisaCC - wrong card number length.");
			}
		}
		
		return false;
	}
}
