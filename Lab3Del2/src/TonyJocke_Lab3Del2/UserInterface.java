package TonyJocke_Lab3Del2;

import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {
	private String printedMenu;
	private Scanner scan;
	
	// Main menu
	public static final int ADD = 1,
							REMOVE = 2,
							SEARCH = 3,
							LIST = 4,
							EXIT = 5;
	
	// Search menu
	public static final int TITLE = 1,
							AUTHOR = 2,
							ISBN = 3;
	
	public UserInterface(){
		this.printedMenu = 
				"Welcome, please choose an option:\n" +
				"1: Add a book to the library.\n" +
				"2: Remove a book from the library" +
				"3: Search the library.\n" +
				"4: List all the books in the library.\n" +
				"5: Save and exit.\n";
		this.scan = new Scanner(System.in);
	}
	
	public void menu(CollectionOfBooks library){
		int x = 0;
		while(x != 5){
			System.out.println(printedMenu);
			x = menuChoice(library);
		}
		System.out.println("Thank you for using the Tony&Joakim proprietary library software system.\nHave a nice day!");
	}
	
	public int menuChoice(CollectionOfBooks library){
		int choice = scan.nextInt();
			
		switch(choice){
			case ADD:
				addBook(library);
				break;
				
			case REMOVE:
				removeBook(library);
				break;
				
			case SEARCH:
				search(library).toString();
				break;
				
			case LIST:
				list(library);
				break;
				
			case EXIT:
				// Save books then exit
				break;
				
			default:
				throw new IllegalArgumentException();
		}
		return choice;
	}
	
	public void addBook(CollectionOfBooks library){
		System.out.print("Enter the title: ");
		String title = scan.next();
		System.out.print("Enter the ISBN: ");
		String isbn = scan.next();
		System.out.print("Enter the edition: ");
		int edition = scan.nextInt();
		System.out.print("Enter the price: ");
		double price = scan.nextDouble();
		System.out.print("Enter the authors(s) (separated by ,): ");
		String author = scan.next();
		
		Book temp = new Book(isbn, title, edition, price, author);
		library.addBook(temp);
	}
	
	public void removeBook(CollectionOfBooks library){
		
	}
	
	public ArrayList<Book> search(CollectionOfBooks library){

		System.out.println("What would you like to search the library by?\n" +
				"1: Title.\n" +
				"2: Main author.\n" +
				"3: ISBN.");
		int input = scan.nextInt();
		
		ArrayList<Book> foundBooks = new ArrayList<Book>();
		
		switch(input){
			case TITLE:
				System.out.println("Please enter the title: ");
				foundBooks  = library.getBooksByTitle(scan.next());
				break;
				
			case AUTHOR:
				System.out.println("Please enter the author: ");
				foundBooks  = library.getBooksByAuthor(scan.next());
				break;
				
			case ISBN:
				System.out.println("Please enter the ISBN: ");
				foundBooks  = library.getBooksByIsbn(scan.next());
				break;
			
			default:
				throw new IllegalArgumentException("Only accepts integers 1-3 as arguments");
		}
		
		return foundBooks;
	}
	
	public void list(CollectionOfBooks library){
		System.out.println("Your library contains: ");
		library.toString();
	}
}
