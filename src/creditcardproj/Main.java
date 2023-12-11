package creditcardproj;

import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) throws Exception
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the file name: ");
		String inputFileName = scan.next();
		while (!inputFileName.equals("Quit"))
		{
			InputFile inp = new InputFile(inputFileName);
			inp.setProcessor();
			System.out.println("Please enter the file name: ");
			inputFileName = scan.next();
		}
		scan.close();
		
		
		
	}

}
