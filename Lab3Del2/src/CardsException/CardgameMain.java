package CardsException;

import java.util.Scanner;

public class CardgameMain {
	public static void main(String[] args) {
		BlackjackPlayer dealer = new BlackjackPlayer();
		BlackjackPlayer player = new BlackjackPlayer();
		Deck DeckOfCards = new Deck();
		Scanner scan = new Scanner(System.in);
		String choice;
		
		boolean first_round = true;
		
		while(player.isPlaying() || dealer.isPlaying()){
			if(first_round == true){
				player.addCard(DeckOfCards.Deal());
				first_round = false;
			}
			
			if(player.isPlaying()){
				player.addCard(DeckOfCards.Deal());
				player.calculateScore();
				System.out.println("You got: " + player.printHand() + " ; " + player.getScore() + " points!");
				if(player.getScore() > 21){
					System.out.println("You got fat, you lose!");
					player.stopPlaying();
					dealer.stopPlaying();
				}
			}
			
			if(dealer.isPlaying()){
				
				try{
					dealer.addCard(DeckOfCards.Deal());
				}catch(NoSuchCardException e){
					DeckOfCards = new Deck();
					dealer.addCard(DeckOfCards.Deal());
				}
				
				dealer.calculateScore();
				System.out.println("The dealer got: " + dealer.printHand() + " ; " + dealer.getScore() + " points!");
				if(dealer.getScore() > 16){
					dealer.stopPlaying();
					if(dealer.getScore() > 21){
						System.out.println("The dealer got fat, you win!");
						player.stopPlaying();
					}
					else{
						System.out.println("The dealer stops playing.");
					}
				}
			}
			
			if(player.isPlaying()){
				System.out.println("Would you like another card (y/n)? ");
				choice = scan.next();
				
				if(choice.equals("n") || choice.equals("N"))
					player.stopPlaying();
				else if(choice.equals("y") || choice.equals("Y"))
					;
				else
					System.out.println("Didn't recognize input.");
			}
		}
		
		if(dealer.getScore() > 21 || ((player.getScore() > dealer.getScore()) && player.getScore() < 22) )
			System.out.println("You won! " + dealer.getScore() + " vs " + player.getScore());
		else
			System.out.println("The dealer won! " + dealer.getScore() + " vs " + player.getScore());
		scan.close();
	}
}
