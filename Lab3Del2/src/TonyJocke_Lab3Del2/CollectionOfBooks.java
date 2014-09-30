package TonyJocke_Lab3Del2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A object representing a list of books.
 */
public class CollectionOfBooks implements Comparable<Book>, Serializable {
	private ArrayList<Book> theBooks;

	/**
	 * Constructor, creates a ArrayList of books.
	 */
	public CollectionOfBooks() {
		theBooks = new ArrayList<Book>();
	}

	/**
	 * Adds a book to the list of books.
	 * @param book adds a book to the ArrayList of books
	 */
	public void addBook(Book book) {
		theBooks.add(book);
	}

	/**
	 * Makes a temporary ArrayList of books that is searched for by title and then sorted. 
	 * Makes the titles and authors of the books to lower case-letters in a temporary ArrayList
	 * so that the search doesn't have to be case sensitive. Then adds the books to the ArrayList 
	 * and the list gets sorted before returning it. 
	 * @param title The title the book(s) is searched for
	 * @return Returns a ArrayList with books based on the search, the list is sorted alphabetically.
	 */
	public ArrayList<Book> getBooksByTitle(String title) {
		
		ArrayList<Book> temp = new ArrayList<Book>();
		for(Book b : theBooks)
			temp.add(new Book(b));
		for(Book b: temp)
			b.toLowerCase();
		
		ArrayList<Book> listToReturn = new ArrayList<Book>();
		for(int i=0; i<theBooks.size();i++) 
			if(temp.get(i).getTitle().contains(title)) 
				listToReturn.add(theBooks.get(i));
		
		Collections.sort(listToReturn);

		return listToReturn;
	}

	/**
	 * Removes the specific book from the list of books.
	 * @param book The specified book that will be deleted
	 */
	public void removeBook(Book book) {
		theBooks.remove(book);
	}

	/**
	 * Makes a temporary ArrayList of books that is searched for by ISBN and then sorted. 
	 * Adds the books to the ArrayList and the list gets sorted before returning it. 
	 * @param searchedISBN The ISBN-code the book(s) is searched for
	 * @return Returns a ArrayList with books based on the search.
	 */
	public ArrayList<Book> getBooksByIsbn(String searchedISBN) {	
		ArrayList<Book> listToReturn = new ArrayList<Book>();
		for(int i=0; i<theBooks.size();i++) 
			if(theBooks.get(i).getIsbn().contains(searchedISBN)) 
				listToReturn.add(theBooks.get(i));
		
		Collections.sort(listToReturn);
		
		return listToReturn;
	}

	/**
	 * Makes a temporary ArrayList of books that is searched for by author and then sorted. 
	 * Makes the searched author string and the titles and authors of the books to lower case-letters in a temporary ArrayList
	 * so that the search doesn't have to be case sensitive. Then adds the books to the ArrayList 
	 * and the list gets sorted before returning it.
	 * @param searchedAuthor The author the book(s) is searched for
	 * @return Returns a ArrayList with books based on the search.
	 */
	public ArrayList<Book> getBooksByAuthor(String searchedAuthor) {
		
		ArrayList<Book> temp = new ArrayList<Book>();
		for(Book b : theBooks)
			temp.add(new Book(b));
		for(Book b: temp)
			b.toLowerCase();
		
		searchedAuthor = searchedAuthor.toLowerCase();
		
		ArrayList<Book> listToReturn = new ArrayList<Book>();
		for(int i=0; i<theBooks.size();i++) 
			for(int j=0;j<theBooks.get(i).getAuthors().size();j++) 			
				if(temp.get(i).getAuthors().get(j).getAuthor().contains(searchedAuthor)) 		
					listToReturn.add(theBooks.get(i));

		Collections.sort(listToReturn);
		
		return listToReturn;
	} 

	/**
	 * Method to print out information of the book collection. Prints number of books 
	 * and the information of every book.
	 * @return Returns a String representation of the collection of books.
	 */
	public String toString(){
		String info = theBooks.size() + " books.\n";
		for(Book b : theBooks)
			info += b.toString() + "\n";
		return info;
	}

	/**
	 * Compares this book to another book.
	 * @return Returns an integer based on the return of the books compareTo-method.
	 */
	public int compareTo(Book other) {
		return this.compareTo(other);
	}
	
	/**
	 * Checking if the ArrayList of books is containing any books.
	 * @return Returns a boolean if there are any books in the ArrayList.
	 */
	public boolean containsBooks(){
		return (theBooks.size() > 0);
	}
	
	private static final long serialVersionUID = 1L;
}
