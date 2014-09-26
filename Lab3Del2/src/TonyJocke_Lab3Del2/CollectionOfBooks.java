package TonyJocke_Lab3Del2;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionOfBooks {
	private ArrayList<Book> theBooks;

	public CollectionOfBooks() {
		theBooks = new ArrayList<Book>();
	}

	public void addBook(Book book) {
		theBooks.add(book);
	}

	public ArrayList<Book> getBooksByTitle(String title) {
		ArrayList<Book> listToReturn = new ArrayList<Book>();
		for(int i=0; i<theBooks.size();i++) 
			if(theBooks.get(i).returnTitle().contains(title) || theBooks.get(i).returnTitle().equalsIgnoreCase(title)) 
				listToReturn.add(theBooks.get(i));
		
		Collections.sort(listToReturn);

		return listToReturn;
	}

	public void removeBook(Book book) {
		this.theBooks.remove(book);
	}

	public ArrayList<Book> getBooksByIsbn(String searchedISBN) {
		ArrayList<Book> listToReturn = new ArrayList<Book>();
		for(int i=0; i<theBooks.size();i++) {
			if(theBooks.get(i).returnIsbn().contains(searchedISBN)) {
				listToReturn.add(theBooks.get(i));

			}
		}
		
		Collections.sort(listToReturn);

		
		return listToReturn;
	}

	public ArrayList<Book> getBooksByAuthor(String searchedAuthor) {
		ArrayList<Book> listToReturn = new ArrayList<Book>();

		for(int i=0; i<theBooks.size();i++) 
			for(int j=0;j<theBooks.get(i).getAuthors().size();j++) 			
				if(theBooks.get(i).getAuthors().get(j).returnAuthor().equalsIgnoreCase(searchedAuthor) 
						|| theBooks.get(i).getAuthors().get(j).returnAuthor().equalsIgnoreCase(searchedAuthor))
					listToReturn.add(theBooks.get(i));

		Collections.sort(listToReturn);
		
		return listToReturn;
	} 

	public String toString(){
		String info = theBooks.size() + " Books.\n";
		for(Book b : theBooks)
			info += b.toString() + "\n";
		return info;
	}
	
}
