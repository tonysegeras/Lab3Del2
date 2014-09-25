package TonyJocke_Lab3Del2;

import java.util.ArrayList;

public class CollectionOfBooks {
	private ArrayList<Book> theBooks;
	
	public CollectionOfBooks() {
		theBooks = new ArrayList<Book>();
	}
	
	public void addBook(Book book) {
		theBooks.add(book);
	}
	
	public ArrayList<Book> getBooksByTitle(String title) {
		
		return ;
	}
	
	public void removeBook() {
		
	}
	
	public ArrayList<Book> searchBookByTitle(String searchedTitle) {
		
		return ;
	}
	
	public ArrayList<Book> searchBookByIsbn(String searchedISBN) {
		
		return ;
	}
	
	public ArrayList<Book> searchBookByAuthor(String searchedAuthor) {
		
		return ; 
	}
	
}
