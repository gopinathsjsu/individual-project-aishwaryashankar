package creditcardprojtest;

import creditcardproj.CreditCard;
import creditcardproj.XMLProcessor;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class XMLProcessorTest {

	
	@Test
	void testProcessFile() {
		List<CreditCard> expected = new ArrayList<CreditCard>();
		CreditCard card1 = new CreditCard("4123456789098","08/26","John Doe","VisaCC","");
		CreditCard card2 = new CreditCard("4789098765456","10/24","Lisa Claire","VisaCC","");
		expected.add(card1);
		expected.add(card2);
		XMLProcessor processor = new XMLProcessor();
		List<CreditCard> actual = processor.processFile("./tests/creditcardprojtest/sampleXMLForTest.xml");
		//System.out.println(expected);
		//System.out.println(actual);
		assertEquals(expected.toString(), actual.toString());
		
		
	}
	
	
	@Test
	void testWriteFile() throws IOException {
		List<CreditCard> expected = new ArrayList<CreditCard>();
		CreditCard card1 = new CreditCard("4123456789098","08/26","John Doe","VisaCC","");
		CreditCard card2 = new CreditCard("4789098765456","10/24","Lisa Claire","VisaCC","");
		expected.add(card1);
		expected.add(card2);
		XMLProcessor processor = new XMLProcessor();
		processor.writeFile(expected, "./tests/creditcardprojtest/xmlOutputFileFromTest.xml");
		Path filePath= Paths.get("./tests/creditcardprojtest/xmlOutputFileFromTest.xml");
		String output = Files.readString(filePath);
		String expectedString ="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n"
				+ "<CARDS>\n"
				+ "    <CARD>\n"
				+ "        <CARD_NUMBER>4123456789098</CARD_NUMBER>\n"
				+ "        <CARD_TYPE>VisaCC</CARD_TYPE>\n"
				+ "        <ERROR/>\n"
				+ "    </CARD>\n"
				+ "    <CARD>\n"
				+ "        <CARD_NUMBER>4789098765456</CARD_NUMBER>\n"
				+ "        <CARD_TYPE>VisaCC</CARD_TYPE>\n"
				+ "        <ERROR/>\n"
				+ "    </CARD>\n"
				+ "</CARDS>" ;
		//System.out.println("From File: ");
		//System.out.println(output);
		output = output.replaceAll("\\s+","");
		//System.out.println("Expected: ");
		expectedString = expectedString.replaceAll("\\s+","");
		//System.out.println(expectedString);
		
		assertEquals(expectedString, output);
		
		
		
		
	}
	

}
