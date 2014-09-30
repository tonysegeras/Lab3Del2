package CardsException;

import java.util.Arrays;

public class BlackjackPlayer extends Hand{
	private int score, aces;
	private boolean playing;
	
	public BlackjackPlayer(){
		super();
		this.playing = true;
		this.score = 0;
		this.aces = 0;
	}
	
	public boolean isPlaying(){
		return this.playing;
	}
	
	public void stopPlaying(){
		this.playing = false;
	}
	
	public int getScore(){
		return this.score;
	}
	
	public String printHand(){
		String info = "";
		for(int i = 0; i < this.noOfCards; i++)
			info += Cards[i].toString() + ", ";
		return info;
	}
	
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
