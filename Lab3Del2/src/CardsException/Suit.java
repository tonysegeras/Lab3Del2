package CardsException;

public enum Suit {
	HEARTS(1), SPADES(2), CLUBS(3), DIAMONDS(4);
	
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
			return HEARTS;
		case 2:
			return SPADES;
		case 3:
			return CLUBS;
		case 4:
			return DIAMONDS;
		default:
			return null;
		}
	}
}
