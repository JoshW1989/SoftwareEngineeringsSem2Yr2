package Users;

public class WrongUserException extends Exception{
	
	
    public WrongUserException (String errorMessage) {
        super(errorMessage);
    }

}
