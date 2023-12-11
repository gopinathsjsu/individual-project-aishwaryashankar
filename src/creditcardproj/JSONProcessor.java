package creditcardproj;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.*;
import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class JSONProcessor implements Processor
{

	@Override
	public List<CreditCard> processFile(String pathFile) {
		List<CreditCard> cards = new ArrayList<CreditCard>();
		// TODO Auto-generated method stub
		
		try 
		{
			
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader(pathFile));

		    JSONObject jsonObject = (JSONObject) obj;

		    JSONArray solutions = (JSONArray) jsonObject.get("cards");

		    Iterator iterator = solutions.iterator();
		    while (iterator.hasNext()) {
		        //System.out.println(iterator.next());
		        JSONObject card = (JSONObject) iterator.next();
		        String cardNumber = (String) card.get("cardNumber");
		        String expirationDate = (String) card.get("expirationDate");
		        String cardHolderName = (String) card.get("cardHolderName");
		        if (cardNumber == null)
		        {
		        	cardNumber = " ";
		        }
		        CreditCard one = new CreditCard(cardNumber,expirationDate,cardHolderName);
				CardFactory cf = new CardFactory(one);
				one = cf.buildCard(one.getCardNumber(), one.getExpirationDate(), one.getCardHolderName());
				cards.add(one);
		    }
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
			PrintWriter writer = new PrintWriter(new FileWriter(outputFile,true));
			JSONArray jsonArr = new JSONArray();
			for (CreditCard card : cards)
			{
				String cardNumber = card.getCardNumber();
				String typeOfCard = card.getTypeOfCard();
				String err = card.getErr();
				JSONObject obj = new JSONObject();
				obj.put("cardNumber", cardNumber);
				obj.put("cardType", typeOfCard);
				obj.put("error", err);
				//String stringified = obj.toString();
				//writer.write(stringified);
				jsonArr.add(obj);
			}
			writer.write(jsonArr.toJSONString());
			writer.close();
		
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		

		
	
	}

}
