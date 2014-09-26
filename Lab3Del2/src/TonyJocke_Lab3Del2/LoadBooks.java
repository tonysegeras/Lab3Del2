package TonyJocke_Lab3Del2;

import java.io.*;

public class LoadBooks {
	
	private LoadBooks(){}
	
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
