package CardsException;

public class NoSuchCardException extends java.lang.RuntimeException {
	
	private NoSuchCardException(){}
	
	public NoSuchCardException(String msg){
		super(msg);
	}

	private static final long serialVersionUID = 1L;
}
