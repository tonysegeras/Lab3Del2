package CardsException;

import java.util.Comparator;

public class BlackjackCard extends Card implements Comparator<BlackjackCard>{
	
	public BlackjackCard(){
		super();
	}
	
	public BlackjackCard(Rank rank, Suit suit){
		super(rank, suit);
	}

	public BlackjackCard(int rank, int suit){
		super(rank, suit);
	}
	
	public BlackjackCard(Card copy){
		super(copy);
	}
	
	public int compare(BlackjackCard o1, BlackjackCard o2) {
		return (o1.getRank().getRank() - o2.getRank().getRank());
	}
}