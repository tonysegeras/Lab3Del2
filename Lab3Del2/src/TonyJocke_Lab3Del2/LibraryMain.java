package TonyJocke_Lab3Del2;

public class LibraryMain {
	public static void main(String[] args) {
		Book myNewBook = new Book("1234", "Lord of the flies", 1, 14.99);
		System.out.println(myNewBook.toString());
	}
}