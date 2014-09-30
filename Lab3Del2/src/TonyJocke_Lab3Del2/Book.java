package TonyJocke_Lab3Del2;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Objects of this class is used in a library of books
 *
 */
public class Book implements Comparable<Book>, Serializable {
	private String isbn;
	private String title;
	private int edition;
	private double price;
	private ArrayList<Author> authors;

	/**
	 * Constructor for setting up a book by giving parameters.
	 * @param isbn to set the ISBN of the book
	 * @param title to set the title of the book
	 * @param edition to set the edition of the book
	 * @param price to set the price of the book
	 * @param authorAdd gives an Arraylist of authors to set to the book 
	 */
	public Book(String isbn, String title, int edition, double price,
			ArrayList<Author> authorAdd) {
		this.isbn = new String(isbn);
		this.title = new String(title);
		this.edition = edition;
		this.price = price;
		authors = new ArrayList<Author>();
		for (int i = 0; i < authorAdd.size(); i++) {
			authors.add(new Author(authorAdd.get(i).getAuthor()));
		}
	}
	
	/**
	 * Constructor for setting up a book from a book object.
	 * @param book the book that the book take it's information from to set up the book
	 */
	public Book(Book book) {
		this.isbn = new String(book.getIsbn());
		this.title = new String(book.getTitle());
		this.edition = book.getEdition();
		this.price = book.price;
		
		authors = new ArrayList<Author>();
		for(Author a : book.authors)
			this.authors.add(new Author(a.getAuthor()));
	}
	
	/**
	 * Sets the title of the book and the name of the authors of the book to lower case letters.
	 */
	public void toLowerCase(){
		this.title.toLowerCase();
		for(Author a: authors)
			a.setAuthor( a.getAuthor().toLowerCase() );
	}

	/**
	 * Sends a string to a method that creates an author object to the list of authors.
	 * @param author the string parameter that sets the name of the author to the book
	 */
	public void addAuthor(String author) {
		authors.add(new Author(author));
	}

	/**
	 * Gets a list of the authors of the book.
	 * @return Returns an ArrayList reference of the authors of the book
	 */
	public ArrayList<Author> getAuthors() {
		ArrayList<Author> copy = authors;
		return copy;
	}

	/**
	 * Gets the ISBN of the book.
	 * @return Returns a String reference of the ISBN of the book
	 */
	public String getIsbn() {
		String info = this.isbn;
		return info;
	}

	/**
	 * Gets the title of the book.
	 * @return Returns a String reference of the title of the book
	 */
	public String getTitle() {
		String info = this.title;
		return info;
	}

	/**
	 * Gets the edition of the book.
	 * @return Returns the edition of the book as an integer
	 */
	public int getEdition() {
		return this.edition;
	}

	/**
	 * Gets the price of the book.
	 * @return Returns the price of the book as a double.
	 */
	public double returnPrice() {
		return this.price;
	}

	/**
	 * Compares this book to another book .
	 * @param other the other book that will be compared to
	 * @return Returns an integer, positive if the books are equal, negative if not.
	 */
	public int compareTo(Book other) {
		int res = this.getTitle().compareTo(other.getTitle());
		
		return res;
	}

	/**
	 * Method to print out all the information of the book.
	 * @return Returns a String representation of the book.
	 */
	public String toString() {

		String info = "Title: " + this.getTitle() + "; Author(s): ";
		for (int i = 0; i < authors.size(); i++) {
			info += authors.get(i).getAuthor();
			if(i != authors.size()-1)
				info += ", ";
		}
		info += "; Edition: " + this.edition + "; ISBN: " + this.isbn
				+ "; Price: " + this.price + "$";
		return info;
	}
	
	private static final long serialVersionUID = 1L;
}
