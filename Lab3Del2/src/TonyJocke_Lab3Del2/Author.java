package TonyJocke_Lab3Del2;

import java.io.Serializable;

/**
 * Represents an author of a book. Is Serializable.
 */
public class Author implements Serializable {

	private String name;

	/**
	 * Constructor making an author with the specified name.
	 * @param name the name the author gets
	 */
	public Author(String name) {
		this.name = new String(name);
	}
	
	/**
	 * Void-method to set an authors name.
	 * @param name the name the author gets
	 */
	public void setAuthor(String name) {
		this.name = name;
	}

	/**
	 * Method for getting the authors name. 
	 * @return a string representation of the name
	 */
	public String getAuthor() {
		String info = this.name;
		return info;
	}

	/**
	 * Method to print out the name of the author to a string.
	 * @return a string representation of the name
	 */
	public String toString() {
		String info = this.name;
		return info;
	}

	private static final long serialVersionUID = 1L;
}
