package creditcardprojtest;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import creditcardproj.CreditCard;
import creditcardproj.MasterCC;
import creditcardproj.CSVProcessor;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class CSVProcessorTest {

	@Test
	void testProcessFile() {
		List<CreditCard> expected = new ArrayList<CreditCard>();
		CreditCard card1 = new MasterCC("5567894523129089","08/26","John Doe","MasterCC","");
		CreditCard card2 = new MasterCC("5567894523129080","08/26","Jim Doe","MasterCC","");
		expected.add(card1);
		expected.add(card2);
		CSVProcessor processor = new CSVProcessor();
		List<CreditCard> actual = processor.processFile("./tests/creditcardprojtest/sampleCSVForTest.csv");
		actual = actual.subList(0,actual.size());
		assertEquals(expected.toString(), actual.toString());
		
		
	}
	
	
	@Test
	void testWriteFile() throws IOException {
		List<CreditCard> expected = new ArrayList<CreditCard>();
		CreditCard card1 = new MasterCC("5567894523129089","08/26","John Doe","MasterCC","");
		CreditCard card2 = new MasterCC("5567894523129080","08/26","Jim Doe","MasterCC","");
		expected.add(card1);
		expected.add(card2);
		CSVProcessor processor = new CSVProcessor();
		processor.writeFile(expected, "./tests/creditcardprojtest/csvOutputFileFromTest.csv");
		Path filePath= Paths.get("./tests/creditcardprojtest/csvOutputFileFromTest.csv");
		String output = Files.readString(filePath);
		String expectedString = "cardNumber, cardType, err\n"
				+ "5567894523129089,MasterCC,\n"
				+ "5567894523129080,MasterCC,\n"
				+ "";
		System.out.println("From File: ");
		System.out.println(output);
		System.out.println("Expected: ");
		System.out.println(expectedString);
		
		assertEquals(expectedString, output);
		
		
		
		
	}
	

}
