package TonyJocke_Lab3Del2;

import java.io.*;

public class LoadBooks {
	
	private LoadBooks(){}
	
	public static void load(CollectionOfBooks to, String from) throws IOException, ClassNotFoundException{
		
		FileInputStream fis = null;
		try{
			fis = new FileInputStream(from);
			ObjectInputStream ois = new ObjectInputStream(fis);
			to = (CollectionOfBooks) ois.readObject();
			
		} catch(FileNotFoundException e){
			System.out.println("Couldn't find any previous library files."); // Vad göra annars? Vill ju inte att programmet kraschar direkt...
		} catch (IOException e) {
			System.out.println(e.getMessage());
			throw new IOException();
		} catch (ClassNotFoundException e) {
			System.out.println("Couldn't load the class... Here's the message: "+ e.getMessage());
			throw new ClassNotFoundException();
		}finally{
			try {
				fis.close();
			} catch (IOException e) {
				// Do nothing...
			}
		}	
	}
}
