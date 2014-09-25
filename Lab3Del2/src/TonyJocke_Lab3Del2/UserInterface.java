package TonyJocke_Lab3Del2;

import java.util.Scanner;

public class UserInterface {
	private String printedMenu;
	private Scanner scan;
	CollectionOfBooks Library;
	
	public UserInterface(){
		this.printedMenu = "Welcome, please choosen an option:\n" +
				"1: Add a book to the library.\n" +
				"2: Remove a book from the library" +
				"3: Search the library.\n" +
				"4: List all the books in the library.\n" +
				"5: Save and exit.\n";
		this.scan = new Scanner(System.in);
	}
	
	public void menu(){
		System.out.println(printedMenu);
		menuChoice();
	}
	
	public void menuChoice(){
		int choice = scan.nextInt();
			
		switch(choice){
			case 1:
				addBook();
				break;
				
			case 2:
				removeBook();
				break;
				
			case 3:
				search();
				break;
				
			case 4:
				list();
				break;
				
			case 5:
				// Save books then exit
				break;
				
			default:
				throw new IllegalArgumentException();
		}
	}
	
	public void addBook(){
		System.out.print("Enter the title: ");
		String title = scan.next();
		System.out.print("Enter the ISBN: ");
		String isbn = scan.next();
		System.out.print("Enter the edition: ");
		int edition = scan.nextInt();
		System.out.print("Enter the price: ");
		double price = scan.nextDouble();
		
		Book temp = new Book(isbn, title, edition, price);
//		Library.addBook(temp);
	}
	
	public void removeBook(){
		
	}
	
	public void search(){
		
	}
	
	public void list(){
		
	}
}
