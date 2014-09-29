package CardsException;

import java.util.Comparator;

public class BlackjackCard extends Card implements Comparator<Card>{

	public int compare(Card o1, Card o2) {		
		return (o1.getRank().getRank() - o2.getRank().getRank());
	}
}