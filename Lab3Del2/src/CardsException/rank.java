package CardsException;

public enum rank{
	ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7),
	EIGTH(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);
	
	private int rank;
	
	rank(int rank){
		this.rank = rank;
	}
	
	public int getRank(){
		return this.rank;
	}
	
	public static rank pollRank(int index){
		switch(index){
		case 1: 
			return ACE;
		case 2: 
			return TWO;
		case 3: 
			return THREE;
		case 4: 
			return FOUR;
		case 5: 
			return FIVE;
		case 6: 
			return SIX;
		case 7: 
			return SEVEN;
		case 8: 
			return EIGTH;
		case 9: 
			return NINE;
		case 10: 
			return TEN;
		case 11: 
			return JACK;
		case 12: 
			return QUEEN;
		case 13: 
			return KING;
		default:
			return null;
		}
	}
}