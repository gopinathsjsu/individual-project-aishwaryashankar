package creditcardprojtest;


import creditcardproj.CreditCard;
import creditcardproj.InputFile;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

class InputFileTest {

	@Test
	void test() throws IOException {
		InputFile inpFile = new InputFile("testcsv.csv");
		inpFile.setProcessor();
		Path filePath= Paths.get("./src/creditcardproj/output_file.csv");
		String output = Files.readString(filePath);
		String expected = "cardNumber, cardType, err\n"
				+ "5567894523129089,MasterCC,\n";
		assertEquals(expected, output);

		
	}

}
