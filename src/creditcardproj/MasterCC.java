package creditcardproj;

public class MasterCC extends CreditCard {
	
	public MasterCC(String cardNumber, String expirationDate, String cardHolderName)
	{
		super(cardNumber, expirationDate, cardHolderName);
	}
	
	public MasterCC(String cardNumber, String expirationDate, String cardHolderName, String typeOfCard, String err)
	{
		super(cardNumber, expirationDate, cardHolderName, typeOfCard, err);
	}

	public boolean checkIfCardValid(String cardNumber)
	{
		if (super.checkIfCardValid(cardNumber))
		{
			if (cardNumber.length()==16)
			{
				char first = cardNumber.charAt(0);
				char second = cardNumber.charAt(1);
				if (first== '5' && (second=='1' || second=='2' || second=='3' || second=='4' || second=='5'))
				{
					super.setTypeOfCard("MasterCC");
					super.setErr("");
					return true;
				}
				else
				{
					super.setTypeOfCard("Invalid card.");
					super.setErr("Invalid MasterCC - doesn't match criteria.");
				}
			}
			else
			{
				super.setTypeOfCard("Invalid card.");
				super.setErr("Invalid MasterCC - wrong card number length");
			}
		}
		
		return false;
	}
}
