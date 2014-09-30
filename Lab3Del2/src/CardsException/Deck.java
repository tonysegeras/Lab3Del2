package CardsException;

import java.util.Arrays;
import java.util.Random;

/**
 * A deck of cards.
 * 
 * 
 * 
 * 
 *
 */

public class Deck {
	private Card[] Deck;
	private int cardsLeft;
	
	/** 
	 * Class constructor.
	 * Create a standard deck of 52 cards 
	 */
	public Deck(){
		this.cardsLeft = 52;
		this.Deck = new Card[52];
		
		this.createNewCards();
		this.shuffle();
	}
	
	/** 
	 * Class constructor specifying number of cards in the deck object.
	 * @param noOfCards	The amount of cards the new deck will contain.
	 */
	public Deck(int noOfCards){
		this.cardsLeft = noOfCards;
		this.Deck = new Card[noOfCards];
		
		createNewCards();
		this.shuffle();
	}
	
	/** 
	 * Returns a card from the deck and decreases number of cards in the deck.
	 * @return The card which was dealt from the deck.
	 * @throws NoSuchCardException
	 */
	public Card Deal(){
		if(cardsLeft < 1)
			throw new NoSuchCardException("Tried to deal a card but the deck was empty.");

		Card temp = new Card(this.Deck[cardsLeft-1].getRank(), this.Deck[cardsLeft-1].getSuit() );
		cardsLeft--;
		return temp;
	}
	
	/** 
	 * Removes a card at the specified index. 
	 * @param	index	The index of the card to remove in the deck.
	 * @return			true if the card at index was removed.
	 * @throws 			NoSuchCardException
	 */
	public boolean removeCard(int index){
		if(index > cardsLeft)
			throw new NoSuchCardException("Couldn't remove card", index);
		else{
			this.pack(index);
			return true;
		}
	}
	/**
	 * Removes the card given as an argument.
	 * @param 	card	The card to remove.
	 * @return			True if the card was removed.
	 * @throws			NoSuchCardException
	 */
	public boolean removeCard(Card card) {
		for(int i = 0; i < this.Deck.length; i++)
			if(Deck[i].equals(card)){
				this.pack(i);
				return true;
			}
		
		throw new NoSuchCardException(card.toString() + " has already been dealt.");
	}
	
	/** Pseudo-randomly shuffle the deck by stepping through the array and swapping cards. 
	 *  
	 */
	public void shuffle(){
		Random rand = new Random();
		
		for(int i = 0; i < this.cardsLeft; i++){
			int other = rand.nextInt(this.cardsLeft);
			
			Card temp = new Card(Deck[i].getRank(), Deck[i].getSuit());
			this.Deck[i] = new Card(Deck[other].getRank(), Deck[other].getSuit());
			this.Deck[other] = new Card(temp.getRank(), temp.getSuit());
		}
	}
	
	/** 
	 * Fill the deck with sorted cards. 
	 *  
	 */
	private void createNewCards(){
		for(int i = 0; i < this.Deck.length; i++)
			this.Deck[i] = new Card((i % 13)+1, (i/13)+1);
	}
	
	/** 
	 * Removes the card at index and moves every card after it one step down into the array. 
	 * @param index	Specifies at which index the pack should start.
	 * */
	private void pack(int index){
		for(int i = index; i < Deck.length; i++)
			Deck[i] = Deck[i+1];
		cardsLeft--;
	}
	
	public String toString(){
		String info = new String();
		for(int i = 0; i < this.cardsLeft; i++)
			info += this.Deck[i].toString() + "\n";
		return info;
	}
	/** 
	 * */
	public String printSortedDeck(){
		Arrays.sort(Deck,new BlackjackSort());
		return this.toString();
	}
	
	public String printSortedDeckbySuit(){
		Arrays.sort(Deck,new SortBySuit());
		return this.toString();
	}
}