package TonyJocke_Lab3Del2;

public class LibraryMain {
	public static void main(String[] args) {
		
		//Tests
		Book myNewBook = new Book("1234", "Lord of the flies", 1, 14.99, "William Golding");
		System.out.println(myNewBook.toString());
		
		// Create stuff & load books
		CollectionOfBooks library = new CollectionOfBooks();
		
		UserInterface UI = new UserInterface();
		UI.menu(library);
		
		// Save books
		
	}
}