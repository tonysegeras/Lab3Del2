package CardsException;

import java.util.Random;

public class Card implements Comparable<Card>{
	/** Objects of this class represents cards in
	 *	a deck (of cards).
	 *	A card is immutable, i.e. once created its
	 *	rank or suit cannot be changed.
	 */
		
	private final Rank rank;
	private final Suit suit;

	public Card(){
		Random rand = new Random();

		this.rank = Rank.pollRank(rand.nextInt(13) + 1);
		this.suit = Suit.pollSuit(rand.nextInt(4) + 1);
	}

	public Card(Rank newRank, Suit newSuit) {
		this.rank = newRank;
		this.suit = newSuit;
	}
	
	public Card(int newRank, int newSuit){
		if( newRank > 13 || newSuit > 4 || newRank < 1 || newSuit < 0)
			throw new NoSuchCardException("Tried to create a card with bad values");
		this.rank = Rank.pollRank(newRank);
		this.suit = Suit.pollSuit(newSuit);
	}
	
	public Card(Card copy) {
		this.rank = copy.getRank();
		this.suit = copy.getSuit();
	}
		
	public Rank getRank() {
		return rank;
	}
		
	public Suit getSuit() {
		return suit;
	}
		
	public boolean equals(Card other) {
		return (this.getRank() == other.getRank() && this.getSuit() == other.getSuit());
	}
		
	public String toString() {
		String info = new String();
		info += this.getRank() + " of " + this.getSuit();
		return info;
	}

	public int compareTo(Card other) {
		return ((this.getRank().getRank() - other.getRank().getRank()) +
				(this.getSuit().getSuit() - other.getSuit().getSuit()));
	}
}
