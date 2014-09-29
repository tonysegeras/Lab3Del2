package CardsException;

//import first_part.Card;

public class Hand {
	private int score, noOfCards;
	private Card[] Cards;
	private boolean playing;
	
	public Hand(){
		this.score = 0;
		this.noOfCards = 0;
		this.Cards = new Card[52];
		this.playing = true;
	}
	
	public void addCard(Card newCard){
		this.Cards[noOfCards++] = new Card(newCard.getRank(), newCard.getSuit());
		this.calculatePoints();
	}
	/** Only removes the first occurrence of a card, therefore assumes only one deck of cards is in play. */
	public boolean removeCard(Card toRemove){
		for(int i = 0; i < noOfCards; i++)
			if( this.Cards[i].equals(toRemove) ){
				this.packHand(i);
				this.noOfCards--;
				this.calculatePoints();
				return true;
			}
		return false;
	}
	
	public int getScore(){
		return this.score;
	}
	public boolean isPlaying(){
		return this.playing;
	}
	public void stopPlaying(){
		this.playing = false;
	}
	
	/** Shifts all cards to the right of index one step left. */
	public void packHand(int index){
		for(int i = index; i < this.Cards.length; i++){
			this.Cards[i] = this.Cards[i+1]; 
		}
	}
	
	public String toString(){
		String info = new String();
		if(noOfCards > 0){
			info += "a hand containing ";
			for(int i = 0; i < noOfCards; i++)
				info += Cards[i].toString() + ", ";
		}
		info += "which is " + score + " points";
		return info;
	}
	
	/** Calculates the hands score. Cards 2 through 10 gives their values in points;
	 *  jacks, queens and kings each give 10 points and aces give either 10 points or 1
	 *  point depending on if it would raise the score above 21.
	 **/
	private void calculatePoints(){
		int score = 0, cardValue, noOfAces = 0;
		for(int i = 0; i < this.noOfCards; i++){
			cardValue = this.Cards[i].getRank();
			if(cardValue > 1 && cardValue <= 10)
				score += cardValue;
			else if(cardValue > 10)
				score += 10;
			else if(cardValue == 1){
				score += 10;
				noOfAces += 1;
			}
		}
		while(score > 21 && noOfAces > 0){
			score -= 9;
			noOfAces--;
		}
		this.score = score;
	}
}
