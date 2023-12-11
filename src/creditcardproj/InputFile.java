package creditcardproj;

import java.util.List;

public class InputFile {

	Processor processor;
	String inputFileName;
	String outputFileName;
	List<CreditCard> cards;
	
	public InputFile(String inputFileName)
	{
		this.inputFileName = inputFileName;
	}
	
	public void setProcessor()
	{
		int indexOfPeriod = inputFileName.indexOf('.');
		String fileExtension = inputFileName.substring(indexOfPeriod);
		if (fileExtension.equals(".csv"))
		{
			processor = new CSVProcessor();
			this.outputFileName = "./src/creditcardproj/output_file"+fileExtension;
		}
		if (fileExtension.equals(".json"))
		{
			processor = new JSONProcessor();
			this.outputFileName = "./src/creditcardproj/output_file"+fileExtension;
		}
		if (fileExtension.equals(".xml"))
		{
			processor = new XMLProcessor();
			this.outputFileName = "./src/creditcardproj/output_file"+fileExtension;
		}
		processFile();
	}
	
	private void processFile()
	{
		List<CreditCard> cards = processor.processFile("./src/creditcardproj/"+inputFileName);
		//return cards;
		this.cards = cards;
		writeFile();
	}
	
	// write to file method needed here
	private void writeFile()
	{
		processor.writeFile(this.cards, this.outputFileName);
	}
}

