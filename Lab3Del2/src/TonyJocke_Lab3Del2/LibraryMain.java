package TonyJocke_Lab3Del2;

import java.util.ArrayList;

public class LibraryMain {
	public static void main(String[] args) {
		
		//Tests
		ArrayList<Author> newAuthor = new ArrayList<Author>();
		newAuthor.add(new Author("William Golding"));
		Book myNewBook = new Book("1234", "Lord of the flies", 1, 14.99, newAuthor);
		System.out.println(myNewBook.toString());
		
		// Create stuff & load books
		CollectionOfBooks library = new CollectionOfBooks();
		
		UserInterface UI = new UserInterface();
		UI.menu(library);
		
		// Save books
		System.out.println(library.toString());
	}
}