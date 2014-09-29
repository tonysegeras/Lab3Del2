package CardsException;

public class CardgameMain {
	public static void main(String[] args) {
		
		Card first = new Card();
		Card second = new Card(first);
		Card third = new Card();
		
		System.out.println(first.toString() + ", " + second.toString() + ", " + third. toString());
		System.out.println(first.compareTo(second) + ", " + second.compareTo(third));

	}
}
