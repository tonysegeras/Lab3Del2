package CardsException;

public class NoSuchCardException extends java.lang.RuntimeException {
	
	private int index;
	
	private static final int NOT_AVAILABLE = -1;
	
	@SuppressWarnings("unused")
	private NoSuchCardException(){} // Not allowed to create this exception without a message.
	
	public NoSuchCardException(String msg){
		super(msg);
		index = NOT_AVAILABLE;
	}
	
	public NoSuchCardException(String msg, int index){
		super(msg);
		this.index = index;
	}
	
	public String getMessage(){
		if(index != NOT_AVAILABLE)
			return (this.getMessage() + " at index " + index);
		else return this.getMessage();
	}
	
	
	private static final long serialVersionUID = 1L;
}
