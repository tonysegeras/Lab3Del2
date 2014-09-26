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
		Collections.sort(theBooks);
		ArrayList<Book> listToReturn = new ArrayList<Book>();

		for (int i = 0; i < theBooks.size(); i++) {
			listToReturn
					.add(new Book(theBooks.get(i).returnIsbn(), theBooks.get(i)
							.returnTitle(), theBooks.get(i).returnEdition(),
							theBooks.get(i).returnPrice(), theBooks.get(i)
									.getAuthors()));
		}

		return listToReturn;
	}

	public void removeBook() {

	}

	public ArrayList<Book> searchBookByTitle(String searchedTitle) {

		return;
	}

	public ArrayList<Book> searchBookByIsbn(String searchedISBN) {

		return;
	}

	public ArrayList<Book> searchBookByAuthor(String searchedAuthor) {

		return;
	}
}
