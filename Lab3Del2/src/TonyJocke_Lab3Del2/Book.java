package TonyJocke_Lab3Del2;

import java.io.Serializable;
import java.util.ArrayList;

public class Book implements Comparable<Book>, Serializable {
	private String isbn;
	private String title;
	private int edition;
	private double price;
	private ArrayList<Author> authors;

	public Book(String isbn, String title, int edition, double price,
			ArrayList<Author> authorAdd) {
		this.isbn = new String(isbn);
		this.title = new String(title);
		this.edition = edition;
		this.price = price;
		authors = new ArrayList<Author>();
		for (int i = 0; i < authorAdd.size(); i++) {
			authors.add(new Author(authorAdd.get(i).returnAuthor()));
		}
	}

	public void addAuthor(String author) {
		authors.add(new Author(author));
	}
	
	

	public ArrayList<Author> getAuthors() {
		ArrayList<Author> copy = authors;
		return copy;
	}

	public String returnIsbn() {
		String info = this.isbn;
		return info;
	}

	public String returnTitle() {
		String info = this.title;
		return info;
	}

	public int returnEdition() {
		return this.edition;
	}

	public double returnPrice() {
		return this.price;
	}

	public int compareTo(Book other) {
		int res = this.returnTitle().compareTo(other.returnTitle());
		
		return res;
	}

	public String toString() {

		String info = "Title: " + this.returnTitle() + "; Author(s): ";
		for (int i = 0; i < authors.size(); i++) {
			info += authors.get(i).returnAuthor();
			if(i != authors.size()-1)
				info += ", ";
		}
		info += "; Edition: " + this.edition + "; ISBN: " + this.isbn
				+ "; Price: " + this.price + "$";
		return info;
	}
	
	private static final long serialVersionUID = 1L;
}
