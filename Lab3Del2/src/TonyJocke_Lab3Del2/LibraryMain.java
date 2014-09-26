package TonyJocke_Lab3Del2;

public class LibraryMain {
	public static void main(String[] args) {
		
		// Initialize
		CollectionOfBooks library = new CollectionOfBooks();
		
		// Load books
		String filename = args[0];
		
		
		// Begin main program execution
		UserInterface UI = new UserInterface();
		UI.menu(library);
		
		// Save books when user wants to quit
		
		
	}
}