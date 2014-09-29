package CardsException;

import java.util.Random;

public class Card {
	/** Objects of this class represents cards in
	 *	a deck (of cards).
	 *	A card is immutable, i.e. once created its
	 *	rank or suit cannot be changed.
	 */
		
	private final rank rank;
	private final suit suit;

	public Card(){
		Random rand = new Random();

		this.rank = first_part.rank.pollRank(rand.nextInt(13) + 1);
		this.suit = first_part.suit.pollSuit(rand.nextInt(4) + 1);
	}

	public CardWithEnums(rank newRank, suit newSuit) {
		this.rank = newRank;
		this.suit = newSuit;
	}
	
	public CardWithEnums(int newRank, int newSuit) {
		this.rank = first_part.rank.pollRank(newRank);
		this.suit = first_part.suit.pollSuit(newSuit);
	}
		
	public rank getRank() {
		return rank;
	}
		
	public suit getSuit() {
		return suit;
	}
		
	public boolean equals(CardWithEnums other) {
		return (this.getRank() == other.getRank() && this.getSuit() == other.getSuit());
	}
		
	public String toString() {
		String info = new String();
		info += this.getRank() + " of " + this.getSuit();
		return info;
	}
}
