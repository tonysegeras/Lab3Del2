package CardsException;

public class Hand {
	protected int noOfCards;
	protected Card[] Cards;

	/**
	 * Class constructor. Creates a hand with enough space to hold 52 playing cards.
	 */
	public Hand(){
		this.noOfCards = 0;
		this.Cards = new Card[52];
	}
	
	/**
	 * Adds the card argument to the hand.
	 * @param newCard The card to add.
	 */
	public void addCard(Card newCard){
		this.Cards[noOfCards++] = new Card(newCard.getRank(), newCard.getSuit());
	}
	
	/**
	 * Removes all occurrences of the card argument from the hand.
	 * @param toRemove	A copy of the card to remove.
	 * @return 			True if a card was removed.
	 * @throws NoSuchCardException
	 */
	public boolean removeCard(Card toRemove){
		if(noOfCards < 1)
			throw new NoSuchCardException("Can't remove cards from an empty hand.");
		for(int i = 0; i < noOfCards; i++)
			if( this.Cards[i].equals(toRemove) ){
				this.packHand(i);
				return true;
			}
		throw new NoSuchCardException("Couldn't find " + toRemove.toString() + " in the hand.");
	}
	
	/**
	 * Decrements all objects indices with index above the argument.
	 * @param index	
	 */
	private void packHand(int index){
		for(int i = index; i < this.Cards.length; i++){
			this.Cards[i] = this.Cards[i+1]; 
		}
		this.noOfCards--;
	}
	
	/**
	 * Returns a copy of the hands card array.
	 * @return A copy of the hands card array.
	 */
	public Card[] getCards(){
		Card[] temp = new Card[this.noOfCards];
		for(int i = 0; i < this.noOfCards; i++)
			temp[i] = new Card((Card) this.Cards[i]);
		return temp;
	}
	
	public String toString(){
		String info = new String();
		if(noOfCards > 0){
			info += "a hand containing ";
			for(int i = 0; i < noOfCards; i++)
				info += Cards[i].toString() + ", ";
		}
		return info;
	}
}
