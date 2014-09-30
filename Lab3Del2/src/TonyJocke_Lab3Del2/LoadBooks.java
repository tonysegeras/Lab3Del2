package TonyJocke_Lab3Del2;

import java.io.*;

/**
 * Loads a collection of books from a specified file. 
 * If the file doesn't exist, a file with the specified 
 * name will be created.
 */
public class LoadBooks {
	
	/**
	 * Constructor.
	 */
	private LoadBooks(){}
	
	/**
	 * Loads a collection of books from the file specified with the string-parameter. 
	 * Creates a new file with the specified name if it does not exist.
	 * Loads from the file through a FileInputStream, reads the object with a ObjectInputStream, 
	 * then downcast the object to a ColleactionOfBooks-object. 
	 * @param from The filename the information will be loaded from, or created to 
	 * if the file does not exist.
	 * @return Returns a collection of books loaded from a file, or a empty collection of books if 
	 * if the specified file does not exist.
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static CollectionOfBooks load(String from) throws IOException, ClassNotFoundException{
		
		CollectionOfBooks library = new CollectionOfBooks();
		
		FileInputStream fis = null;
		try{
			fis = new FileInputStream(from);
			ObjectInputStream ois = new ObjectInputStream(fis);
			library = (CollectionOfBooks) ois.readObject();
			System.out.println("Deserialized successfully");
			
		} catch(FileNotFoundException e){
			System.out.println("Couldn't find any previous library files.");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			throw new IOException();
		} catch (ClassNotFoundException e) {
			System.out.println("Couldn't load the class... Here's the message: "+ e.getMessage());
			throw new ClassNotFoundException();
		}finally{
			try {
				if(fis != null)
					fis.close();
			} catch (IOException e) {
				// Do nothing...
			}
		}
		
		return library;
	}
}
