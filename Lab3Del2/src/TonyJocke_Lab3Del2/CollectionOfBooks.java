package TonyJocke_Lab3Del2;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionOfBooks implements Comparable<Book> {
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
			if(theBooks.get(i).returnTitle().contains(title)) 
				listToReturn.add(theBooks.get(i));
		
		Collections.sort(listToReturn);

		return listToReturn;
	}

	public void removeBook(Book book) {
		theBooks.remove(book);
	}

	public ArrayList<Book> getBooksByIsbn(String searchedISBN) {
		ArrayList<Book> listToReturn = new ArrayList<Book>();
		for(int i=0; i<theBooks.size();i++) {
			if(theBooks.get(i).returnIsbn().contains(searchedISBN)) {
				listToReturn.add(theBooks.get(i));

			}
		}
		
		return listToReturn;
	}

	public ArrayList<Book> getBooksByAuthor(String searchedAuthor) {
		ArrayList<Book> listToReturn = new ArrayList<Book>();

		for(int i=0; i<theBooks.size();i++) 
			for(int j=0;j<theBooks.get(i).getAuthors().size();j++) 			
				if(theBooks.get(i).getAuthors().get(j).returnAuthor().equals(searchedAuthor)) 		
					listToReturn.add(theBooks.get(i));

		return listToReturn;
	} 

	public String toString(){
		String info = "A library object containing " + theBooks.size() + " books.\n";
		for(Book b : theBooks)
			info += b.toString() + "\n";
		return info;
	}

	public int compareTo(Book other) {
		
		return this.compareTo(other);
	}
}
