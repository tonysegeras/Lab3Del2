package TonyJocke_Lab3Del2;

import java.io.IOException;

public class LibraryMain {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		// Initialize
		CollectionOfBooks library = new CollectionOfBooks();
		String filename = "";
		
		// Load books
		if(args.length == 1){
			filename = args[0];
			library = LoadBooks.load(filename);
		}
		else{
			System.out.println("Error, please invoke with a file name as argument (ex: library.ser).");
			System.exit(0);
		}
		
		// Begin main program execution
		UserInterface UI = new UserInterface();
		UI.menu(library);
		
		// Save books when user wants to quit
		SaveBooks.save(library, filename);	
	}
}