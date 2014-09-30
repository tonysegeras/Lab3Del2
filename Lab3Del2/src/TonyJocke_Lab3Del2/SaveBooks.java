package TonyJocke_Lab3Del2;

import java.io.*;

/**
 * Saving the books in a library to a file.
 */
public class SaveBooks {
	
	/**
	 * Constructor.
	 */
	private SaveBooks(){}
	
	/**
	 * The method that saves the books information from a library to a specified file.
	 * Writes to a file from a ObjectOutputStream through a FileOutputStream.
	 * @param from The CollectionOfBooks-object that will be saved to file. 
	 * @param to The filename to save the information to.
	 */
	public static void save(CollectionOfBooks from, String to){
		FileOutputStream fos = null;
		try{
			fos = new FileOutputStream(to);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(from);
			System.out.println("Serialized successfully");
			
		} catch(FileNotFoundException e){
			System.out.println("Couldn't find any previous library files."); // Vad göra annars? Vill ju inte att programmet kraschar direkt...
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(fos != null)
					fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
