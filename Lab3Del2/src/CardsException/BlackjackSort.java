package CardsException;

import java.util.Comparator;

/**
 * Sorts cards by rank. Cards with the same rank are ordered by suit.
 */
public class BlackjackSort implements Comparator<Card>{

	public int compare(Card o1, Card o2) {		
		int res;
		res = o1.getRank().getRank() - o2.getRank().getRank();
		if(res == 0) {
			res = o1.getSuit().getSuit() - o2.getSuit().getSuit();
		}
		return res;	
	}
}
