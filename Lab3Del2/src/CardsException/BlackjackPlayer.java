package CardsException;

public class BlackjackPlayer extends Hand{
	private int score, aces;
	private boolean playing;
	
	/**
	 * Class constructor.
	 */
	public BlackjackPlayer(){
		super();
		this.playing = true;
		this.score = 0;
		this.aces = 0;
	}
	
	/**
	 * Returns the players status.
	 * @return True if the player is still playing, false otherwise.
	 */
	public boolean isPlaying(){
		return this.playing;
	}
	
	public void stopPlaying(){
		this.playing = false;
	}
	
	public int getScore(){
		return this.score;
	}
	
	/**
	 * Returns a string representation of the players hand.
	 * @return A string of the players hand.
	 */
	public String printHand(){
		String info = "";
		for(int i = 0; i < this.noOfCards; i++)
			info += Cards[i].toString() + ", ";
		return info;
	}
	
	/**
	 * Calculates the score of the players hand according to simplified
	 * Black Jack rules.
	 * <p>
	 * Aces are either 1 or 11 points, 2 through 10 are worth their rank
	 * and the face cards are worth 10 points.
	 * <p>
	 * When called this method updates the players score once.
	 */
	public void calculateScore(){
		this.score = 0;
		for(int i = 0; i < noOfCards; i++){
			if(Cards[i].getRank().getRank() > 1 && Cards[i].getRank().getRank() < 11)
				this.score += Cards[i].getRank().getRank();
			else if(Cards[i].getRank().getRank() > 10 && Cards[i].getRank().getRank() < 14)
				this.score += 10;
			else if(Cards[i].getRank().getRank() == 1){
				this.score += 1;
				this.aces ++;
			}
		}
		if(this.score < 11 && this.aces > 0)
			this.score += 10;
	}
}
