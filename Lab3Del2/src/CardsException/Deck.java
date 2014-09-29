package CardsException;

import java.util.Random;

public class Deck {
	private Card[] Deck;
	private int cardsLeft;
	private final int capacity;
	
	/** Create a standard deck of 52 cards */
	public Deck(){
		this.capacity = 52;
		this.cardsLeft = 52;
		this.Deck = new Card[52];
		
		createNewCards();
	}
	
	/** Create a custom deck with an arbitrary amount of cards */
	public Deck(int noOfCards){
		this.capacity = noOfCards;
		this.cardsLeft = noOfCards;
		this.Deck = new Card[noOfCards];
		
		createNewCards();
	}
	
	/** Returns a card from the top of the deck. */
	public Card Deal() throws NoSuchCardException{
		if(cardsLeft < 1)
			throw new NoSuchCardException();

		Card temp = new Card(this.Deck[cardsLeft-1].getRank(), this.Deck[cardsLeft-1].getSuit() );
		cardsLeft--;
		return temp;
	}
	
	/** Pseudo-randomly shuffle the deck by stepping through the array and swapping cards. */
	public void shuffle(){
		Random rand = new Random();
		
		for(int i = 0; i < this.cardsLeft; i++){
			int other = rand.nextInt(this.cardsLeft);
			
			Card temp = new Card(Deck[i].getRank(), Deck[i].getSuit());
			this.Deck[i] = new Card(Deck[other].getRank(), Deck[other].getSuit());
			this.Deck[other] = new Card(temp.getRank(), temp.getSuit());
		}
	}
	
	/** Fill the deck with shuffled cards. */
	private void createNewCards(){
		for(int i = 0; i < this.capacity; i++)
			this.Deck[i] = new Card((i % 13)+1, (i/13)+1);
		this.cardsLeft = this.capacity;
		this.shuffle();
	}
	
	public String toString(){
		String info = new String();
		for(int i = 0; i < this.cardsLeft; i++)
			info += this.Deck[i].toString() + " ";
		return info;
	}
}
