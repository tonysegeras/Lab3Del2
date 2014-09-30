package CardsException;


/**
 * Represents the suit of a playing card.
 * 
 *
 */
public enum Suit {
	HEARTS(4), SPADES(3), CLUBS(1), DIAMONDS(2);
	
	private int suit;
	
	/**
	 * Enumeration constructor.
	 * @param suit	The integer value of the desired suit.
	 */
	Suit(int suit){
		this.suit = suit;
	}
	/**
	 * 
	 * @return The integer value of this objects suit.
	 */
	public int getSuit(){
		return this.suit;
	}
	
	/**
	 * Translates integer values to a corresponding suit.
	 * @param index	The integer value of a suit.
	 * @return 		The suit corresponding to the supplied index argument.
	 */
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
