package creditcardproj;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class XMLProcessor implements Processor
{

	@Override
	public List<CreditCard> processFile(String pathFile) {
		List<CreditCard> cards = new ArrayList<CreditCard>();
		// TODO Auto-generated method stub
		
		try 
		{
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File(pathFile));
			NodeList list = doc.getElementsByTagName("CARD");
			for (int i = 0;i<list.getLength();i++)
			{
				Node node = list.item(i);
				Element element = (Element) node;
				String cardNumber = element.getElementsByTagName("CARD_NUMBER").item(0).getTextContent();
                String expirationDate = element.getElementsByTagName("EXPIRATION_DATE").item(0).getTextContent();
                String cardHolderName = element.getElementsByTagName("CARD_HOLDER_NAME").item(0).getTextContent();
                if (cardNumber.isEmpty())
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
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document xmlDoc = builder.newDocument();
			Element root = xmlDoc.createElement("CARDS");
			xmlDoc.appendChild(root);
			for (CreditCard card : cards)
			{
				String cardNumber = card.getCardNumber();
				String typeOfCard = card.getTypeOfCard();
				String err = card.getErr();
				Element curCard = xmlDoc.createElement("CARD");
				Element cardNumNode = xmlDoc.createElement("CARD_NUMBER");
				cardNumNode.appendChild(xmlDoc.createTextNode(cardNumber));
				Element cardTypeNode = xmlDoc.createElement("CARD_TYPE");
				cardTypeNode.appendChild(xmlDoc.createTextNode(typeOfCard));
				Element cardErrNode = xmlDoc.createElement("ERROR");
				cardErrNode.appendChild(xmlDoc.createTextNode(err));
				curCard.appendChild(cardNumNode);
				curCard.appendChild(cardTypeNode);
				curCard.appendChild(cardErrNode);
				root.appendChild(curCard);
				
			}
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer t = tf.newTransformer();
			t.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource d = new DOMSource(xmlDoc);
			File outputFile = new File(pathfile);
			outputFile.createNewFile();
			StreamResult output = new StreamResult(outputFile);
			t.transform(d, output);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
	}

}

