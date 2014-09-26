package TonyJocke_Lab3Del2;

import java.io.*;

public class SaveBooks {
	
	private SaveBooks(){}
	
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
