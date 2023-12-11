package creditcardproj;

import java.util.List;

public interface Processor {
	List<CreditCard> processFile(String pathFile);
	void writeFile(List<CreditCard> cards, String pathfile);
}
