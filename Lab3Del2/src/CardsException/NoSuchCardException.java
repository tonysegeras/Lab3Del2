package CardsException;

public class NoSuchCardException extends java.lang.RuntimeException {
	
	private int index;
	
	private static final int NOT_AVAILABLE = -1;
	
	
	/**
	 * Class constructor. 
	 * @param msg 	A helpful error message.
	 */
	public NoSuchCardException(String msg){
		super(msg);
		index = NOT_AVAILABLE;
	}
	
	/**
	 * Class constructor. Takes a message and the index which was
	 * being accessed when the exception was thrown.
	 * @param msg	A helpful error message.
	 * @param index The index which was being accessed when the exception was thrown.
	 */
	public NoSuchCardException(String msg, int index){
		super(msg);
		this.index = index;
	}
	
	/**
	 * Returns the hopefully useful error message.
	 */
	public String getMessage(){
		if(index != NOT_AVAILABLE)
			return (this.getMessage() + " at index " + index);
		else return this.getMessage();
	}
	
	
	private static final long serialVersionUID = 1L;
}
