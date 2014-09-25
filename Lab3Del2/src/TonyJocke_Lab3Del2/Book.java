package TonyJocke_Lab3Del2;

import java.util.ArrayList;

public class Book implements Comparable<Book> {
	private String isbn;
	private String title;
	private int edition;
	private double price;
	private ArrayList<Author> authors;
	
	public Book(String isbn, String title, int edition, double price) {
		this.isbn = new String(isbn);
		this.title = new String(title);
		this.edition = edition;
		this.price = price;
		authors = new ArrayList<Author>();
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
		// TODO Auto-generated method stub
		return 0;
	}


}
