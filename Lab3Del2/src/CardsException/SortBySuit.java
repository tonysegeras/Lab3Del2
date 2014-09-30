package CardsException;
import java.util.Comparator;


public class SortBySuit implements Comparator<Card>{

	public int compare(Card o1, Card o2) {

		int res;
		res = o1.getSuit().getSuit() - o2.getSuit().getSuit();
		if(res == 0) {
			res = o1.getRank().getRank() - o2.getRank().getRank();
		}
		return res;	
	}

}
