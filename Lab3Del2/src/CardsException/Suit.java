package CardsException;

public enum Suit {
	HEARTS(4), SPADES(3), CLUBS(1), DIAMONDS(2);
	
	private int suit;
	
	Suit(int suit){
		this.suit = suit;
	}
	
	public int getSuit(){
		return this.suit;
	}
	
	public static Suit pollSuit(int index){
		switch(index){
		case 1:
			return CLUBS;
		case 2:
			return DIAMONDS;
		case 3:
			return SPADES;
		case 4:
			return HEARTS;
		default:
			return null;
		}
	}
}
