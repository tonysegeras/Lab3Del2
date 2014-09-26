package TonyJocke_Lab3Del2;

import java.util.ArrayList;

public class CollectionOfBooks {
	private ArrayList<Book> theBooks;
	
	public CollectionOfBooks() {
		theBooks = new ArrayList<Book>();
	}
	
	public void addBook(Book book) {
		theBooks.add(new Book(book.returnIsbn(),book.returnTitle(),book.returnEdition(),book.returnPrice()));
	}
	
	
}
