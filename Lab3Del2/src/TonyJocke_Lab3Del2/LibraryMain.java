package TonyJocke_Lab3Del2;

import java.io.IOException;

public class LibraryMain {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		// Initialize
		CollectionOfBooks library = new CollectionOfBooks();
		
		// Load books
		String filename = args[0];
		LoadBooks.load(library, filename);
		
		// Begin main program execution
		UserInterface UI = new UserInterface();
		UI.menu(library);
		
		// Save books when user wants to quit
		SaveBooks.save(library, filename);
		
	}
}