package creditcardprojtest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import creditcardproj.CSVProcessor;
import creditcardproj.CreditCard;
import creditcardproj.MasterCC;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import creditcardproj.JSONProcessor;
import creditcardproj.CreditCard;
import creditcardproj.MasterCC;

class JSONProcessorTest {

	@Test
	void testProcessFile() {
		List<CreditCard> expected = new ArrayList<CreditCard>();
		CreditCard card1 = new CreditCard("4123456789098","08/26","John Doe","VisaCC","");
		CreditCard card2 = new CreditCard("4789098765456","10/24","Lisa Claire","VisaCC","");
		expected.add(card1);
		expected.add(card2);
		JSONProcessor processor = new JSONProcessor();
		List<CreditCard> actual = processor.processFile("./tests/creditcardprojtest/sampleJSONForTest.json");
		assertEquals(expected.toString(), actual.toString());
		
		
	}
	
	@Test
	void testWriteFile() throws IOException {
		List<CreditCard> expected = new ArrayList<CreditCard>();
		CreditCard card1 = new MasterCC("5567894523129089","08/26","John Doe","MasterCC","");
		CreditCard card2 = new MasterCC("5567894523129080","08/26","Jim Doe","MasterCC","");
		expected.add(card1);
		expected.add(card2);
		JSONProcessor processor = new JSONProcessor();
		processor.writeFile(expected, "./tests/creditcardprojtest/jsonOutputFileFromTest.json");
		Path filePath= Paths.get("./tests/creditcardprojtest/jsonOutputFileFromTest.json");
		String output = Files.readString(filePath);
		String expectedString = "[{\"cardType\":\"MasterCC\",\"error\":\"\",\"cardNumber\":\"5567894523129089\"},{\"cardType\":\"MasterCC\",\"error\":\"\",\"cardNumber\":\"5567894523129080\"}]";
		System.out.println("From File: ");
		System.out.println(output);
		System.out.println("Expected: ");
		System.out.println(expectedString);
		
		assertEquals(expectedString, output);
		
		
		
		
	}

}
