package TonyJocke_Lab3Del2;

import java.util.Scanner;

public class UserInterface {
	private String printedMenu;
	private Scanner scan;
	
	public UserInterface(){
		this.printedMenu = "Welcome, please choosen an option:\n" +
				"1: Add a book to the library.\n" +
				"2: Remove a book from the library" +
				"3: Search the library for a title.\n" +
				"4: Search the library.\n" +
				"5: List all the books in the library.\n" +
				"6: Save and exit.\n";
		this.scan = new Scanner(System.in);
	}
	
	public void printMenu(){
		System.out.println(printedMenu);
	}
	
	public void menuChoice(){
		int choice = scan.nextInt();
		if(choice > 6 || choice < 1)
			throw new IllegalArgumentException();
		
		switch(choice){
			case 1:
				
		}
	}
}
