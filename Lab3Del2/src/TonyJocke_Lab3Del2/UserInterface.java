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
				"2: Remove a book from the library.\n" +
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
				throw new IllegalArgumentException("Menu only accepts integers 1-5");
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
		
		String author = "";
		while(author.length() == 0)
			author = scan.nextLine();
		
		Book temp = new Book(isbn, title, edition, price, authorsInAList(author));
		library.addBook(temp);
	}
	
	private ArrayList<Author> authorsInAList(String author) {
		ArrayList<Author> authorToTemp = new ArrayList<Author>();
		
		String[] parts = author.split(", ");
		for (String part : parts) {
			authorToTemp.add(new Author(part));
		}
		
		return authorToTemp;
	}
	
	public void removeBook(CollectionOfBooks library){
		
		if(library.containsBooks()){
		
		ArrayList<Book> potentialBooks = search(library);
		
		if(potentialBooks.size() > 1){
			System.out.print("Which one would you like to delete? (Enter index): ");
			for(int i = 0; i < potentialBooks.size(); i++)
				System.out.println((i+1)+ ": " + potentialBooks.get(i).toString());
		}
		int toRemove = scan.nextInt() - 1;
		library.removeBook(potentialBooks.get(toRemove));
		}
		else
			System.out.println("Your library contains no books.");
	}
	
	public ArrayList<Book> search(CollectionOfBooks library){

		System.out.println("What would you like to search the library by?\n" +
				"1: Title.\n" +
				"2: Author.\n" +
				"3: ISBN.");
		int input = scan.nextInt();
		
		ArrayList<Book> foundBooks = new ArrayList<Book>();
		
		switch(input){
			case TITLE:
				System.out.println("Please enter the title: ");
				foundBooks  = library.getBooksByTitle(scan.next());
				printBooks(foundBooks);
				break;
				
			case AUTHOR:
				System.out.println("Please enter the author: ");
				foundBooks  = library.getBooksByAuthor(scan.next());
				printBooks(foundBooks);
				break;
				
			case ISBN:
				System.out.println("Please enter the ISBN: ");
				foundBooks  = library.getBooksByIsbn(scan.next());
				printBooks(foundBooks);
				break;
			  
			default:
				throw new IllegalArgumentException("Only accepts integers 1-3 as arguments");
		}
		
		return foundBooks;
	}
	
	public void list(CollectionOfBooks library){
		System.out.println("Your library contains: ");
		System.out.println(library.toString());
	}
	
	private void printBooks(ArrayList<Book> list) {
		String info = "Found " + list.size()+ " books.\n";
		for(Book b : list)
			info += b.toString() + "\n";
		System.out.println(info);
	}
}
