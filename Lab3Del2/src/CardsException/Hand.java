package CardsException;

public class Hand {
	protected int noOfCards;
	protected Card[] Cards;
	
	public Hand(){
		this.noOfCards = 0;
		this.Cards = new Card[52];
	}
	
	public void addCard(Card newCard){
		this.Cards[noOfCards++] = new Card(newCard.getRank(), newCard.getSuit());
	}
	
	/** Only removes the first occurrence of a card, therefore assumes only one deck of cards is in play. */
	public boolean removeCard(Card toRemove){
		for(int i = 0; i < noOfCards; i++)
			if( this.Cards[i].equals(toRemove) ){
				this.packHand(i);
				this.noOfCards--;
				return true;
			}
		return false;
	}
	
	/** Shifts all cards to the right of index one step left. */
	public void packHand(int index){
		for(int i = index; i < this.Cards.length; i++){
			this.Cards[i] = this.Cards[i+1]; 
		}
	}
	
	public Card[] getCards(){
		Card[] temp = new Card[this.noOfCards];
		for(int i = 0; i < this.noOfCards; i++)
			temp[i] = new Card(this.Cards[i]);
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
