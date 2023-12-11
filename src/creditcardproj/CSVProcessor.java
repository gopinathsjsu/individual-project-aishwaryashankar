package creditcardproj;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import java.io.FileWriter;
import java.io.PrintWriter;

public class CSVProcessor implements Processor
{

	@Override
	public List<CreditCard> processFile(String pathFile) {
		List<CreditCard> cards = new ArrayList<CreditCard>();
		// TODO Auto-generated method stub
		String line = "";
		String splitLineBy = ",";
		
		try 
		{
			File pF = new File(pathFile);
			BufferedReader reader = new BufferedReader(new FileReader(pF));
			reader.readLine();
			//System.out.println(reader.readLine());
			while ((line = reader.readLine())!=null)
			{
				String[] cardDetails = line.split(splitLineBy, -1);
				for (int i = 0;i<cardDetails.length;i++)
				{
					if(cardDetails[i].isEmpty())
					{
						cardDetails[i]=" ";
					}
				}
				CreditCard one = new CreditCard(cardDetails[0],cardDetails[1],cardDetails[2]);
				CardFactory cf = new CardFactory(one);
				one = cf.buildCard(one.getCardNumber(), one.getExpirationDate(), one.getCardHolderName());
				cards.add(one);
				
			}
			reader.close();
			return cards;
		}
		catch (Exception e)
		{
			System.out.println(e);	
			return cards;
			
		}
	
		
		
		
	}

	@Override
	public void writeFile(List<CreditCard> cards, String pathfile) {
		// TODO Auto-generated method stub
		try
		{
			File outputFile = new File(pathfile);
			outputFile.createNewFile();
			PrintWriter writer = new PrintWriter(new FileWriter(outputFile, true));
			writer.write("cardNumber, cardType, err\n");
			int ignore = 0;
			for (CreditCard card : cards)
			{
				
					String cardNumber = card.getCardNumber();
					String typeOfCard = card.getTypeOfCard();
					String err = card.getErr();
					writer.write(cardNumber + "," + typeOfCard + "," + err + "\n");
				
				
			}
			writer.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		
	}

}
