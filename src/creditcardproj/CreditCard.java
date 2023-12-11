package creditcardproj;

import java.util.Objects;

public class CreditCard {
	
	String cardNumber;
	String expirationDate;
	String cardHolderName;
	String typeOfCard;
	String err;
	
	public CreditCard(String cardNumber, String expirationDate, String cardHolderName)
	{
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.cardHolderName = cardHolderName;
	}
	
	public CreditCard(String cardNumber, String expirationDate, String cardHolderName, String typeOfCard, String err)
	{
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.cardHolderName = cardHolderName;
		this.typeOfCard = typeOfCard;
		this.err = err;
	}
	
	public String getCardNumber()
	{
		return cardNumber;
	}
	
	public String getExpirationDate()
	{
		return expirationDate;
	}
	
	public String getCardHolderName()
	{
		return cardHolderName;
	}
	
	public String getTypeOfCard()
	{
		return typeOfCard;
	}
	
	public String getErr()
	{
		return err;
	}
	
	
	public void setCardNumber(String cardNumber)
	{
		this.cardNumber = cardNumber;
	}
	
	public void setExpirationDate(String expirationDate)
	{
		this.expirationDate = expirationDate;
	}
	
	public void setCardHolderName(String cardHolderName)
	{
		this.cardHolderName = cardHolderName;
	}
	
	public void setTypeOfCard(String typeOfCard)
	{
		this.typeOfCard = typeOfCard;
	}
	
	public void setErr(String err)
	{
		this.err = err;
	}
	
	public boolean checkIfCardValid(String cardNumber)
	{
		if (cardNumber.matches("[0-9]+") && !cardNumber.equals(""))
		{
			if (cardNumber.length()<=19)
			{
				return true;
			}
			else
			{
				setTypeOfCard("Invalid card.");
				setErr("Card number length exceeds 19 digits.");
				return false;
			}
		}
		else if (cardNumber.equals(" "))
		{
			setTypeOfCard("Invalid card.");
			setErr("Card number is blank.");
			return false;
		}
		else
		{
			setTypeOfCard("Invalid card.");
			setErr("Card number has non-numeric characters.");
			return false;
		}
		
		
	}
	
	public String toString()
	{
		return cardNumber + " " + expirationDate + " " + cardHolderName + " " + typeOfCard + " " + err;
	}
	
	public boolean equals(CreditCard card) {
	    return Objects.equals(cardNumber, card.cardNumber)
	            && Objects.equals(expirationDate, card.expirationDate)
	            && Objects.equals(cardHolderName, card.cardHolderName)
	            && Objects.equals(typeOfCard, card.typeOfCard)
	            && Objects.equals(err, card.err);
	}
	

}
