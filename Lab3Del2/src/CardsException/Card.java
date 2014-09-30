package CardsException;


import java.util.Random;

/** 
 * Objects of this class represents cards in
 * a deck (of cards).
 * A card is immutable, i.e. once created its
 * rank or suit cannot be changed.
 */

public class Card{
	private final Rank rank;
	private final Suit suit;

	
	/**
	 * Class constructor. Creates a card of a random rank and suit.
	 */
	public Card(){
		Random rand = new Random();

		this.rank = Rank.pollRank(rand.nextInt(13) + 1);
		this.suit = Suit.pollSuit(rand.nextInt(4) + 1);
	}

	/**
	 * Class constructor. Creates a card of the specified rank and suit.
	 * @param newRank	The desired rank of the new card.
	 * @param newSuit	The desired suit of the new card.
	 */
	public Card(Rank newRank, Suit newSuit) {
		this.rank = newRank;
		this.suit = newSuit;
	}
	
	/**
	 * Class constructor. Creates a card of the specified rank and suit.
	 * @param newRank	The desired rank of the new card.
	 * @param newSuit	The desired suit of the new card.
	 * @throws IllegalArgumentException
	 */
	public Card(int newRank, int newSuit){
		if( newRank > 13 || newSuit > 4 || newRank < 1 || newSuit < 0)
			throw new IllegalArgumentException("Tried to create a card with bad values");
		
		this.rank = Rank.pollRank(newRank);
		this.suit = Suit.pollSuit(newSuit);
	}
	
	/**
	 * Class constructor. Creates a new card by doing a deep copy of the argument.
	 * @param copy	The card object to copy.
	 */
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
		
	/**
	 * Compares two cards, returning true if their rank and suit are equal and false otherwise.
	 * @param other The card to compare with.
	 * @return True if both cards rank and suit match, false otherwise.
	 */
	public boolean equals(Card other) {
		return (this.getRank() == other.getRank() && this.getSuit() == other.getSuit());
	}
		
	public String toString() {
		String info = new String();
		info += this.getRank() + " of " + this.getSuit();
		return info;
	}

}
