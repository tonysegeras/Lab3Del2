package TonyJocke_Lab3Del2;

import java.io.Serializable;

public class Author implements Serializable {
	
	private String name;
	
	public Author(String name) {
		this.name = new String(name);
	}
	
	public void setAuthor(String name){
		this.name = name;
	}
	
	public String getAuthor() {
		String info = this.name;
		return info;
	}
	
	public String toString() {
		String info = this.name;
		return info;
	}
	
	private static final long serialVersionUID = 1L;
}
